// First-party source (IntegrityBox, PlayIntegrityFork lineage).
// Play Store (vending) entry point: spoofs Build fields / SDK_INT in the Play
// Store process. init(...) is invoked from native (main.cpp) by name+signature
// — do NOT change the signature (see sources/dex/README.md).
//
// Divergence from upstream: logging via the shared Logger (S1) and Build-field
// writes via BuildFields (S2 + P2 field cache).
package es.chiteroman.playintegrityfix;

public final class EntryPointVending {
    private static final Logger log = new Logger("PIF/Java:PS");

    public static void init(int verbose, int spoofVendingFinger, int spoofVendingSdk,
                           String vendingFingerprintValue, String pixelManufacturer,
                           String pixelModel, String pixelDevice, String pixelBrand) {
        log.level = verbose;
        log.i("init verbose=" + verbose + " finger=" + spoofVendingFinger + " sdk=" + spoofVendingSdk);
        if (spoofVendingSdk > 0) {
            BuildFields.set("SDK_INT", "29", log);
            if (spoofVendingFinger < 1 && (isEmpty(pixelManufacturer) || isEmpty(pixelModel) || isEmpty(pixelDevice))) {
                log.d("missing pixel fields");
                return;
            }
        }
        if (spoofVendingFinger > 0 && !isEmpty(vendingFingerprintValue)) {
            BuildFields.set("FINGERPRINT", vendingFingerprintValue, log);
        }
        BuildFields.set("BRAND", pixelBrand, log);
        BuildFields.set("MANUFACTURER", pixelManufacturer, log);
        BuildFields.set("MODEL", pixelModel, log);
        BuildFields.set("DEVICE", pixelDevice, log);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
