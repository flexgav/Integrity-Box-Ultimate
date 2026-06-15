// First-party source (IntegrityBox, PlayIntegrityFork lineage).
// KeyStoreSpi shim: delegates to the real AndroidKeyStore SPI but refuses the
// key certificate chain when DroidGuard asks for it (blocks hardware key
// attestation). Registered by name via CustomProvider — keep the class
// reachable (see proguard-rules.pro / sources/dex/README.md).
package es.chiteroman.playintegrityfix;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

public final class CustomKeyStoreSpi extends KeyStoreSpi {
    public static volatile KeyStoreSpi keyStoreSpi;

    // R1: the delegate is set by EntryPoint.spoofProvider() before this provider
    // is installed, so it is normally non-null. Guard against a pathological
    // early/raced call instead of throwing a bare NullPointerException.
    private static KeyStoreSpi spi() {
        KeyStoreSpi s = keyStoreSpi;
        if (s == null) {
            EntryPoint.LOGE("keyStoreSpi not initialized");
            throw new IllegalStateException("AndroidKeyStore SPI unavailable");
        }
        return s;
    }

    @Override
    public Key engineGetKey(String alias, char[] password) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        return spi().engineGetKey(alias, password);
    }

    @Override
    public Certificate[] engineGetCertificateChain(String alias) {
        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
            if (e.getClassName().toLowerCase(Locale.ROOT).contains("droidguard")) {
                EntryPoint.LOG("DroidGuard detected!");
                throw new UnsupportedOperationException();
            }
        }
        return spi().engineGetCertificateChain(alias);
    }

    @Override
    public Certificate engineGetCertificate(String alias) {
        return spi().engineGetCertificate(alias);
    }

    @Override
    public Date engineGetCreationDate(String alias) {
        return spi().engineGetCreationDate(alias);
    }

    @Override
    public void engineSetKeyEntry(String alias, Key key, char[] password, Certificate[] chain) throws KeyStoreException {
        spi().engineSetKeyEntry(alias, key, password, chain);
    }

    @Override
    public void engineSetKeyEntry(String alias, byte[] key, Certificate[] chain) throws KeyStoreException {
        spi().engineSetKeyEntry(alias, key, chain);
    }

    @Override
    public void engineSetCertificateEntry(String alias, Certificate cert) throws KeyStoreException {
        spi().engineSetCertificateEntry(alias, cert);
    }

    @Override
    public void engineDeleteEntry(String alias) throws KeyStoreException {
        spi().engineDeleteEntry(alias);
    }

    @Override
    public Enumeration<String> engineAliases() {
        return spi().engineAliases();
    }

    @Override
    public boolean engineContainsAlias(String alias) {
        return spi().engineContainsAlias(alias);
    }

    @Override
    public int engineSize() {
        return spi().engineSize();
    }

    @Override
    public boolean engineIsKeyEntry(String alias) {
        return spi().engineIsKeyEntry(alias);
    }

    @Override
    public boolean engineIsCertificateEntry(String alias) {
        return spi().engineIsCertificateEntry(alias);
    }

    @Override
    public String engineGetCertificateAlias(Certificate cert) {
        return spi().engineGetCertificateAlias(cert);
    }

    @Override
    public void engineStore(OutputStream stream, char[] password) throws CertificateException, IOException, NoSuchAlgorithmException {
        spi().engineStore(stream, password);
    }

    @Override
    public void engineLoad(InputStream stream, char[] password) throws CertificateException, IOException, NoSuchAlgorithmException {
        spi().engineLoad(stream, password);
    }
}
