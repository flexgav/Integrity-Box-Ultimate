# Spoofing dex — first-party Java sources

First-party Java source of the spoofing engine that the native module
(`sources/zygisk/src/main.cpp`) injects into target processes via
`InMemoryDexClassLoader`. Compiled to `classes.dex` (Java counterpart of the
zygisk `.so`).

## Layout

- `java/es/chiteroman/playintegrityfix/`
  - `EntryPoint.java` — GMS/DroidGuard entry: `receiveJson` + `init`, Build
    spoof, KeyStore provider swap, package signature spoof.
  - `EntryPointVending.java` — Play Store (vending) entry: `init` (fingerprint /
    Build fields / `SDK_INT`).
  - `CustomProvider.java`, `CustomKeyStoreSpi.java` — AndroidKeyStore JCA shim.
  - `CustomPackageInfoCreator.java` — package signature swap.
- `proguard-rules.pro` — R8 keep rules (the JNI/JCA contract surface).

## JNI / dex contract (do NOT break)

`main.cpp` loads `classes.dex` and calls these by name and exact descriptor:

| Class (package `es.chiteroman.playintegrityfix`) | Method | Descriptor |
| --- | --- | --- |
| `EntryPoint` | `receiveJson` | `(Ljava/lang/String;)V` |
| `EntryPoint` | `init` | `(IIII)V` — verbose, build, provider, signature |
| `EntryPointVending` | `init` | `(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V` — verbose, finger, sdk, fpValue, manuf, model, device, brand |

Class names, method names/descriptors and the package are kept by
`proguard-rules.pro`. Changing any of them requires a matching edit to the two
`className`/`GetStaticMethodID` sites in `main.cpp` and a `zygisk-buildkit`
rebuild of the `.so`.

## Divergence from upstream

- **No third-party dependency.** Upstream uses
  `org.lsposed.hiddenapibypass:hiddenapibypass`. Here the hidden-API lift is
  inlined in `EntryPoint.liftHiddenApiRestrictions()` (meta-reflection →
  `dalvik.system.VMRuntime#setHiddenApiExemptions(["L"])`). The dex carries no
  `org.lsposed.*` classes.
- **Shared `Logger`** (`Logger.java`) replaces the duplicated static
  `LOG/LOGI/LOGE` scaffolding in `EntryPoint` / `EntryPointVending`.
- **Shared `BuildFields`** (`BuildFields.java`) unifies the reflective
  `android.os.Build` / `Build.VERSION` writers (was `setField` /
  `setBuildField` / `spoofSdkInt`) and **caches** resolved `Field`s.
- **`spoofDevice()` applies once per profile** — a guard makes the repeated
  calls from `CustomProvider.getService()` (every KeyStore lookup) a no-op;
  `receiveJson()` resets the guard for a re-injected profile.
- **`CustomKeyStoreSpi`** guards a null delegate (`spi()`) instead of throwing a
  bare `NullPointerException`.
- Behaviour is otherwise that of the PlayIntegrityFork (chiteroman lineage) Java.
  These helpers are internal (not in the JNI contract) and may be inlined by R8.

## Building

Use the standalone build kit at the repo root — no Android Studio / Gradle:

```
dex-buildkit/build_dex.ps1 -FetchTools
```

It compiles these sources with `javac` and runs **R8** (matching the upstream
`minifyReleaseWithR8` release pipeline) to produce `dex-buildkit/out/classes.dex`.
See `dex-buildkit/README.md` for prerequisites and details.

## Build environment (record per release)

- **JDK:** 21+ (compiled with `--release 21`, matching upstream
  `sourceCompatibility = VERSION_21`).
- **compileSdk:** 36 (any `android.jar` >= API 28 works for compilation).
- **minSdk / d8 `--min-api`:** 26.
- **Upstream base:** PlayIntegrityFork (chiteroman / osm0sis lineage).
