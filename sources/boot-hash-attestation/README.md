# Boot Hash Attestation Helper Sources

Place the source code for the Boot Hash Java/Dex helper here.

The client module currently ships this compiled artifact:

- `IntegrityBox-Ultimate-Clnt/webroot/common_scripts/BootHashAttestation/boot_attest.jar`

Recommended layout:

- `src/` - Java/Kotlin source files.
- `build/` - build scripts or reproducible build notes, not generated output.
- `patches/` - local diffs if the helper is based on an upstream project.

Document the Android API level, Java/Kotlin toolchain, dependencies, and exact command used to produce `boot_attest.jar`.
