# Boot Hash Attestation Helper Sources

Place the source code for the Boot Hash Java/Dex helper here.

In the installed module, the compiled artifact lives at (`$MODDIR` = `/data/adb/modules/playintegrityfix`):

- `/data/adb/modules/playintegrityfix/common_scripts/BootHashAttestation/boot_attest.jar`

Recommended layout:

- `src/` - Java/Kotlin source files.
- `build/` - build scripts or reproducible build notes, not generated output.
- `patches/` - local diffs if the helper is based on an upstream project.

Document the Android API level, Java/Kotlin toolchain, dependencies, and exact command used to produce `boot_attest.jar`.
