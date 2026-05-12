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

## Overview
**IntegrityBox Ultimate** is a practical toolkit for keeping an Android device with root access clean, certified, and easier to manage. It brings keybox handling, Play Integrity helpers, app-hiding templates, Google services cleanup, and device status checks into one Material You WebUI.

### Highlights
* **Quick Access dashboard:** Long-press any WebUI tile to pin it at the top of the home screen. Your pinned tiles are saved in `/data/adb/Box-Brain/quick_access.cfg`.
* **Security Patch automation:** The module reads the patch date from the active PIF data, writes the TrickyStore patch file in the expected format, and keeps the device properties aligned after boot.
* **Anti-Detection Nuke:** Soft, Standard, and Aggressive modes clean common detection traces, app leftovers, and deeper system traces when you choose them. Reboot prompts are shown where needed.
* **TEE / Widevine repair:** **Fix Widevine L1** can restore the included keybox on supported devices that provide the required `KmInstallKeybox` tool.
* **Integrity Downloader:** Downloads recommended helper apps and modules, including ZygiskNext, TrickyStore, HMA, PixelMask, KeyAttestation, and other useful tools.

---

## Requirements
For the best experience, make sure your device has:

**Core Requirements:**

1. A supported Root Manager: **KernelSU**, **APatch**, or **Magisk**.
2. **Tricky Store** or **TEE Simulator** *(needed for apps that check hardware-backed keys)*.
3. A WebUI host: **KsuWebUIStandalone**, **MMRL**, or built-in WebUI support, so you can open the dashboard.

**Optional, but highly recommended:**

4. **Zygisk Next** or **ReZygisk** *(needed for Zygisk-based features unless you use the standalone Zygiskless Pixel Mode)*.
5. **LSPosed** and **HideMyApplist (HMA)** *(recommended when banking or government apps are sensitive to root traces)*.

---

## Installation & Ultimate Setup Guide
For a clean setup and the best chance of restoring Play Store certification, follow these steps:

1. **Install Dependencies:** Make sure your Root Manager and required modules are installed.
2. **Flash IntegrityBox Ultimate:** Install the module zip and **reboot** your device.
3. **Run the main action:** Open your Root Manager's module list and tap **Action** on the IntegrityBox Ultimate card. Wait until it finishes; it will download a working keybox and prepare a fresh device identity.
4. **Check the result:** Open the WebUI, go to **Toolkit** -> **Integrity Checker**, and confirm that the active keybox is `ONLINE` and device identity data is present.
5. **Repair TEE / Widevine if needed:** Supported devices can use **Keybox Hub** -> **Fix Widevine L1** to restore Widevine/TEE data through the device's built-in keybox installer. Use this only on compatible ROMs/devices. Reboot when prompted.
6. **Deep Clean GMS:** Go to **Toolkit** -> **GMS Tools** and run **Deep GMS Wipe**. This removes old Google certification states and Google Services Framework data. Reboot when prompted. *(You will be logged out of your Google Account.)*
7. **Re-login & Verify:** After rebooting, open the Play Store, log back into your Google account, and check your Play Protect certification status.
8. **Enable AutoPilot:** Go to **Auto Pilot** -> **AutoPilot Manager** and enable automatic background updates.

### Advanced App Hiding Setup
For users who need banking or government apps to see a cleaner device, we recommend setting up HideMyApplist (HMA) with the built-in helpers:

1. **Download Tools:** Open WebUI -> **Miscellaneous** -> **Module Settings**. Toggle **Integrity Downloader** ON and tap **Apply Changes**.
2. **Install LSPosed:** Flash the downloaded LSPosed module in your Root Manager and reboot your device.
3. **Install HMA / PixelMask if needed:** Install HMA from the downloads folder, enable it in LSPosed, open it once so it creates its data folder, then force close it.
4. **Inject Config:** Open WebUI -> **Hide My Stuff** -> **Inject HMA Template**.
5. **Handle strict TEE checks:** Open WebUI -> **Keybox Hub** -> **Target Simulator** and enable the safer simulated environment for selected apps.
6. **Hide boot state:** Open **Detection** -> **Boot Hash Spoofer** and follow the on-screen workflow.

---

## Built-in Knowledge Base
**IntegrityBox Ultimate includes an interactive Knowledge Base directly inside the WebUI.**

* **Module Guides:** Tap the lightbulb icon at the top of any module page.
* **Feature Details:** Tap the `( i )` buttons next to individual sections.
* **AI Assistant:** An offline built-in assistant is available in the WebUI for common questions and troubleshooting.

---

## Quick Troubleshooting
* **Failing Play Integrity?** Make sure SELinux is set to `Enforcing` and check whether your keybox is still usable.
* **"Device not certified" in Play Store?** Use **GMS Tools** -> **Deep GMS Wipe** and reboot.
* **Google Wallet / GPay failing?** Use **GMS Tools** -> **Wallet Reset**.
* **Banking apps crashing?** Use **Applist Detector** and **Hide Suspicious Files** to find and hide visible traces.
* **Failing strict bootloader checks?** Use **Boot Hash Spoofer**.
* **Failing TEE checks?** Use **Target Simulator** for that app. On supported devices, also try **Fix Widevine L1** and reboot.
* **Need a faster WebUI workflow?** Long-press frequently used tiles for 300ms and pin them to **Quick Access**.

---

## Credits & Acknowledgements
This project uses concepts and code from the following open-source work:
- @ez-me for ezme-nodebug.
- @osm0sis for PlayIntegrityFork.
- **LSPosed Team** for Shamiko's late start service script.
- **MeowDump** for the original Integrity-Box foundation.
- **You**, for using this module.
