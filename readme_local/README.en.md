<div align="center">
  <img src="../ibu.png" alt="IntegrityBox Ultimate" width="100%">
</div>

<br>

<div align="center">
  <a href="../README.md"><img src="../assets/readme_ru_icon.png" alt="Русский" height="72"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="./README.en.md"><img src="../assets/readme_en_icon.png" alt="English" height="72"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="https://github.com/flexgav/IntegrityBox-Ultimate/releases/latest"><img src="../assets/download.png" alt="Download" height="54"></a>
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
* 📌 **Quick Access dashboard:** Long-press any WebUI tile to pin it at the top of the home screen. Your pinned tiles are saved in `/data/adb/Box-Brain/quick_access.cfg`.
* 🛡️ **Security Patch automation:** The module reads the patch date from the active PIF data, writes the TrickyStore patch file in the expected format, and keeps the device properties aligned after boot.
* 🧹 **Anti-Detection Nuke:** Soft, Standard, and Aggressive modes clean common detection traces, app leftovers, and deeper system traces when you choose them. Reboot prompts are shown where needed.
* 🔐 **TEE / Widevine repair:** **Fix Widevine L1** can restore the included keybox on supported devices that provide the required `KmInstallKeybox` tool.
* 📦 **Integrity Downloader:** Downloads recommended helper apps and modules, including ZygiskNext, TrickyStore, HMA, PixelMask, KeyAttestation, and other useful tools.

---

## ✅ Requirements
For the best experience, make sure your device has:

**🧩 Core Requirements:** ![Required](https://img.shields.io/badge/required-core-blue)

1. A supported Root Manager: [**KernelSU Next**](https://github.com/KernelSU-Next/KernelSU-Next/releases/latest), [**APatch**](https://github.com/bmax121/APatch/releases/latest), or [**Kitsune Magisk / Kitsune Ufork**](https://t.me/KitsuneUfork).
2. Hardware attestation backend: [**Tricky Store**](https://github.com/5ec1cff/TrickyStore/releases/latest) or [**TEE Simulator**](https://github.com/JingMatrix/TEESimulator/releases/latest) *(needed for apps that check hardware-backed keys)*. Use only one backend: Tricky Store, TrickyStoreOSS, TEE Simulator, and their forks must not run at the same time.
3. A WebUI host: [**MMRL**](https://github.com/MMRLApp/MMRL/releases/latest), [**WebUI X Portable**](https://github.com/MMRLApp/WebUI-X-Portable/releases/latest), or built-in WebUI support in your Root Manager. [**KsuWebUIStandalone**](https://github.com/5ec1cff/KsuWebUIStandalone/releases/latest) can be used only as an old fallback option because its repository is archived.

> [!IMPORTANT]
> Before installing, remove other Integrity / Play Integrity certification fix modules and tools so they do not conflict with IntegrityBox Ultimate.

**⚠️ Conflicting modules to remove or disable:** ![Critical](https://img.shields.io/badge/critical-remove-red)

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

**🚨 Important for classic Magisk Stable users:** ![Warning](https://img.shields.io/badge/warning-magisk%20stable-orange)

> [!WARNING]
> Classic [**Magisk Stable**](https://github.com/topjohnwu/Magisk/releases/latest) is not the recommended option for IntegrityBox Ultimate if your goal is stable banking-app behavior and stricter environment checks. It is strongly recommended to move to [**Kitsune Magisk / Kitsune Ufork**](https://t.me/KitsuneUfork) or [**KSU Next Spoofed**](https://github.com/KernelSU-Next/KernelSU-Next/releases/latest) *(choose the APK with `-spoofed_...-release.apk` in the release assets)*; otherwise stable banking-app behavior is not guaranteed.

**➕ Optional, but highly recommended:** ![Recommended](https://img.shields.io/badge/recommended-stealth-green)

1. [**Zygisk Next**](https://github.com/Dr-TSNG/ZygiskNext/releases/latest) or [**ReZygisk**](https://github.com/PerformanC/ReZygisk/releases/latest) *(needed for Zygisk-based features unless you use the standalone Zygiskless Pixel Mode)*.
2. [**LSPosed / Vector**](https://github.com/JingMatrix/Vector/releases/latest) and [**HideMyApplist / HMA-OSS**](https://github.com/frknkrc44/HMA-OSS/releases/latest) *(recommended when banking or government apps react to app lists, root traces, or installed modules)*. Alternative HMA branch: [**Hide-My-Applist**](https://github.com/Dr-TSNG/Hide-My-Applist/releases/latest).

**📦 Useful tools from Integrity Downloader:** ![Tools](https://img.shields.io/badge/tools-downloader-blueviolet) [PixelMask](https://github.com/kinginu/PixelMask/releases/latest), [KeyAttestation](https://github.com/vvb2060/KeyAttestation/releases/latest), [UpdateLocker](https://github.com/Xposed-Modules-Repo/ru.mike.updatelocker/releases/latest), [CorePatch](https://github.com/LSPosed/CorePatch/releases/latest), [Reverse Pixelify](https://github.com/uragiristereo/Reverse_Pixelify/releases/latest).

**📁 Where to find files downloaded by Integrity Downloader:** ![Path](https://img.shields.io/badge/path-storage-lightgrey)

> [!NOTE]
> All APK/ZIP/JSON files downloaded by Integrity Downloader are saved to `/sdcard/IntegrityBox/Downloads`.

| Tool | File name | Full path |
| --- | --- | --- |
| Zygisk Next | `ZygiskNext.zip` | `/sdcard/IntegrityBox/Downloads/ZygiskNext.zip` |
| Tricky Store | `TrickyStore.zip` | `/sdcard/IntegrityBox/Downloads/TrickyStore.zip` |
| Key Attestation | `KeyAttestation.apk` | `/sdcard/IntegrityBox/Downloads/KeyAttestation.apk` |
| Update Locker | `UpdateLocker.apk` | `/sdcard/IntegrityBox/Downloads/UpdateLocker.apk` |
| HMA config | `HMA_Config.json` | `/sdcard/IntegrityBox/Downloads/HMA_Config.json` |
| HideMyApplist / HMA-OSS | `HideMyApplist.apk` | `/sdcard/IntegrityBox/Downloads/HideMyApplist.apk` |
| PixelMask | `PixelMask.apk` | `/sdcard/IntegrityBox/Downloads/PixelMask.apk` |
| Reverse Pixelify | `Reverse_Pixelify.apk` | `/sdcard/IntegrityBox/Downloads/Reverse_Pixelify.apk` |
| KsuWebUIStandalone | `KSU_WebUI.apk` | `/sdcard/IntegrityBox/Downloads/KSU_WebUI.apk` |
| Core Patch | `Core_Patch.apk` | `/sdcard/IntegrityBox/Downloads/Core_Patch.apk` |
| Thor Installer | `Thor_Installer.apk` | `/sdcard/IntegrityBox/Downloads/Thor_Installer.apk` |
| Android Faker | `Android_Faker.apk` | `/sdcard/IntegrityBox/Downloads/Android_Faker.apk` |
| LSPosed / Vector | `LSPosedVector.zip` | `/sdcard/IntegrityBox/Downloads/LSPosedVector.zip` |

---

## 🚀 Installation & Ultimate Setup Guide
For a clean setup and the best chance of restoring Play Store certification, follow these steps:

> [!TIP]
> If this is your first setup, follow the steps in order and do not enable extra tools until you complete the first Play Store certification check.

1. ✅ **Install Dependencies:** Make sure your Root Manager and required modules are installed.
2. 📲 **Flash IntegrityBox Ultimate:** Install the module zip and **reboot** your device.
3. ▶️ **Run the main action:** Open your Root Manager's module list and tap **Action** on the IntegrityBox Ultimate card. Wait until it finishes; it will download a working keybox and prepare a fresh device identity.
4. 🔎 **Check the result:** Open the WebUI, go to **Toolkit** -> **Integrity Checker**, and confirm that the active keybox is `ONLINE` and device identity data is present.
5. 🔐 **Repair TEE / Widevine if needed:** Supported devices can use **Keybox Hub** -> **Fix Widevine L1** to restore Widevine/TEE data through the device's built-in keybox installer. Use this only on compatible ROMs/devices. Reboot when prompted.
6. 🧼 **Deep Clean GMS:** Go to **Toolkit** -> **GMS Tools** and run **Deep GMS Wipe**. This removes old Google certification states and Google Services Framework data. Reboot when prompted. *(You will be logged out of your Google Account.)*
7. ✅ **Re-login & Verify:** After rebooting, open the Play Store, log back into your Google account, and check your Play Protect certification status.
8. 🤖 **Enable AutoPilot:** Go to **Auto Pilot** -> **AutoPilot Manager** and enable automatic background updates.

### 🕶️ Advanced Stealth Setup
For users who need banking or government apps to see a cleaner device, we recommend setting up HideMyApplist (HMA) with the built-in helpers:

> [!IMPORTANT]
> In most cases, you do not need to open HMA manually before injecting the profile: IntegrityBox Ultimate attempts to create the required data directories and write the configuration automatically. If automatic injection fails, open HMA once, close it, and run **Inject HMA Template** again.

1. 📥 **Download Tools:** Open WebUI -> **Miscellaneous** -> **Module Settings**. Toggle **Integrity Downloader** ON and tap **Apply Changes**. Downloaded APK/ZIP files will be saved to `/sdcard/IntegrityBox/Downloads`.
2. 🧩 **Install LSPosed:** Flash the downloaded LSPosed module in your Root Manager and reboot your device.
3. 🕵️ **Install HMA:** Open `/sdcard/IntegrityBox/Downloads/HideMyApplist.apk`, install HideMyApplist, and enable it in LSPosed.
4. 🛡️ **Inject the HMA profile:** Open WebUI -> **Hide My Stuff** -> **Inject HMA Template**. This applies ready-made hiding rules for many banking and government apps directly into HMA.
5. 📱 **Install PixelMask if needed:** PixelMask is not part of the HMA setup. Use it separately if you need the Pixel/GMS scenarios it handles.
6. 🧬 **Hide boot state if needed:** If an app clearly reports a bootloader or boot hash problem, open the WebUI, tap **Boot Hash Spoofer** in the **Detection** section, and follow the on-screen workflow.

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
2. Open WebUI -> **Keybox Hub** -> **Target Simulator**.
3. Find the target app by name or package name.
4. For the first attempt, select **Default** profile and **AUTO** mode, then tap **Save**.
5. Force stop the problematic app or reboot, then test it again.
6. If **AUTO** does not help, try **LEAF** for the same app. Use **GENERATE** only as a last resort when it is clear that the app does not accept the normal attestation chain.

### 🔓 An app complains about bootloader, VBMeta, or boot hash
1. Open WebUI -> **Detection** -> **Boot Hash Spoofer**.
2. First tap **Get Real Boot Hash**. The module will try to extract the device's real `androidboot.vbmeta.digest` from `/proc/cmdline`, device-tree, or bootconfig and automatically place it into the input field.
3. If the real hash is found, tap **Apply**, then **Reboot**, and test the app again.
4. If you see **Extraction Failed** and the real hash cannot be extracted, use the **Magic Wand** icon to generate a 64-character hash, tap **Apply**, then **Reboot**.
5. To roll the change back, return to **Boot Hash Spoofer**, tap **Reset**, and reboot.

### 📌 Need faster access to common tools
Long-press a WebUI tile for about 300 ms to pin it to **Quick Access** on the home page.

### 🆘 Nothing helped
If you still cannot restore Google certification or get the required apps working after all steps, open the Telegram group from the links at the top of this README and post in the help/support topic. Include your device model, ROM, Root Manager, attestation backend, Play Integrity result from the Play Store, and what you have already tried.

---

## 🙏 Credits & Acknowledgements
This project uses concepts and code from the following open-source work:
- @ez-me for ezme-nodebug.
- @osm0sis for PlayIntegrityFork.
- **LSPosed Team** for Shamiko's late start service script.
- **MeowDump** for the original Integrity-Box foundation.
- **You**, for using this module.
