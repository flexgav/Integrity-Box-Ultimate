<div align="center">
  <img src="ibu.png" alt="IntegrityBox Ultimate" style="border-radius: 16px; margin-bottom: 20px; box-shadow: 0 10px 30px rgba(0,0,0,0.5); width: 100%; max-width: 800px;">
  <h1>🛡️ IntegrityBox Ultimate</h1>
  <p><b>Android Certification, Keybox, and Privacy Toolkit</b></p>
  
  <a href="https://github.com/flexgav/IntegrityBox-Ultimate/releases" target="_blank">
    <img src="https://raw.githubusercontent.com/flexgav/IntegrityBox-Ultimate/main/assets/download.png" alt="Download Button" width="150">
  </a>
  <br><br>
  <a href="https://t.me/IntegrityBoxUltimateChatEN" target="_blank">
    <img src="https://img.shields.io/badge/Telegram-EN_Chat-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white" alt="Telegram EN">
  </a>
</div>

<br>

## 🚀 Overview
**IntegrityBox Ultimate** is a practical toolkit for keeping an Android device with root access clean, certified, and easier to manage. It brings keybox handling, Play Integrity helpers, app-hiding templates, Google services cleanup, and device status checks into one Material You WebUI.

### ✨ Highlights
* **Quick Access dashboard:** Long-press any WebUI tile to pin it at the top of the home screen. Your pinned tiles are saved in `/data/adb/Box-Brain/quick_access.cfg`.
* **Security Patch automation:** The module reads the patch date from the active PIF data, writes the TrickyStore patch file in the expected format, and keeps the device properties aligned after boot.
* **Anti-Detection Nuke:** Soft, Standard, and Aggressive modes clean common detection traces, app leftovers, and deeper system traces when you choose them. Reboot prompts are shown where needed.
* **TEE / Widevine repair:** **Fix Widevine L1** can restore the included keybox on supported devices that provide the required `KmInstallKeybox` tool.
* **Integrity Downloader:** Downloads recommended helper apps and modules, including ZygiskNext, TrickyStore, HMA, PixelMask, KeyAttestation, and other useful tools.

---

## 📋 Requirements
For the best experience, make sure your device has:

**Core Requirements:**

1. A supported Root Manager: **KernelSU**, **APatch**, or **Magisk**.
2. **Tricky Store** or **TEE Simulator** *(needed for apps that check hardware-backed keys)*.
3. A WebUI host: **KsuWebUIStandalone**, **MMRL**, or built-in WebUI support, so you can open the dashboard.

**Optional (but highly recommended):**

4. **Zygisk Next** or **ReZygisk** *(needed for Zygisk-based features unless you use the standalone Zygiskless Pixel Mode)*.
5. **LSPosed** and **HideMyApplist (HMA)** *(recommended when banking or government apps are sensitive to root traces)*.

---

## 🛠️ Installation & Ultimate Setup Guide
For a clean setup and the best chance of restoring Play Store certification, follow these steps:

1. **Install Dependencies:** Make sure your Root Manager (KernelSU/APatch/Magisk) and required modules (TrickyStore/TEESimulator + ZygiskNext) are installed.
2. **Flash IntegrityBox Ultimate:** Install the module zip and **reboot** your device.
3. **Run the main action:** Open your Root Manager's module list and tap **Action** on the IntegrityBox Ultimate card. Wait until it finishes; it will download a working keybox and prepare a fresh device identity.
4. **Check the result:** Open the WebUI (Settings button on the module card), go to **Toolkit** -> **Integrity Checker**, and confirm that the active keybox is `ONLINE` and device identity data is present.
5. **Repair TEE / Widevine if needed:** After a clean install or module update, supported devices can use **Keybox Hub** -> **Fix Widevine L1** to restore Widevine/TEE data through the device's built-in keybox installer. Use this only on ROMs/devices with a compatible `KmInstallKeybox` tool, commonly OPPO/OnePlus/Realme and some Motorola builds. Reboot when prompted.
6. **Deep Clean GMS (Crucial Step):** Go to **Toolkit** -> **GMS Tools** and run **Deep GMS Wipe**. This removes old Google certification states, cached "Not Certified" results, and Google Services Framework data. Reboot when prompted. *(Note: You will be logged out of your Google Account).*
7. **Re-login & Verify:** After rebooting, open the Play Store, log back into your Google account, and check your Play Protect certification status. 
8. **Enable AutoPilot:** Finally, go to **Auto Pilot** -> **AutoPilot Manager** and enable automatic background updates. Xtreme mode is recommended if you want keyboxes and device identities refreshed regularly.

### 🥷 Advanced App Hiding Setup (Recommended)
For users who need banking or government apps to see a cleaner device, we recommend setting up HideMyApplist (HMA) with the built-in helpers:
1. **Download Tools:** Open WebUI -> **Miscellaneous** -> **Module Settings**. Toggle **Integrity Downloader** ON and tap **Apply Changes**. The latest LSPosed and HMA installers will be saved to `/sdcard/IntegrityBox/Downloads`.
2. **Install LSPosed:** Flash the downloaded LSPosed module (`Vector.zip`) in your Root Manager and reboot your device.
3. **Install HMA / PixelMask if needed:** Install `HideMyApplist.apk` from the downloads folder, enable it in LSPosed, open it once so it creates its data folder, then force close it. If you use Google Photos Pixel features, install `PixelMask.apk`, enable it for Google Photos and PixelMask itself, then configure it in LSPosed.
4. **Inject Config:** Open WebUI -> **Hide My Stuff** -> **Inject HMA Template**. This applies a ready-made hiding profile for many banking and government apps directly into HMA.
5. **Handle strict TEE checks:** If specific apps require hardware-backed key checks, open WebUI -> **Keybox Hub** -> **Target Simulator** and enable the safer simulated environment for those apps.
6. **Hide boot state:** If apps complain about bootloader state, open WebUI -> **Detection** -> **Boot Hash Spoofer**. First tap **Get Real Boot Hash** to read your original hash. If that fails, tap the **Magic Wand** to generate a replacement value.

---

## 📚 Built-in Knowledge Base
You no longer need to hunt through a huge README for every small detail. **IntegrityBox Ultimate includes an interactive Knowledge Base directly inside the WebUI.**

* **💡 Module Guides:** Tap the blinking lightbulb icon at the top of any module page to learn exactly what that specific tool does and how it affects your system.
* **ℹ️ Feature Details:** Tap the `( i )` buttons next to individual sections for clear explanations of toggles, switches, and colored status badges.
* **🤖 AI Assistant:** An offline, built-in AI Assistant is available in the WebUI to answer common questions and troubleshoot issues interactively.

---

## 💡 Quick Troubleshooting
* **Failing Play Integrity?** Make sure SELinux is set to `Enforcing` (use **Spoof SeLinux** in the WebUI). Permissive mode usually fails immediately. Also check whether your keybox is still usable.
* **"Device not certified" in Play Store?** Even if you pass DEVICE/STRONG integrity, the Play Store caches old statuses. Use **GMS Tools** -> **Deep GMS Wipe** and reboot to fix this.
* **Google Wallet / GPay failing?** If you just updated a banned keybox, the Wallet app still remembers the security failure. Use **GMS Tools** -> **Wallet Reset** to clear its local security cache.
* **Banking apps crashing?** Use **Applist Detector** and **Hide Suspicious Files** to find and hide root-related folders such as TWRP or Magisk traces.
* **Failing strict bootloader checks?** Some apps compare your boot image hash against expected values. Open **Boot Hash Spoofer**, tap **Get Real Boot Hash**, and if that fails, use the **Magic Wand** to create a replacement value.
* **Failing TEE checks?** If an app refuses to work because it checks hardware-backed keys, use **Target Simulator** for that app. On supported devices, also try **Keybox Hub** -> **Fix Widevine L1** and reboot before checking DRM/TEE status.
* **Google Photos unlimited backup?** Use the downloaded **PixelMask** LSPosed module for Google Photos-specific Pixel features. The HMA template can hide PixelMask from apps that should not see it.
* **Need a faster WebUI workflow?** Long-press frequently used tiles for 300ms and pin them to **Quick Access**.

---

## 🤝 Credits & Acknowledgements
This project uses concepts and code from the following amazing open-source work:
- @ez-me for ezme-nodebug.
- @osm0sis for PlayIntegrityFork.
- **LSPosed Team** for Shamiko's late start service script.
- **MeowDump** for the original Integrity-Box foundation.
- **You**, for using this module.
- 🧠 **Boundless human ingenuity & wit**, for everything 🙌.

---

<div align="center">
  <h1>🛡️ IntegrityBox Ultimate</h1>
  <p><b>Набор инструментов для сертификации, Keybox и приватности Android</b></p>
  
  <a href="https://github.com/flexgav/IntegrityBox-Ultimate/releases" target="_blank">
    <img src="https://raw.githubusercontent.com/flexgav/IntegrityBox-Ultimate/main/assets/download.png" alt="Скачать" width="150">
  </a>
  <br><br>
  <a href="https://t.me/IntegrityBoxUltimateChatRU" target="_blank">
    <img src="https://img.shields.io/badge/Telegram-RU_Chat-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white" alt="Telegram RU">
  </a>
</div>

<br>

## 🚀 Обзор
**IntegrityBox Ultimate** — это удобный набор инструментов для Android с root-доступом: он помогает вернуть сертификацию Play Store, управлять Keybox, очищать следы Google-сервисов, настраивать скрытие приложений и проверять состояние устройства через понятный интерфейс в стиле Material You.

### ✨ Основные возможности
* **Quick Access:** Зажмите любую плитку WebUI, чтобы закрепить ее наверху главного экрана. Список хранится в `/data/adb/Box-Brain/quick_access.cfg`.
* **Автоматизация Security Patch:** Модуль берет дату из активных данных PIF, записывает файл Security Patch для TrickyStore в нужном формате и поддерживает эти значения после загрузки устройства.
* **Anti-Detection Nuke:** Режимы Soft, Standard и Aggressive очищают обычные следы проверок, остатки приложений и более глубокие системные следы, если вы выбираете такой режим. Там, где нужна перезагрузка, модуль сразу предупреждает об этом.
* **Починка TEE / Widevine:** **Fix Widevine L1** может восстановить встроенный Keybox на поддерживаемых устройствах, где есть системная утилита `KmInstallKeybox`.
* **Integrity Downloader:** Скачивает полезные приложения и модули: ZygiskNext, TrickyStore, HMA, PixelMask, KeyAttestation и другие инструменты.

---

## 📋 Требования
Для комфортной работы убедитесь, что на устройстве есть:

**Основные требования:**

1. Поддерживаемый Root-менеджер: **KernelSU**, **APatch** или **Magisk**.
2. **Tricky Store** или **TEE Simulator** *(нужны для приложений, которые проверяют аппаратные ключи устройства)*.
3. Приложение для открытия WebUI: **KsuWebUIStandalone**, **MMRL** или встроенная поддержка WebUI, чтобы открыть панель управления.

**Дополнительные (но настоятельно рекомендуемые):**

4. **Zygisk Next** или **ReZygisk** *(нужны для функций на базе Zygisk, если вы не используете автономный Zygiskless Pixel Mode)*.
5. **LSPosed** и **HideMyApplist (HMA)** *(рекомендуются, если банковские или государственные приложения реагируют на следы root)*.

---

## 🛠️ Установка и Полное руководство по настройке
Для чистой настройки и лучшего шанса вернуть сертификацию Play Store выполните эти шаги:

1. **Установите зависимости:** Убедитесь, что у вас установлен Root-менеджер (KernelSU/APatch/Magisk) и необходимые модули (TrickyStore/TEESimulator + ZygiskNext).
2. **Прошейте IntegrityBox Ultimate:** Установите zip-архив модуля и **перезагрузите** устройство.
3. **Запустите основное действие:** Перейдите в список модулей вашего Root-менеджера и нажмите **Action (Действие)** на карточке IntegrityBox Ultimate. Дождитесь завершения: модуль скачает рабочий Keybox и подготовит свежие данные устройства.
4. **Проверьте статус:** Откройте WebUI (кнопка настроек на карточке модуля), перейдите в **Toolkit** -> **Integrity Checker** и убедитесь, что активный Keybox имеет статус `ONLINE`, а данные устройства загружены.
5. **Почините TEE / Widevine при необходимости:** После чистой установки или обновления модуля поддерживаемые устройства могут использовать **Keybox Hub** -> **Fix Widevine L1** для восстановления Widevine/TEE через встроенный установщик Keybox. Используйте только на ROM/устройствах с совместимой утилитой `KmInstallKeybox` (часто OPPO/OnePlus/Realme и некоторые сборки Motorola). После завершения подтвердите перезагрузку.
6. **Глубокая очистка GMS (Критический шаг):** Перейдите в **Toolkit** -> **GMS Tools** и выполните **Deep GMS Wipe**. Это удалит старые состояния сертификации Google, кэшированный статус "Не сертифицировано" и данные Google Services Framework. Следуйте подсказке на экране, чтобы **перезагрузить** устройство. *(Примечание: вы выйдете из своего аккаунта Google).*
7. **Повторный вход и проверка:** После перезагрузки откройте Play Маркет, снова войдите в свой аккаунт Google и проверьте статус сертификации Play Защиты.
8. **Включите AutoPilot:** Наконец, перейдите в **Auto Pilot** -> **AutoPilot Manager** и включите автоматическое фоновое обновление. Режим Xtreme рекомендуется, если вы хотите регулярно обновлять Keybox и данные устройства.

### 🥷 Продвинутая скрытая настройка (Рекомендуется)
Если банковские или государственные приложения слишком внимательно проверяют устройство, рекомендуем настроить HideMyApplist (HMA) через встроенные инструменты:
1. **Скачайте инструменты:** Откройте WebUI -> **Miscellaneous** -> **Module Settings**. Включите **Integrity Downloader** и нажмите **Apply Changes**. Последние установщики LSPosed и HMA будут сохранены в `/sdcard/IntegrityBox/Downloads`.
2. **Установите LSPosed:** Прошейте скачанный модуль LSPosed (`Vector.zip`) в вашем Root-менеджере и перезагрузите устройство.
3. **Установите HMA / PixelMask при необходимости:** Установите `HideMyApplist.apk` из папки загрузок, включите его в LSPosed, откройте один раз для создания рабочей папки, а затем принудительно закройте. Если нужны функции Pixel в Google Photos, установите `PixelMask.apk`, включите его для Google Photos и для самого PixelMask, затем настройте в LSPosed.
4. **Примените готовый профиль:** Откройте WebUI -> **Hide My Stuff** -> **Inject HMA Template**. Это применит готовые правила скрытия для многих банковских и государственных приложений прямо в HMA.
5. **Обход проверок TEE:** Если нужные вам приложения требуют аппаратные ключи устройства, откройте WebUI -> **Keybox Hub** -> **Target Simulator** и включите более безопасную имитацию защищенной среды для этих приложений.
6. **Подмена хэша загрузки:** Если приложения ругаются на состояние загрузчика, откройте WebUI -> **Detection** -> **Boot Hash Spoofer**. Сначала нажмите **Get Real Boot Hash**, чтобы получить оригинальный хэш. Если не получилось, нажмите на **волшебную палочку**, чтобы создать замену.

---

## 📚 Встроенная база знаний
Больше не нужно искать каждую мелочь в огромном README. **IntegrityBox Ultimate включает интерактивную Базу Знаний прямо внутри WebUI.**

* **💡 Руководства по модулям:** Нажмите на мигающую иконку лампочки в верхней части любой страницы модуля, чтобы точно узнать, что делает этот конкретный инструмент и как он влияет на вашу систему.
* **ℹ️ Описание функций:** Нажимайте кнопки `( i )` рядом с отдельными разделами, чтобы получить понятное описание переключателей и цветных значков статуса.
* **🤖 AI Ассистент:** Офлайн AI-ассистент, встроенный в WebUI, готов ответить на распространенные вопросы и помочь в решении проблем в интерактивном режиме.

---

## 💡 Быстрое решение проблем
* **Не проходит Play Integrity?** Убедитесь, что SELinux установлен в режим `Enforcing` (используйте **Spoof SeLinux** в WebUI). Режим Permissive обычно сразу приводит к ошибке. Также проверьте, не заблокирован ли ваш Keybox.
* **"Устройство не сертифицировано" в Play Маркете?** Даже если вы проходите DEVICE/STRONG integrity, Play Маркет кэширует старые статусы. Используйте **GMS Tools** -> **Deep GMS Wipe** и перезагрузитесь, чтобы исправить это.
* **Google Wallet / GPay не работает?** Если вы только что заменили заблокированный Keybox, приложение Wallet может помнить старую ошибку безопасности. Используйте **GMS Tools** -> **Wallet Reset**, чтобы очистить локальные данные Wallet.
* **Банковские приложения вылетают?** Используйте **Applist Detector** и **Hide Suspicious Files**, чтобы найти и скрыть следы root, например папки TWRP или Magisk.
* **Не проходите строгие проверки загрузчика?** Некоторые приложения сравнивают хэш boot-образа с ожидаемым значением. Откройте **Boot Hash Spoofer**, нажмите **Get Real Boot Hash**, а если извлечь его не удалось, используйте **волшебную палочку**, чтобы создать замену.
* **Не проходите аппаратную аттестацию (TEE)?** Если приложение отказывается работать из-за проверки аппаратных ключей, используйте **Target Simulator** для этого приложения. На поддерживаемых устройствах также попробуйте **Keybox Hub** -> **Fix Widevine L1** и перезагрузитесь перед проверкой DRM/TEE.
* **Нужен безлимит Google Photos?** Используйте скачанный LSPosed-модуль **PixelMask** для функций Pixel в Google Photos. Шаблон HMA может скрыть PixelMask от приложений, которым не нужно его видеть.
* **Нужен быстрый доступ в WebUI?** Зажмите часто используемую плитку на 300 мс и закрепите ее в **Quick Access**.

---

## 🤝 Благодарности
Этот проект использует концепции и код из следующих потрясающих open-source проектов:
- @ez-me за ezme-nodebug.
- @osm0sis за PlayIntegrityFork.
- **Команде LSPosed** за скрипт отложенного запуска сервиса Shamiko.
- **MeowDump** за оригинальную основу Integrity-Box.
- **Вам**, за использование этого модуля.
- 🧠 **Безграничной человеческой изобретательности и уму**, за всё 🙌.
