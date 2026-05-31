<div align="center">
  <img src="../ibu.png" alt="IntegrityBox Ultimate" width="100%">
</div>

<br>

<div align="center">
  <a href="../README.md"><img src="../assets/readme_ru_icon.png" alt="Русский" height="72"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="./README.en.md"><img src="../assets/readme_en_icon.png" alt="English" height="72"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="https://t.me/IntegrityBoxUltimateChatRU/519"><img src="../assets/download.png" alt="Download" height="54"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="https://t.me/IntegrityBoxUltimateChatRU"><img src="../assets/tgru_icon.png" alt="Telegram RU" height="72"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="https://t.me/IntegrityBoxUltimateChatEN"><img src="../assets/tgen_icon.png" alt="Telegram EN" height="72"></a>
</div>

---

<h1 align="center">IntegrityBox Ultimate</h1>

<p align="center">
  <b>Android Certification, Keybox, and Privacy Toolkit</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Recommended-Kitsune%20Magisk%20%2F%20KSU%20Next%20Spoofed-blue" alt="Recommended">
  <img src="https://img.shields.io/badge/Warning-Remove%20conflicting%20modules-orange" alt="Warning">
  <img src="https://img.shields.io/badge/Critical-Do%20not%20mix%20attestation%20backends-red" alt="Critical">
</p>

## 📌 Overview
**IntegrityBox Ultimate** is a practical toolkit for keeping an Android device with root access clean, certified, and easier to manage. It brings keybox handling, Play Integrity helpers, app-hiding templates, Google services cleanup, and device status checks into one Material You WebUI.

### ✨ Highlights
* ️ **Core Attestation:** Automatic `fingerprint` management, cloud keybox loading, `Boot Hash`, and `Security Patch` helpers for Play Integrity checks.
* 🕶️ **Advanced Stealth:** Ready-made `HideMyApplist` profile for banking and detector apps, risky-app scanning, suspicious-file hiding, and `Anti-Detection Nuke` cleanup modes.
* 🤖 **AutoPilot:** Background automation that keeps the module data fresh without requiring manual checks every day.
* 🛠️ **System Toolkit:** Google Wallet reset, deep GMS cleanup, Widevine L1 repair on supported devices, SELinux Enforcing helper, selected app-data cleanup, and diagnostic report export.
* 🎨 **Modern UI:** Material You WebUI with interactive tiles, Quick Access, built-in AI Assistant, and Help Center.
* 📥 **Selectable downloads:** `Integrity Downloader` shows available APK/ZIP/JSON files with checkboxes, so you can download only the tools you need.
* ⚙️ **Advanced Configuration:** `Target Box` and `Target Simulator` support Auto/Manual modes, custom `target.txt` import, per-app target control, Zygiskless Mode, and profile switching.

---

## 🧩 Core Requirements
For comfortable use and maximum stealth, make sure the environment is built without conflicting root engines, attestation backends, or unnecessary traces in the user profile.

1. **Root solution.** Recommended order for devices where banking and government apps matter:

   - **Preferred:** [**SukiSU Ultra**](https://github.com/SukiSU-Ultra/SukiSU-Ultra/releases/latest) or [**KernelSU Next**](https://github.com/KernelSU-Next/KernelSU-Next/releases/latest) together with **SUSFS**.
     Full SUSFS support requires more than just the Manager APK: the device must boot a kernel / AnyKernel3 / boot image that already includes SUSFS patches. After flashing such a kernel, also install the userspace module [**susfs4ksu / SUSFS-FOR-KERNELSU**](https://github.com/sidex15/susfs4ksu-module/releases/latest).

   - **Alternative:** [**APatch**](https://github.com/bmax121/APatch/releases/latest), if there is no stable KernelSU / SukiSU / SUSFS kernel for your device or you specifically need kernel-based root without a Magisk-like setup.

   - **Fallback:** [**Kitsune Magisk / Kitsune Ufork**](https://t.me/KitsuneUfork). Use it only when KernelSU Next, SukiSU Ultra, or APatch are unavailable for your device. Stable behavior with strict banking apps is not guaranteed on Kitsune, because Magisk-like environments more often leave visible traces.

   Use only **one** root solution at a time. Do not mix Magisk / Kitsune, KernelSU Next, SukiSU Ultra, and APatch in the same system unless you fully understand the consequences.

2. **SUSFS and stealth.** If you choose SukiSU Ultra or KernelSU Next, using a **SUSFS** kernel build for your exact device, Android version, kernel branch, and firmware is recommended for better anti-detection.

   Simply patching `boot.img` or `init_boot.img` through a Manager can provide root access, but it does not guarantee SUSFS support. If the kernel does not contain SUSFS patches, the `susfs4ksu` module cannot enable kernel-level hiding.

3. **Hardware attestation backend.** Install [**Tricky Store**](https://github.com/5ec1cff/TrickyStore/releases/latest) or [**TEE Simulator**](https://github.com/JingMatrix/TEESimulator/releases/latest) if apps check hardware-backed keys and TEE / KeyMint attestation.

   Use only **one** attestation backend. Tricky Store, TrickyStoreOSS, TEE Simulator, and their forks must not run at the same time.

4. **WebUI.** To open the control panel, install [**MMRL**](https://github.com/MMRLApp/MMRL/releases/latest), [**WebUI X Portable**](https://github.com/MMRLApp/WebUI-X-Portable/releases/latest), or use built-in WebUI support in your Root Manager.

   If WebUI does not open directly, install [**KsuWebUIStandalone**](https://github.com/KOWX712/KsuWebUIStandalone/releases/latest) manually as a fallback first. After you can open WebUI, its APK can also be downloaded through Integrity Downloader.

## ⚠️ Conflicting modules to remove or disable

> [!IMPORTANT]
> Before installing, remove other Integrity / Play Integrity certification fix modules and tools so they do not conflict with IntegrityBox Ultimate.

> [!CAUTION]
> Do not mix multiple modules that change Keybox, fingerprint, GMS state, DroidGuard, VBMeta, or Play Integrity verdicts at the same time. These conflicts often cause unstable certification and false positives in banking apps.

<ul>
  <li><b>🧬 Play Integrity / DroidGuard spoofers:</b> PlayIntegrityFix / PIF, Play Integrity Fix Next / PlayIntegrityFix-NEXT, Play Integrity Fork / PIFork, PlayIntegritySuperFork, Play Integrity Fix Advanced, Strong Integrity Fix, SafetyNet Fix, Universal SafetyNet Fix, Displax SafetyNet Fix, and other PIF/SafetyNet forks.</li>
  <li><b>🧰 All-in-one Integrity / Keybox solutions:</b> Integrity-Box, Integrity Box forks, old IntegrityBox builds, Tricky Addon, Tricky Addon Enhanced / Update Target List, and similar modules if they manage keybox, target.txt, security patch, VBHash, or GMS state on their own.</li>
  <li><b>🔑 Key attestation / Keybox backend:</b> do not keep Tricky Store, TrickyStoreOSS, TEE Simulator, TEESimulator-RS, and their forks enabled at the same time. Leave only the backend selected for IntegrityBox Ultimate.</li>
  <li><b>🧾 Build props / fingerprint / security patch spoofers:</b> MagiskHide Props Config, Sensitive Props, Pixel Props / build.prop, Build-Prop-BETA, PixelFlasher PIF helper, XiaomiEU Injected PIF, and any ROM-bundled PIF / Pixel props spoof.</li>
  <li><b>📱 Pixel spoofing modules:</b> Pixelify, Pixelify Next, Pix3lify, Pixel Features, Google Photos Unlimited Backup, and similar modules if they change <code>ro.product*</code>, fingerprint, model, brand, security patch, or GMS properties.</li>
  <li><b>🧱 VBMeta / boot hash spoofers:</b> Android VBMeta Fixer, VBMeta Disguiser, and similar tools if IntegrityBox Ultimate Boot Hash / verifiedBootHash / VBMeta features are used at the same time.</li>
  <li>Any other module that changes fingerprint, build props, GMS state, DroidGuard, Keybox, attestation, security patch, VBMeta, boot hash, or Play Integrity verdicts.</li>
</ul>

## 🚨 Important for classic Magisk Stable users

> [!WARNING]
> Classic [**Magisk Stable**](https://github.com/topjohnwu/Magisk/releases/latest) is not the recommended option for IntegrityBox Ultimate if your goal is stable banking-app behavior and stricter environment checks. It is strongly recommended to move to [**Kitsune Magisk / Kitsune Ufork**](https://t.me/KitsuneUfork) or [**KSU Next Spoofed**](https://github.com/KernelSU-Next/KernelSU-Next/releases/latest) *(choose the APK with `-spoofed_...-release.apk` in the release assets)*; otherwise stable banking-app behavior is not guaranteed.

## ➕ Optional, but highly recommended

1. [**Zygisk Next**](https://github.com/Dr-TSNG/ZygiskNext/releases/latest) or [**ReZygisk**](https://github.com/PerformanC/ReZygisk/releases/latest) *(needed for Zygisk-based features unless you use the standalone Zygiskless Pixel Mode)*.
2. [**LSPosed / Vector**](https://github.com/JingMatrix/Vector/releases/latest) and [**HideMyApplist / HMA-OSS**](https://github.com/frknkrc44/HMA-OSS/releases/latest) *(recommended when banking or government apps react to app lists, root traces, or installed modules)*. Alternative HMA branch: [**Hide-My-Applist**](https://github.com/Dr-TSNG/Hide-My-Applist/releases/latest).

## 📦 Useful tools from Integrity Downloader

> [!TIP]
> Integrity Downloader no longer downloads the whole bundle blindly. Enable the **Integrity Downloader** tile, tap **Apply Changes**, select only the tools you need in the checkbox dialog, and press **Download Selected**. After confirmation, a terminal window will show the download progress.

Current list from `assets/tools.list`:

* **ZygiskNext.zip** — current Zygisk Next for Root Managers without built-in Zygisk.
* **TrickyStore.zip** — hardware attestation backend.
* **KeyAttestation.apk** — app for manual certificate and verdict checks.
* **UpdateLocker.apk** — LSPosed module for blocking unwanted app updates.
* **HMA_Config.json** — ready-made IntegrityBox profile for HideMyApplist.
* **HMA_OSS.apk** — current HideMyApplist OSS build.
* **PixelMask.apk** — LSPosed module for Pixel/GMS scenarios.
* **KSU_WebUI.apk** — standalone WebUI app for devices where the Root Manager does not open WebUI directly.
* **Core_Patch.apk** — LSPosed module for system install/signature restrictions.
* **Thor_Installer.apk** — manager/installer for additional Android tools.
* **Android_Faker.apk** — utility for manual Android identifier checks and setup.
* **LSPosedVector.zip** — LSPosed / Vector for HMA and other LSPosed modules.
* **Duck_Detector.apk** — root/Xposed/Magisk detector with native checks; useful for diagnosing what the root environment exposes.
* **Native_Root_Detector.apk** — native root detector showing exactly what apps can see during low-level environment scanning.

## 📁 Where to find files downloaded by Integrity Downloader

> [!NOTE]
> All selected APK/ZIP/JSON files downloaded by Integrity Downloader are saved to `/sdcard/IntegrityBox/Downloads`.

| Tool | File name | Full path |
| --- | --- | --- |
| Zygisk Next | `ZygiskNext.zip` | `/sdcard/IntegrityBox/Downloads/ZygiskNext.zip` |
| Tricky Store | `TrickyStore.zip` | `/sdcard/IntegrityBox/Downloads/TrickyStore.zip` |
| Key Attestation | `KeyAttestation.apk` | `/sdcard/IntegrityBox/Downloads/KeyAttestation.apk` |
| Duck Detector | `Duck_Detector.apk` | `/sdcard/IntegrityBox/Downloads/Duck_Detector.apk` |
| Native Root Detector | `Native_Root_Detector.apk` | `/sdcard/IntegrityBox/Downloads/Native_Root_Detector.apk` |
| Update Locker | `UpdateLocker.apk` | `/sdcard/IntegrityBox/Downloads/UpdateLocker.apk` |
| HMA Config | `HMA_Config.json` | `/sdcard/IntegrityBox/Downloads/HMA_Config.json` |
| HideMyApplist OSS | `HMA_OSS.apk` | `/sdcard/IntegrityBox/Downloads/HMA_OSS.apk` |
| PixelMask | `PixelMask.apk` | `/sdcard/IntegrityBox/Downloads/PixelMask.apk` |
| KSU WebUI | `KSU_WebUI.apk` | `/sdcard/IntegrityBox/Downloads/KSU_WebUI.apk` |
| Core Patch | `Core_Patch.apk` | `/sdcard/IntegrityBox/Downloads/Core_Patch.apk` |
| Thor Installer | `Thor_Installer.apk` | `/sdcard/IntegrityBox/Downloads/Thor_Installer.apk` |
| Android Faker | `Android_Faker.apk` | `/sdcard/IntegrityBox/Downloads/Android_Faker.apk` |
| LSPosed / Vector | `LSPosedVector.zip` | `/sdcard/IntegrityBox/Downloads/LSPosedVector.zip` |

---

## 🚀 Installation & Ultimate Setup Guide
For a clean setup and the best chance of restoring Play Store certification, follow these steps:

> [!TIP]
> If this is your first setup, follow the steps in order and do not enable extra tools until you complete the first Play Store certification check.

1. ✅ **Install Dependencies:** Make sure your Root Manager is installed and only one hardware attestation backend is selected.
2. 📲 **Flash IntegrityBox Ultimate:** Install the module zip. During installation, the module automatically syncs the Keybox catalog from the cloud. If prompted **"Erase previous installation data?"** — press **Vol Up** to reset or **Vol Down** to keep existing settings.
3. 🔄 **Reboot your device.** On the first boot, the module runs a full automatic setup sequence: disables ROM native spoofing, applies Banking Mode defaults, extracts the real Boot Hash, runs Standard Nuke cleanup, applies ZygiskNext stealth settings, attempts Widevine L1 repair, and enables AutoPilot Xtreme.
4. ▶️ **Run the main action:** Open your Root Manager's module list and tap **Action** on the IntegrityBox Ultimate card. Wait until it finishes; it will refresh the Keybox and prepare fresh device identity data.
5. 🔎 **Check the result:** Open the WebUI → **Toolkit** → **Integrity Checker**, and confirm that the active Keybox is `ONLINE` and device identity data is present.
6. 🧼 **Deep Clean GMS:** Go to **Toolkit** → **GMS Tools** and run **Deep GMS Wipe**. This removes old Google certification states and Google Services Framework data. Reboot when prompted. *(You will be logged out of your Google Account.)*
7. ✅ **Re-login & Verify:** After rebooting, open the Play Store, log back into your Google account, and check your Play Protect certification status.
8. 🤖 **Check AutoPilot:** Go to **Auto Pilot** → **AutoPilot Manager** — the daemon should already be running in Xtreme mode. Switch to **Keybox Only** if you prefer minimal system impact.
9. 🧹 **Custom ROM Props if needed:** If your device runs a custom ROM, open **Custom ROM Spoofing** → **Spoof ROM Props** and enable **Auto Mode** — the module will scan for ROM-family traces and enable the matching cleanup cards automatically.
10. 📦 **Export a diagnostic package if needed:** If certification or apps are still unstable, open **Help Center** → **Export Report**. The archive will be saved to `/sdcard/IntegrityBox/Reports`.

> [!NOTE]
> Boot Hash and Widevine L1 are configured automatically on first install. To adjust Boot Hash manually later — open **Detection** → **Boot Hash Spoofer**. To re-run Widevine L1 repair — use **Keybox Hub** → **Fix Widevine L1**.

### 🕶️ Advanced Stealth Setup
For users who need banking or government apps to see a cleaner device, we recommend setting up HideMyApplist (HMA) with the built-in helpers:

> [!IMPORTANT]
> In most cases, you do not need to open HMA manually before injecting the profile: IntegrityBox Ultimate attempts to create the required data directories and write the configuration automatically. If automatic injection fails, open HMA once, close it, and run **Inject HMA Template** again.

1. 📥 **Download Tools:** Open WebUI -> **Miscellaneous** -> **Module Settings**. Toggle **Integrity Downloader** ON and tap **Apply Changes**. In the dialog, select the tools you need with checkboxes. For the HMA scenario, you usually need **LSPosedVector.zip**, **HMA_OSS.apk**, and **HMA_Config.json**. Downloaded files will be saved to `/sdcard/IntegrityBox/Downloads`.
2. 🧩 **Install LSPosed / Vector:** Flash `/sdcard/IntegrityBox/Downloads/LSPosedVector.zip` in your Root Manager and reboot your device.
3. 🕵️ **Install HMA:** Open `/sdcard/IntegrityBox/Downloads/HMA_OSS.apk`, install HideMyApplist, and enable it in LSPosed.
4. 🛡️ **Inject the HMA profile:** Open WebUI -> **Hide My Stuff** -> **Inject HMA Template**. This applies ready-made hiding rules for many banking and government apps directly into HMA.
5. 📱 **Install PixelMask for Google Photos features:** PixelMask can unlock selected Pixel features for Google Photos on your phone. Depending on the selected profile, this may include unlimited Original-quality photo and video backup or Pixel-only features such as Video Boost, Night Sight Video, Add Me, Reimagine, and Magic Editor.

For maximum stealth and anti-detection, use these tools according to the symptoms:

1. 🏦 **Banking Mode:** Open **Toolkit** -> **Utility Box** and enable **Banking Mode**. It hides ADB/debug state and sets `sys.oem_unlock_allowed=0`.
2. 🛡️ **SELinux Enforcing:** On the home page, open **Cleanup & SELinux** -> **Enforce SELinux** and make sure the module status shows SELinux as `Enforcing`.
3. 🧩 **Strict Zygisk/Shamiko isolation:** Use **ZygiskNext & Shamiko** -> **Enable Whitelist Mode** to enable strict isolation. Configure the app list separately in your Root Manager's DenyList or in the ZygiskNext/Shamiko settings.
4. ⚙️ **Optimize ZygiskNext:** Tap **ZygiskNext & Shamiko** -> **Optimize ZygiskNext** if you use Zygisk Next. The module applies recommended controller stealth settings.
5. 🧰 **Anti-detection flags:** In **Miscellaneous** → **Module Settings**, enable only what you actually need: **Debug Fingerprint**, **Debug Build**, **Build Tag**, **Clear LSposed**, **Spoof Encryption**, **Hide Recovery**, **Clear Gapps Logs**, and **Archive Manager Logs**. For ROM trace cleanup, use **Custom ROM Spoofing** → **Spoof ROM Props**.
6. 🗂️ **Hide suspicious files:** Use **Hide My Stuff** -> **Hide Suspicious Files** if an app sees `TWRP`, `Fox`, `Magisk`, root managers, or old traces on `/sdcard`. Do not add random system paths.
7. 🧹 **Reset the app state:** After changing HMA, Target, props, or Boot Hash, open **Cleanup & SELinux** -> **App Data Cleaner** and clear data/cache for the problematic app so it re-checks the environment.
8. 🔥 **Anti-Detection Nuke:** Use **Detection** -> **Anti-Detection Nuke** only for clear leftover traces. Start with **Soft Cleanup**, then **Standard Nuke**. Keep **Aggressive Nuke** as the last resort.
9. 🧪 **System Prop Spoofer:** Use **Detection** -> **System Prop Spoofer** only if you understand which `getprop` traces need to be reset or removed.

<details>
<summary><strong>Detailed System Prop Spoofer table</strong></summary>

#### Purpose summary

| Section | What it affects | When to use |
| --- | --- | --- |
| Reset Props | ADB, debug/dev state, secure mode, bootloader/Verified Boot, build type, OEM unlock, emulator flags. | When dangerous props need to be overwritten with safer user/locked/release-like values. |
| Duck Detector Props | A small set of props often checked by strict native detectors. | When the keys themselves should be removed from the current property space instead of changing their values. |
| Delete Props | ROM-branded properties, Pixel/EliteProps/PIF leftovers, and other traces from old spoofing modules. | When the property itself should disappear from the current property space. |
| Nuke Trash | `*.odex`, `*.vdex`, `base.odex` under `/data/app`. | When a detector reacts to stale odex/vdex artifacts after modules or app updates. |

#### Reset Props

| UI item | Props / action | Purpose |
| --- | --- | --- |
| USB Debug Block | `sys.usb.adb.disabled=1` | Applies a signal that USB ADB is disabled. |
| MTP Only Mode | `persist.sys.usb.config=mtp`, `sys.usb.config=mtp`, `sys.usb.state=mtp` | Removes ADB from USB configuration and leaves MTP mode. |
| ADB Root Off | `service.adb.root=0`, `service.adb.tcp.port=-1` | Disables root shell over ADB and ADB over TCP. |
| Secure Mode | `ro.secure=1`, `ro.adb.secure=1` | Restores secure-build and secure-ADB signals. |
| Debug Off | `ro.debuggable=0`, `persist.sys.debuggable=0` | Hides debug/userdebug state. |
| Dev Options Off | `persist.sys.developer_options=0`, `persist.sys.dev_mode=0` | Resets persistent Developer Options signals. |
| Global Settings | `development_settings_enabled=0`, `adb_enabled=0`, `oem_unlock_allowed=0` | Resets Android global settings for Developer Options, ADB, and OEM unlock. |
| Verified Boot | `ro.boot.verifiedbootstate=green`, `vendor.boot.verifiedbootstate=green` | Applies green Verified Boot state. |
| Flash Locked | `ro.boot.flash.locked=1` | Applies the signal that flash partitions are locked. |
| VBMeta Locked | `ro.boot.vbmeta.device_state=locked`, `vendor.boot.vbmeta.device_state=locked` | Applies locked VBMeta/device state. |
| SecureBoot | `ro.secureboot.lockstate=locked` | Applies locked Secure Boot state. |
| Warranty Valid | `ro.boot.warranty_bit=0` | Resets the warranty bit to a non-triggered value. |
| User Build | `ro.build.type=user`, `ro.build.tags=release-keys` | Presents the build as a normal release build. |
| OEM Lock | `ro.oem_unlock_supported=0`, `sys.oem_unlock_allowed=0` | Hides OEM unlock support/permission signals. |
| No Emulator | `ro.kernel.qemu=0`, `ro.boot.qemu=0`, `ro.hardware.virtual_device=0` | Removes basic emulator/virtual-device indicators. |
| Nuke Trash | Delete `*.odex`, `*.vdex`, `base.odex` under `/data/app` | Cleans stale app optimization artifacts; this is not a `getprop` change. |

#### Duck Detector Props

| UI item | Prop | Action |
| --- | --- | --- |
| ADB Secure | `ro.adb.secure` | Deletes the prop with `resetprop --delete` if it exists in the current property space. |
| Verified Boot State | `ro.boot.verifiedbootstate` | Deletes the prop with `resetprop --delete` if it exists in the current property space. |
| Verity Mode | `ro.boot.veritymode` | Deletes the prop with `resetprop --delete` if it exists in the current property space. |
| Build Tags | `ro.build.tags` | Deletes the prop with `resetprop --delete` if it exists in the current property space. |
| Build Type | `ro.build.type` | Deletes the prop with `resetprop --delete` if it exists in the current property space. |

#### Delete Props

Every item below **deletes the selected prop** from the current Android property space with `resetprop --delete`. The value is not spoofed or replaced. If the prop is absent, the module skips it.

| UI item | Prop |
| --- | --- |
| Lineage Device | `ro.lineage.device` |
| crDroid Device | `ro.crdroid.device` |
| Build Flavor | `ro.build.flavor` |
| Custom Device | `ro.custom.device` |
| Elite Version | `ro.build.elitever` |
| Xiaomi Dev ID | `ro.xiaomi.developerid` |
| Mod Version | `ro.modversion` |
| Elite Time | `ro.elite.version.code_time` |
| Elite Keybox | `sys.eliteprops.keybox` |
| Elite PIF | `sys.eliteprops.pif` |
| Elite Play Store | `sys.eliteprops.vending` |
| Elite Pixel | `sys.eliteprops.pixelprops` |
| Elite Photos | `sys.eliteprops.photos` |
| Elite Games | `sys.eliteprops.games` |
| Elite Snapchat | `sys.eliteprops.snapchat` |
| Elite Recent | `sys.eliteprops.recent` |
| Elite Recent All | `sys.eliteprops.recent.all` |
| Elite Spoof | `sys.eliteprops.spoofastab` |
| Pixel Device | `ro.pixel.device` |
| Pixel Version | `ro.pixel.version` |
| Pixel Build | `ro.pixel.build.version` |
| Pixel Release | `ro.pixel.releasetype` |
| Pixel Legal | `ro.pixellegal.url` |
| Evolution Device | `ro.evolution.device` |
| Evolution Build | `ro.evolution.build.version` |
| Evolution Display | `ro.evolution.display.version` |
| Evolution Version | `ro.evolution.version` |
| Evolution Legal | `ro.evolutionlegal.url` |
| Lineage SDK | `ro.lineage.build.version.plat.sdk` |
| Lineage Rev | `ro.lineage.build.version.plat.rev` |
| Rising Popup | `ro.rising.feature.pop_up_view` |
| Rising Chipset | `ro.rising.chipset` |
| Rising Maintainer | `ro.rising.maintainer` |
| Rising Code | `ro.rising.code` |
| Rising Package | `ro.rising.packagetype` |
| Rising Release | `ro.rising.releasetype` |
| Rising Version | `ro.rising.version` |
| Rising Build | `ro.rising.build.version` |
| Rising Display | `ro.rising.display.version` |
| Rising Codename | `ro.rising.platform_release_codename` |
| Rising Device | `ro.rising.device` |
| Rising Storage | `ro.rising.storage` |
| Rising RAM | `ro.rising.ram` |
| Rising Battery | `ro.rising.battery` |
| Rising Resolution | `ro.rising.display_resolution` |
| Lineage Version | `ro.lineage.version` |
| Lineage Display | `ro.lineage.display.version` |
| Lineage Build | `ro.lineage.build.version` |
| Lineage Release | `ro.lineage.releasetype` |
| Lineage Legal | `ro.lineagelegal.url` |
| Infinity Device | `ro.infinity.device` |
| Infinity SoC | `ro.infinity.soc` |
| Infinity Battery | `ro.infinity.battery` |
| Infinity Display | `ro.infinity.display` |
| Infinity Camera | `ro.infinity.camera` |
| Infinity Android | `ro.infinity.android.version` |
| Infinity Build | `ro.infinity.build.version` |
| Infinity Status | `ro.infinity.build.status` |
| Infinity Date | `ro.infinity.build.date` |
| Infinity Type | `ro.infinity.buildtype` |
| Infinity Fingerprint | `ro.infinity.fingerprint` |
| Infinity Version | `ro.infinity.version` |
| Infinity Maintainer | `ro.infinity.maintainer` |
| Havoc Variant | `ro.havoc.build.variant` |
| Havoc Device | `ro.havoc.device` |
| Havoc Date | `ro.havoc.build.date` |
| Havoc Build | `ro.havoc.build.version` |
| Havoc Fingerprint | `ro.havoc.fingerprint` |
| Havoc Release | `ro.havoc.releasetype` |
| Havoc Version | `ro.havoc.version` |
| Havoc Security | `ro.havoc.build.version.security_patch` |
| Derpfest Device | `ro.derpfest.device` |
| Derpfest Date | `ro.derpfest.build.date` |
| Derpfest Build | `ro.derpfest.build.version` |
| Derpfest Variant | `ro.derpfest.build.variant` |
| Derpfest Display | `ro.derpfest.display.version` |
| Derpfest Release | `ro.derpfest.releasetype` |
| Derpfest Version | `ro.derpfest.version` |
| Derpfest Legal | `ro.derpfestlegal.url` |
| Axion Device | `ro.axion.device` |
| Axion Version | `ro.axion.version` |
| Axion Display | `ro.axion.display.version` |
| Axion Build | `ro.axion.build.version` |
| Axion Release | `ro.axion.releasetype` |
| Axion Maintainer | `persist.sys.axion_maintainer` |
| Axion Processor | `persist.sys.axion_processor_info` |

</details>

### 🎯 Manual Target List Control
If you want to use your own app list instead of the automatic template:

1. Open WebUI -> **Customize Tricky Store** -> **Target Box**.
2. Disable **Auto Update Target List** if you want full manual control over `target.txt`.
3. Use **Import Target** to select your own `target.txt` through the built-in file picker.
4. For per-app tuning, open **Customize Tricky Store** -> **Target Simulator**: there you can select an app, profile, mode, and import a custom target file.
5. If you enable **Auto Update Target List** again, the module will apply its own rules and refresh the displayed app list from the current `target.txt`.

---

## 📚 Built-in Knowledge Base
**IntegrityBox Ultimate includes an interactive Knowledge Base directly inside the WebUI.**

* 💡 **Module Guides:** Tap the lightbulb icon at the top of any module page.
* ℹ️ **Feature Details:** Tap the `( i )` buttons next to individual sections.
* 🤖 **AI Assistant:** An offline built-in assistant is available in the WebUI for common questions and troubleshooting.

---

## 🛠️ Quick Troubleshooting
> [!NOTE]
> Start with the simple checks first: Keybox status, Deep GMS Wipe, reboot, and Play Store certification check. Use Target Simulator, Boot Hash Spoofer, and Nuke only when you know which exact check is failing.

### 🧪 Play Integrity fails
1. Open WebUI -> **Toolkit** -> **Integrity Checker**.
2. Check **Active Keybox**: the status should be `ONLINE`, and the Keybox source should be shown correctly.
3. If the Keybox is missing or the status is not `ONLINE`, open WebUI -> **Keybox Hub** -> **Keybox Loader**. Select **Slot 1** at the top *(the primary slot)*, tap **Force Cloud Sync**, wait for the list to refresh, then tap a fresh Keybox with the `PROVIDER` badge and confirm loading it into **Slot 1**. If the cloud list does not appear, check your internet connection and GitHub access. If sync is still unavailable, place your own XML Keybox in `/sdcard/Download` or `/sdcard/Documents`, tap the refresh button, and load the detected `LOCAL` Keybox into **Slot 1**.
4. After updating the Keybox, run WebUI -> **Toolkit** -> **GMS Tools** -> **Deep GMS Wipe**, reboot, and check the Play Store again.

### 🛒 Play Store says "Device not certified"
1. Make sure Play Integrity already passes in **Integrity Checker**.
2. Enable hidden Play Store developer options: open **Play Store** -> tap your profile avatar in the top-right corner -> **Settings** -> **About** -> tap **Play Store version** 7 times until developer mode is enabled.
3. Check the integrity verdict: go back to Play Store **Settings** -> **General** -> **Developer options** -> in the **Play Integrity** section, tap **Check integrity**.
4. The result should show a passing integrity verdict. For normal Play Store certification, **Device integrity** / `MEETS_DEVICE_INTEGRITY` should pass; for Google Wallet and strict banking apps, **Strong integrity** / `MEETS_STRONG_INTEGRITY` is usually required.
5. Also check the certification status: **Play Store** -> profile avatar -> **Settings** -> **About** -> **Play Protect certification**. The expected status is **Device is certified**.
6. If the integrity verdict passes but the Play Store still says **Device is not certified**, open WebUI -> **Toolkit** -> **GMS Tools** -> **Deep GMS Wipe**.
7. Reboot, open the Play Store, sign in again, and wait a few minutes. Then repeat the integrity and certification checks above.

### 💳 Google Wallet / GPay fails
1. First run the built-in Play Integrity check through the Play Store: **Play Store** -> profile avatar -> **Settings** -> **General** -> **Developer options** -> **Play Integrity** -> **Check integrity**. If **Developer options** is not visible, enable it using the previous scenario.
2. Google Wallet usually requires **Strong integrity** / `MEETS_STRONG_INTEGRITY`. If only **Device integrity** passes, the Play Store may be certified, but Wallet can still reject payments.
3. If **Strong integrity** does not pass, go back to **Play Integrity fails**: check **Active Keybox**, refresh the Keybox through **Keybox Loader**, then run **Deep GMS Wipe** and reboot.
4. If **Strong integrity** passes but Wallet still fails, open WebUI -> **Toolkit** -> **GMS Tools** -> **Wallet Reset**. This clears Wallet's local state that may have cached a previous security failure.
5. Reboot, open Google Wallet, add your cards again if needed, and test contactless payment.

### 🏦 A banking app detects root, Xposed, or suspicious apps
1. Make sure **HideMyApplist / HMA-OSS** is installed, the HMA module is enabled in LSPosed, and the banking app is selected in HMA's LSPosed scope.
2. If the profile has not been applied yet, open WebUI -> **Hide My Stuff** -> **Inject HMA Template**. This imports the ready-made IntegrityBox configuration into HMA.
3. Open HMA and select the banking app in the list of apps that should see a hidden environment.
4. Apply the **FlexGAV 5.5** templates and presets to it: the blacklist/template for hidden apps, detector/root/sus-app presets, and settings presets such as accessibility/dev options/input method when available in your HMA build.
5. Save the HMA configuration, force stop the banking app or reboot, then test the app again.

### 🔐 An app fails hardware attestation / TEE
> [!IMPORTANT]
> Target Simulator is configured per app. Do not apply it to all apps at once.

1. First make sure **Active Keybox** in **Integrity Checker** is `ONLINE`.
2. Open WebUI -> **Customize Tricky Store** -> **Target Simulator**.
3. Find the target app by name or package name.
4. For the first attempt, select **Default** profile and **AUTO** mode, then tap **Save**.
5. Force stop the problematic app or reboot, then test it again.
6. If **AUTO** does not help, try **LEAF** for the same app. Use **GENERATE** only as a last resort when it is clear that the app does not accept the normal attestation chain.

### 🔓 An app complains about bootloader, VBMeta, or boot hash
1. Open WebUI -> **Detection** -> **Boot Hash Spoofer**.
2. Tap **Get Real Boot Hash**. The module first checks hardware boot sources: `/proc/cmdline`, device-tree, and `/proc/bootconfig`.
3. If boot sources do not return a valid hash, the module automatically tries the local Java Key Attestation fallback. You do not need to run it separately.
4. If the field is filled with a 64-character hash, tap **Apply**, then **Reboot**, and test the app again.
5. If you see **Extraction Failed**, open **Help Center** -> **Export Report** and save the diagnostic archive: it will include `boot_hash_extract.log` and `boot_hash_attestation.log`.
6. If the real hash cannot be obtained, use **Magic Wand** only as a fallback: it generates a valid 64-character hash, but it is not the real device value.
7. To roll the change back, return to **Boot Hash Spoofer**, tap **Reset**, and reboot.

### 📌 Need faster access to common tools
Long-press a WebUI tile for about 300 ms to pin it to **Quick Access** on the home page.

### 🆘 Nothing helped
If you still cannot restore Google certification or get the required apps working after all steps, open the Telegram group from the links at the top of this README and post in the help/support topic. Include your device model, ROM, Root Manager, attestation backend, Play Integrity result from the Play Store, and what you have already tried.

---

## 🧩 Binary Component Sources
The module ZIP already contains readable JS, HTML, CSS, shell scripts, and config files. Separate source folders are provided only for components shipped as compiled binaries:

- `sources/zygisk/` - source code and build notes for native Zygisk libraries from `IntegrityBox-Ultimate-Clnt/zygisk/*.so`.
- `sources/boot-hash-attestation/` - source code and build notes for the `boot_attest.jar` helper.
- `sources/licenses/` - licenses and notices for compiled components.

---

## 🙏 Credits & Acknowledgements
This project uses concepts and code from the following open-source work:
- @ez-me for ezme-nodebug.
- @osm0sis for PlayIntegrityFork.
- **LSPosed Team** for Shamiko's late start service script.
- **MeowDump** for the original Integrity-Box foundation.
- **You**, for using this module.
