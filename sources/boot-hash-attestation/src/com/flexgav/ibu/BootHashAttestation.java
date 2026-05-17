package com.flexgav.ibu;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.ECGenParameterSpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class BootHashAttestation {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    private static final String ATTESTATION_OID = "1.3.6.1.4.1.11129.2.1.17";
    private static final String LOG_DIR = "/data/adb/Box-Brain/Integrity-Box-Logs";
    private static final String LOG_FILE = LOG_DIR + "/boot_hash_attestation.log";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private static PrintWriter sLogWriter;

    private BootHashAttestation() {
    }

    public static void main(String[] args) {
        try {
            File dir = new File(LOG_DIR);
            if (!dir.exists()) dir.mkdirs();
            // Keep autoflush enabled so crash diagnostics are not lost.
            sLogWriter = new PrintWriter(new FileWriter(LOG_FILE, true), true);
        } catch (Throwable ignored) {}

        String alias = "ibu_boot_hash_" + System.currentTimeMillis();
        byte[] challenge = ("ibu-boot-hash-" + alias).getBytes(StandardCharsets.UTF_8);

        log("");
        log("========== BootHashAttestation run started ==========");
        log("SDK_INT=" + Build.VERSION.SDK_INT + ", RELEASE=" + Build.VERSION.RELEASE);
        log("Alias=" + alias);
        log("Challenge length=" + challenge.length);

        KeyStore keyStore = null;
        try {
            logSecurityProviders("before AndroidKeyStore install");
            ensureAndroidKeyStoreProviderInstalled();
            logSecurityProviders("after AndroidKeyStore install");

            log("Loading KeyStore provider: " + ANDROID_KEYSTORE);
            keyStore = KeyStore.getInstance(ANDROID_KEYSTORE);
            keyStore.load(null);
            log("KeyStore loaded successfully");

            log("Creating KeyPairGenerator: algorithm=" + KeyProperties.KEY_ALGORITHM_EC);
            KeyPairGenerator generator = KeyPairGenerator.getInstance(
                    KeyProperties.KEY_ALGORITHM_EC,
                    ANDROID_KEYSTORE
            );
            KeyGenParameterSpec spec = new KeyGenParameterSpec.Builder(
                    alias,
                    KeyProperties.PURPOSE_SIGN | KeyProperties.PURPOSE_VERIFY
            )
                    .setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1"))
                    .setDigests(KeyProperties.DIGEST_SHA256)
                    .setAttestationChallenge(challenge)
                    .build();

            log("Initializing generator: curve=secp256r1, digest=SHA-256, purposes=SIGN|VERIFY");
            generator.initialize(spec);
            log("Generating temporary attested key pair");
            generator.generateKeyPair();
            log("Key pair generated");

            Certificate[] chain = keyStore.getCertificateChain(alias);
            log("Certificate chain length=" + (chain == null ? "null" : String.valueOf(chain.length)));
            if (chain == null || chain.length == 0) {
                throw new IllegalStateException("Attestation certificate chain is empty");
            }

            for (int i = 0; i < chain.length; i++) {
                Certificate certificate = chain[i];
                log("Certificate[" + i + "] type=" + certificate.getType());
                if (!(certificate instanceof X509Certificate)) {
                    log("Certificate[" + i + "] skipped: not X509Certificate");
                    continue;
                }

                X509Certificate x509 = (X509Certificate) certificate;
                logCertificate(i, x509);

                byte[] extension = x509.getExtensionValue(ATTESTATION_OID);
                log("Certificate[" + i + "] attestation extension length="
                        + (extension == null ? "null" : String.valueOf(extension.length)));
                if (extension == null) {
                    continue;
                }

                byte[] hash = extractVerifiedBootHash(extension);
                if (hash != null && hash.length > 0) {
                    String hex = toHex(hash);
                    log("verifiedBootHash extracted successfully: length=" + hash.length);
                    System.out.println("RESULT|" + hex);
                    return;
                }
                log("Certificate[" + i + "] did not contain a usable verifiedBootHash");
            }

            throw new IllegalStateException("verifiedBootHash was not found in attestation extension");
        } catch (Throwable t) {
            log("ERROR: " + t.getClass().getName() + ": " + safeMessage(t));
            logStackTrace(t);
            System.out.println("ERROR|" + t.getClass().getSimpleName() + ": " + safeMessage(t));
            t.printStackTrace(System.out);
        } finally {
            try {
                if (keyStore != null) {
                    log("Deleting temporary KeyStore entry: " + alias);
                    keyStore.deleteEntry(alias);
                    log("Temporary KeyStore entry deleted");
                }
            } catch (Throwable cleanupError) {
                log("Cleanup failed: " + cleanupError.getClass().getName() + ": " + safeMessage(cleanupError));
            }
            log("========== BootHashAttestation run finished ==========");
            
            if (sLogWriter != null) sLogWriter.close();
        }
    }

    private static byte[] extractVerifiedBootHash(byte[] encodedExtension) {
        log("Parsing attestation extension wrapper");
        DerElement outerOctet = DerElement.read(encodedExtension, 0);
        logElement("Extension outer", outerOctet);
        if (!outerOctet.isUniversal(4)) {
            throw new IllegalArgumentException("Attestation extension wrapper is not an OCTET_STRING");
        }

        byte[] keyDescriptionBytes = outerOctet.value();
        log("KeyDescription raw length=" + keyDescriptionBytes.length);
        DerElement keyDescription = DerElement.read(keyDescriptionBytes, 0);
        logElement("KeyDescription", keyDescription);
        if (!keyDescription.isUniversal(16)) {
            throw new IllegalArgumentException("Attestation extension body is not a SEQUENCE");
        }

        DerElement[] fields = DerElement.children(keyDescription);
        log("KeyDescription field count=" + fields.length);
        for (int i = 0; i < fields.length; i++) {
            logElement("KeyDescription[" + i + "] " + keyDescriptionFieldName(i), fields[i]);
            logSimpleValue("KeyDescription[" + i + "]", fields[i]);
        }
        if (fields.length < 8) {
            throw new IllegalArgumentException("Attestation KeyDescription is incomplete");
        }

        log("Trying teeEnforced AuthorizationList first");
        byte[] hash = extractFromAuthorizationList(fields[7], "teeEnforced");
        if (hash != null) {
            return hash;
        }

        log("Trying softwareEnforced AuthorizationList as fallback");
        return extractFromAuthorizationList(fields[6], "softwareEnforced");
    }

    private static byte[] extractFromAuthorizationList(DerElement authorizationList, String listName) {
        if (authorizationList == null) {
            log(listName + " is null");
            return null;
        }
        logElement(listName, authorizationList);
        if (!authorizationList.isUniversal(16)) {
            log(listName + " skipped: expected SEQUENCE");
            return null;
        }

        DerElement[] items = DerElement.children(authorizationList);
        log(listName + " item count=" + items.length);
        for (DerElement item : items) {
            logElement(listName + " tag", item);
            if (item.tagClass == DerElement.CLASS_CONTEXT && item.tagNumber == 704) {
                log(listName + " contains rootOfTrust tag [704]");
                return extractFromRootOfTrust(item.value(), listName);
            }
        }
        log(listName + " does not contain rootOfTrust tag [704]");
        return null;
    }

    private static byte[] extractFromRootOfTrust(byte[] encodedRootOfTrust, String listName) {
        log(listName + ".rootOfTrust encoded length=" + encodedRootOfTrust.length);
        DerElement rootOfTrust = DerElement.read(encodedRootOfTrust, 0);
        logElement(listName + ".rootOfTrust", rootOfTrust);
        if (!rootOfTrust.isUniversal(16)) {
            log(listName + ".rootOfTrust skipped: expected SEQUENCE");
            return null;
        }

        DerElement[] fields = DerElement.children(rootOfTrust);
        log(listName + ".rootOfTrust field count=" + fields.length);
        for (int i = 0; i < fields.length; i++) {
            logElement(listName + ".rootOfTrust[" + i + "] " + rootOfTrustFieldName(i), fields[i]);
            logRootOfTrustValue(listName + ".rootOfTrust[" + i + "]", i, fields[i]);
        }

        if (fields.length < 4) {
            log(listName + ".rootOfTrust has no verifiedBootHash field");
            return null;
        }
        if (!fields[3].isUniversal(4)) {
            log(listName + ".rootOfTrust verifiedBootHash has unexpected tag: " + fields[3].tagSummary());
            return null;
        }
        return fields[3].value();
    }

    private static void logCertificate(int index, X509Certificate certificate) {
        log("Certificate[" + index + "] subject=[REDACTED]");
        log("Certificate[" + index + "] issuer=[REDACTED]");
        log("Certificate[" + index + "] serial=[REDACTED]");
        log("Certificate[" + index + "] sigAlg=" + certificate.getSigAlgName());
        log("Certificate[" + index + "] notBefore=" + certificate.getNotBefore()
                + ", notAfter=" + certificate.getNotAfter());
        log("Certificate[" + index + "] publicKeyAlg=" + certificate.getPublicKey().getAlgorithm());
    }

    private static void ensureAndroidKeyStoreProviderInstalled() {
        Provider existing = Security.getProvider(ANDROID_KEYSTORE);
        if (existing != null) {
            log("AndroidKeyStore provider already registered: " + existing.getClass().getName());
            return;
        }

        String[] providerInstallers = {
                "android.security.keystore2.AndroidKeyStoreProvider",
                "android.security.keystore.AndroidKeyStoreProvider"
        };

        for (String installerClass : providerInstallers) {
            try {
                log("Trying AndroidKeyStore provider installer: " + installerClass);
                Class<?> clazz = Class.forName(installerClass);
                java.lang.reflect.Method install = clazz.getDeclaredMethod("install");
                install.setAccessible(true);
                install.invoke(null);

                Provider installed = Security.getProvider(ANDROID_KEYSTORE);
                if (installed != null) {
                    log("AndroidKeyStore provider installed through " + installerClass
                            + ": " + installed.getClass().getName());
                    return;
                }
                log("Installer completed but AndroidKeyStore provider is still missing: " + installerClass);
            } catch (Throwable t) {
                log("Provider installer failed: " + installerClass + " -> "
                        + t.getClass().getName() + ": " + safeMessage(t));
            }
        }
    }

    private static void logSecurityProviders(String stage) {
        Provider[] providers = Security.getProviders();
        log("Security providers " + stage + ": count=" + providers.length);
        for (Provider provider : providers) {
            log("Provider: " + provider.getName() + " / " + provider.getClass().getName());
        }
    }

    private static void logSimpleValue(String name, DerElement element) {
        if (element.isUniversal(2) || element.isUniversal(10)) {
            log(name + " value=" + element.asUnsignedLong());
        } else if (element.isUniversal(4)) {
            log(name + " octets length=" + element.valueLength + " [REDACTED]");
        }
    }

    private static void logRootOfTrustValue(String name, int index, DerElement element) {
        if (index == 0 && element.isUniversal(4)) {
            log(name + " verifiedBootKey length=" + element.valueLength + " [REDACTED]");
        } else if (index == 1 && element.isUniversal(1)) {
            log(name + " deviceLocked=" + element.asBoolean());
        } else if (index == 2 && element.isUniversal(10)) {
            long state = element.asUnsignedLong();
            log(name + " verifiedBootState=" + state + " (" + bootStateName(state) + ")");
        } else if (index == 3 && element.isUniversal(4)) {
            log(name + " verifiedBootHash length=" + element.valueLength + " [REDACTED]");
        } else {
            logSimpleValue(name, element);
        }
    }

    private static String keyDescriptionFieldName(int index) {
        switch (index) {
            case 0:
                return "attestationVersion";
            case 1:
                return "attestationSecurityLevel";
            case 2:
                return "keymasterVersion";
            case 3:
                return "keymasterSecurityLevel";
            case 4:
                return "attestationChallenge";
            case 5:
                return "uniqueId";
            case 6:
                return "softwareEnforced";
            case 7:
                return "teeEnforced";
            default:
                return "extra";
        }
    }

    private static String rootOfTrustFieldName(int index) {
        switch (index) {
            case 0:
                return "verifiedBootKey";
            case 1:
                return "deviceLocked";
            case 2:
                return "verifiedBootState";
            case 3:
                return "verifiedBootHash";
            default:
                return "extra";
        }
    }

    private static String bootStateName(long state) {
        if (state == 0) return "VERIFIED";
        if (state == 1) return "SELF_SIGNED";
        if (state == 2) return "UNVERIFIED";
        if (state == 3) return "FAILED";
        return "UNKNOWN";
    }

    private static void logElement(String name, DerElement element) {
        log(name + ": " + element.tagSummary()
                + ", constructed=" + element.constructed
                + ", valueOffset=" + element.valueOffset
                + ", valueLength=" + element.valueLength
                + ", nextOffset=" + element.nextOffset);
    }

    private static String toHex(byte[] data) {
        char[] hexChars = new char[data.length * 2];
        for (int j = 0; j < data.length; j++) {
            int v = data[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static String safeMessage(Throwable t) {
        String message = t.getMessage();
        return message == null ? "no message" : message.replace('\n', ' ').replace('\r', ' ');
    }

    private static void log(String message) {
        if (sLogWriter != null) {
            String ts = DATE_FORMAT.format(new Date());
            sLogWriter.println("[" + ts + "] " + message);
        }
    }

    private static void logStackTrace(Throwable throwable) {
        if (sLogWriter != null) {
            throwable.printStackTrace(sLogWriter);
        }
    }

    private static final class DerElement {
        static final int CLASS_UNIVERSAL = 0x00;
        static final int CLASS_APPLICATION = 0x40;
        static final int CLASS_CONTEXT = 0x80;
        static final int CLASS_PRIVATE = 0xc0;

        final byte[] source;
        final int tagClass;
        final int tagNumber;
        final boolean constructed;
        final int valueOffset;
        final int valueLength;
        final int nextOffset;

        private DerElement(
                byte[] source,
                int tagClass,
                int tagNumber,
                boolean constructed,
                int valueOffset,
                int valueLength,
                int nextOffset
        ) {
            this.source = source;
            this.tagClass = tagClass;
            this.tagNumber = tagNumber;
            this.constructed = constructed;
            this.valueOffset = valueOffset;
            this.valueLength = valueLength;
            this.nextOffset = nextOffset;
        }

        static DerElement read(byte[] data, int offset) {
            if (data == null || offset < 0 || offset >= data.length) {
                throw new IllegalArgumentException("DER offset is outside data");
            }

            int cursor = offset;
            int first = data[cursor++] & 0xff;
            int tagClass = first & 0xc0;
            boolean constructed = (first & 0x20) != 0;
            int tagNumber = first & 0x1f;

            if (tagNumber == 0x1f) {
                tagNumber = 0;
                int next;
                do {
                    if (cursor >= data.length) {
                        throw new IllegalArgumentException("Truncated DER high tag number");
                    }
                    next = data[cursor++] & 0xff;
                    tagNumber = (tagNumber << 7) | (next & 0x7f);
                } while ((next & 0x80) != 0);
            }

            if (cursor >= data.length) {
                throw new IllegalArgumentException("Truncated DER length");
            }

            int lengthByte = data[cursor++] & 0xff;
            int length;
            if ((lengthByte & 0x80) == 0) {
                length = lengthByte;
            } else {
                int lengthBytes = lengthByte & 0x7f;
                if (lengthBytes == 0 || lengthBytes > 4 || cursor + lengthBytes > data.length) {
                    throw new IllegalArgumentException("Unsupported DER length form");
                }
                length = 0;
                for (int i = 0; i < lengthBytes; i++) {
                    length = (length << 8) | (data[cursor++] & 0xff);
                }
            }

            if (length < 0 || cursor + length > data.length) {
                throw new IllegalArgumentException("DER value is truncated");
            }

            return new DerElement(data, tagClass, tagNumber, constructed, cursor, length, cursor + length);
        }

        static DerElement[] children(DerElement parent) {
            if (!parent.constructed) {
                return new DerElement[0];
            }

            DerElement[] result = new DerElement[8];
            int count = 0;
            int cursor = parent.valueOffset;
            int end = parent.valueOffset + parent.valueLength;
            while (cursor < end) {
                DerElement child = read(parent.source, cursor);
                if (child.nextOffset > end) {
                    throw new IllegalArgumentException("DER child extends past parent");
                }
                if (count == result.length) {
                    DerElement[] expanded = new DerElement[result.length * 2];
                    System.arraycopy(result, 0, expanded, 0, result.length);
                    result = expanded;
                }
                result[count++] = child;
                cursor = child.nextOffset;
            }

            DerElement[] compact = new DerElement[count];
            System.arraycopy(result, 0, compact, 0, count);
            return compact;
        }

        boolean isUniversal(int expectedTag) {
            return tagClass == CLASS_UNIVERSAL && tagNumber == expectedTag;
        }

        byte[] value() {
            byte[] out = new byte[valueLength];
            System.arraycopy(source, valueOffset, out, 0, valueLength);
            return out;
        }

        boolean asBoolean() {
            return valueLength > 0 && source[valueOffset] != 0;
        }

        long asUnsignedLong() {
            long out = 0;
            int end = Math.min(valueLength, 8);
            for (int i = 0; i < end; i++) {
                out = (out << 8) | (source[valueOffset + i] & 0xffL);
            }
            return out;
        }

        String tagSummary() {
            return tagClassName(tagClass) + " tag=" + tagNumber + " (" + universalName() + ")";
        }

        private String universalName() {
            if (tagClass != CLASS_UNIVERSAL) {
                return "context/application/private";
            }
            switch (tagNumber) {
                case 1:
                    return "BOOLEAN";
                case 2:
                    return "INTEGER";
                case 4:
                    return "OCTET_STRING";
                case 5:
                    return "NULL";
                case 6:
                    return "OBJECT_IDENTIFIER";
                case 10:
                    return "ENUMERATED";
                case 16:
                    return "SEQUENCE";
                case 17:
                    return "SET";
                default:
                    return "UNIVERSAL_" + tagNumber;
            }
        }

        private static String tagClassName(int tagClass) {
            if (tagClass == CLASS_UNIVERSAL) return "UNIVERSAL";
            if (tagClass == CLASS_APPLICATION) return "APPLICATION";
            if (tagClass == CLASS_CONTEXT) return "CONTEXT";
            if (tagClass == CLASS_PRIVATE) return "PRIVATE";
            return "UNKNOWN_CLASS_" + tagClass;
        }
    }
}
