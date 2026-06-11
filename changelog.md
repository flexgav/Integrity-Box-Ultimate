> Release Date: 11/06/2026

#### 🚀 IntegrityBox Ultimate v42.0

- **First-run setup reworked**: the initial setup flow is now split into safe automatic steps and optional advanced steps. In Manual mode, sensitive stages are confirmed with Vol+/Vol- prompts; in Auto mode, defaults are applied without extra interaction.
- **Metamodule and mount compatibility**: improved handling for KernelSU/APatch mount setups. The module now sets protective mount markers and the diagnostic report checks Mountify plus other metamodule-style solutions.
- **Execution locks for critical tasks**: Action, AutoPilot, PIF handling, Target updates, Keybox synchronization, and tool downloads are protected from duplicate parallel execution. Repeated starts now detect active work, stale locks, and stuck processes instead of running a second cycle over the first one.
- **Safer updates**: before installing an update, the module stops old runtime workers so code from the previous version does not continue running alongside the new installation.
- **Target Box pipeline**: target list handling is now centralized. `target.txt` generation supports scheduled refresh, cached/local fallback, current-file backup, and Manual mode protection. Reports now include Target Box status, `target.txt` contents, and the file itself without duplicating the same data in JSON.
- **PIF Processing 2.0**: PIF handling is now a single managed flow. Pool update and profile application timestamps are separated (`last_pif_check`, `last_pif_pool_update`, `last_pif_applied`), so AutoPilot can schedule by the actual applied profile while Status still reflects the active local file.
- **Keybox synchronization rebuilt**: provider sync now has clearer diagnostics, provider-level logs, cache preservation, local XML import, deduplication, cleanup of stale entries, and protection against parallel sync runs.
- **Tool downloader rebuilt**: tool downloads are now a separate controlled stage with list validation, checksum verification, explicit return codes, and a dedicated diagnostic log.
- **Structured diagnostics**: runtime and service scripts now use structured file logs with level, stage, event, return code, and message fields. Terminal output for installer and Action has been unified and cleaned up.
- **Boot and runtime reliability**: post-boot, background, uninstall, and verification stages now expose clearer return codes and fewer silent failures. AutoPilot watchdog handling, timeout checks, stale process cleanup, and runtime marker cleanup were improved.
- **Expanded report package**: reports now include metamodule state, Target Box state, PIF/security patch state, companion module status, raw/effective TEE state, and diagnostic log copies.
- **Status and WebUI updates**: Status now shows PIF source, metadata state, TEE state, companion modules, CDN/network diagnostics, and active-file state more clearly. UI cards and shared components were polished, including automatic-height behavior for profile/mode blocks.
- **General cleanup**: bundled PIF pool updated, module icon refreshed, credits added, ShellCheck cleanup performed, and obsolete helper components removed.

> Release Date: 31/05/2026

#### 🚀 IntegrityBox Ultimate v41.5

- **Zero-config first install**: on fresh install the module now runs a full automated setup sequence — disables ROM native GMS/Vending spoofing to prevent conflicts, applies Banking Mode defaults (ADB, Wi-Fi ADB, developer options, OEM unlock all turned off), auto-extracts and saves the real Boot Hash, runs Standard Nuke cleanup, applies ZygiskNext stealth optimizations, attempts Widevine L1 repair if TEE is marked broken, syncs the Keybox catalog from cloud, and enables AutoPilot Xtreme with recommended flags. On update, **Vol Down** retains existing config; **Vol Up** wipes Box-Brain and re-runs the full setup as if fresh.
- **New module — Spoof ROM Props**: dedicated manager for Custom ROM property trace cleanup, moved from Module Settings where it existed as two toggles. **Auto** mode scans the device and enables matching cleanup cards; **Manual** mode lets you target specific ROM families: Generic, LineageOS, crDroid, Evolution X, DerpFest, RisingOS, AOSPA, PixelExperience, Pixel, Infinity, Havoc, Axion.
- **Keybox priority and persistence**: rebuilt keybox selection logic. New order: **CLOUD → CACHED → LOCAL**. A preferred keybox can be pinned — cloud takes priority when available, selection persists as fallback when cloud is unreachable. Sync now supports multiple keyboxes per provider, detects duplicates, and preserves the previous catalog on network failure.
- **Security Patch — manual date override**: **Auto / Manual** toggle added to the Security Patch module. Manual mode uses a visual month/day picker stored in `manual_security_patch.cfg` with priority over PIF metadata auto-detection.
- **Status — CACHED keybox indicator**: Integrity Checker now distinguishes a cloud Keybox whose provider is temporarily unavailable (**CACHED**) from a live online source. State badges (Online, Offline, Local, Cached, Missing) are fully localized.
- **Help Center — richer diagnostics**: Report.sh rewritten with +270 lines of new logic: JSON-structured output, ROM family trace detection across all supported families, full Keybox state (hash, preferred, source, SHA256), and service script status.
- **KeyboxLoader**: **CACHED** badge and provider name now shown per keybox entry in the list; sync label updated to reflect catalog rebuild flow.
- **Module Settings — UI cleanup**: `Spoof Lineage Props` and `Lineage v2` flags removed; both are now part of the dedicated Spoof ROM Props module.
- **Dynamic UI scaling**: WebUI now measures the host system text scale via a hidden probe element and adjusts the root font size (`--ibu-root-font-size`) accordingly. Scales down on compact screens (< 360 px wide or < 700 px tall) and responds live to resize and orientation changes.
- **AutoPilot mode documentation**: Xtreme and Keybox Only mode descriptions rewritten from daemon source. **Xtreme**: hourly — targets + security patches; every 24 h — Keybox catalog rebuild and injection; every 3 days — PIF rotation (pool of 10 profiles) + GMS cache wipe. **Keybox Only**: hourly — target scope only; every 24 h — Keybox only.

> Release Date: 21/05/2026

#### 🛠️ IntegrityBox Ultimate v41.0

- **Russian WebUI localization**: added full Russian interface translation, automatic system-language detection, and manual language switching in Module Settings.
- **HMA Profile**: expanded the hiding profile with more banking, system, and sensitive apps. After updating, apply **Inject HMA Template** to refresh the profile.
- **Inject HMA Template**: improved config injection on firmware where direct `/data` access is isolated, and removed unnecessary HMA app launches during the operation.
- **App Data Cleaner**: fixed stale selection counting. The cleanup button no longer shows a phantom app count when the saved selection contains apps that are no longer installed.
- **Fingerprint Selector**: added a dedicated PIF Pool update button for users running AutoPilot in **Keybox Only** mode.
- **Interface polish**: adjusted help dialogs, cards, status labels, buttons, and dynamic action messages for clearer Russian and English wording.
- **Help Center**: improved diagnostic report generation and log output formatting.

> Release Date: 15/05/2026

#### 🚀 IntegrityBox Ultimate v40.7

- **Boot Hash Spoofer**: unified real boot hash extraction through boot sources with KeyAttestation fallback. Magic Wand remains available as a backup option.
- **Get Real Boot Hash**: one-tap extraction of the original bootloader hash for stricter banking and security checks.
- **Anti-Detection Nuke**: deep root-trace cleanup with Soft, Standard, and Aggressive modes for logs, LSPosed cache, detector leftovers, and tool traces.
- **Fix Widevine L1**: hardware TEE/Widevine repair flow for supported BBK devices such as OnePlus, Oppo, Realme, plus Motorola.
- **Smart Security Patch**: safer `system=prop` mapping, HyperOS/ColorOS fixes, and generated patch dates for Google ban workarounds.
- **Target Manager**: Auto/Manual modes, `target.txt` import/backup, and a cleaner layout with Target Box and Target Simulator placed together.
- **Target Simulator**: per-app hardware-backed attestation tuning, automatic save on changes, import/backup flow, and keybox availability checks.
- **Quick Access**: long-press any WebUI tile to pin it to the home screen.
- **Integrity Downloader**: selectable downloads with checkboxes instead of downloading the whole tool bundle at once.
- **PixelMask download**: PixelMask was added to the downloadable tools list for Google Photos Pixel-feature scenarios.
- **Stealth Guide**: refreshed HMA, Banking Mode, SELinux, Zygisk/Shamiko, file hiding, Nuke, and app cleanup guidance.
- **HMA Profile**: updated hiding profile. After updating, apply **Inject HMA Template**, force stop the target app, and launch it again.
- **Help Center**: diagnostic archive now includes system data, installed apps, modules, and relevant logs.
- **Hide Files**: hidden directories are shown again as Vault/Masked and can be restored from the WebUI.
- **Keybox Pool**: improved XML cleanup before publishing and synchronization.
- **Documentation**: refreshed Russian and English README sections for setup, HMA, Play Store, Wallet, Boot Hash, System Prop Spoofer, and anti-detection flow.

> Release Date: 17/04/2026

#### 🚀 INTEGRITYBOX ULTIMATE - REBORN

- **Advanced Resource Delivery**: Core components are now securely and dynamically fetched.
- **Enhanced Stealth Mechanisms**: Upgraded structural integrity to prevent automated analysis.
- **Strict POSIX Shell**: Re-written core scripts for maximum Android compatibility.
- **Local Fallback System**: UI and configs work seamlessly even offline.
