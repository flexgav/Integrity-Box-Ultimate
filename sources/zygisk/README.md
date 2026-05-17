# Zygisk Native Sources

Place the source code for the native Zygisk libraries here.

The client module currently ships these compiled artifacts:

- `IntegrityBox-Ultimate-Clnt/zygisk/arm64-v8a.so`
- `IntegrityBox-Ultimate-Clnt/zygisk/armeabi-v7a.so`
- `IntegrityBox-Ultimate-Clnt/zygisk/x86_64.so`
- `IntegrityBox-Ultimate-Clnt/zygisk/x86.so`

Recommended layout:

- `src/` - C/C++ source files.
- `include/` - local headers.
- `build/` - build scripts or reproducible build notes, not generated output.
- `patches/` - local diffs if the code is based on an upstream project.

Document the NDK version, compiler flags, upstream base commit, and exact build command before publishing a release.
