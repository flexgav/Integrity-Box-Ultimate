<div align="center">
  <img src="ibu.png" alt="IntegrityBox Ultimate" style="border-radius: 16px; margin-bottom: 20px; box-shadow: 0 10px 30px rgba(0,0,0,0.5); width: 100%; max-width: 800px;">
  <h1>🛡️ IntegrityBox Ultimate</h1>
  <p><b>Advanced Android Environment & Attestation Manager</b></p>
  
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
**IntegrityBox Ultimate** is a comprehensive, modular toolkit designed for advanced Android environment management, system identity alignment, and deep diagnostics. Built with a focus on performance, security, and a beautiful Material You WebUI, it provides a robust framework for managing hardware-backed attestation components and evading strict system detections.

---

## 📋 Requirements
To utilize the full potential of IntegrityBox Ultimate, ensure your environment meets the following criteria:

**Core Requirements:**

1. A supported Root Manager: **KernelSU**, **APatch**, or **Magisk**.
2. **Tricky Store** or **TEE Simulator** *(Strictly required for hardware keystore attestation)*.
3. A WebUI host: **KsuWebUIStandalone**, **MMRL**, or native WebUI support to access the module's dashboard.

**Optional (but highly recommended):**

4. **Zygisk Next** or **ReZygisk** *(Required for Zygisk injection unless you are using the standalone "Zygiskless" Pixel Mode)*.
5. **LSPosed** and **HideMyApplist (HMA)** *(Required for the Advanced Stealth Setup to hide your root environment from banking apps)*.

---

## 🛠️ Installation & Ultimate Setup Guide
To guarantee a fully certified device from scratch and wipe out any previous Google bans, follow this exact pipeline:

1. **Install Dependencies:** Ensure you have your Root Manager (KernelSU/APatch/Magisk) and required modules (TrickyStore/TEESimulator + ZygiskNext) installed.
2. **Flash IntegrityBox Ultimate:** Install the module zip and **reboot** your device.
3. **Trigger Global Sync:** Go to your Root Manager's module list and tap the **Action** button on the IntegrityBox Ultimate card. Wait for the execution to finish; this automatically downloads the best working Keybox and generates a fresh Fingerprint.
4. **Verify Status:** Open the WebUI (Settings button on the module card), navigate to **Toolkit** -> **Integrity Checker**, and verify that your Active Keybox is `ONLINE` and the Device Identity is loaded.
5. **Deep Clean GMS (Crucial Step):** Go to **Toolkit** -> **GMS Tools** and perform a **Deep GMS Wipe**. This completely erases old ban traces, cached "Not Certified" statuses, and the Google Services Framework. Follow the on-screen prompt to **Reboot** your device immediately after. *(Note: You will be logged out of your Google Account).*
6. **Re-login & Verify:** After rebooting, open the Play Store, log back into your Google account, and check your Play Protect certification status. 
7. **Enable AutoPilot:** Finally, go to **Auto Pilot** -> **AutoPilot Manager** and enable the background daemon (Xtreme mode recommended) to automatically rotate keys and fingerprints before Google bans them!

### 🥷 Advanced Stealth Setup (Recommended)
For users who need to hide root from aggressive banking or government applications, we highly recommend setting up HideMyApplist (HMA) using our automated tools:
1. **Download Tools:** Open WebUI -> **Miscellaneous** -> **Module Settings**. Toggle **Integrity Downloader** ON and tap **Apply Changes**. The latest LSPosed and HMA installers will be saved to `/sdcard/IntegrityBox/Downloads`.
2. **Install LSPosed:** Flash the downloaded LSPosed module (`Vector.zip`) in your Root Manager and reboot your device.
3. **Install HMA:** Install the `HideMyApplist.apk` from the downloads folder, enable its module inside LSPosed, open it once to initialize, and then force close it.
4. **Inject Config:** Open the WebUI -> **Hide My Stuff** -> **Inject HMA Template**. This automatically applies our ultimate stealth configuration (with over 50 pre-configured banking/gov apps) directly into HMA!
5. **Bypass TEE Checks:** If your target apps use advanced hardware Keystore attestation, open WebUI -> **Keybox Hub** -> **Target Simulator** and configure a simulated secure environment for those specific apps.
6. **Spoof Boot Hash:** To bypass strict bootloader verifications, open WebUI -> **Detection** -> **Boot Hash Spoofer**, generate and inject a trusted cryptographic boot hash.

---

## 📚 Built-in Knowledge Base
We have eliminated the need for a massive, hard-to-read README file. **IntegrityBox Ultimate features a comprehensive, interactive Knowledge Base directly inside the WebUI.**

* **💡 Module Guides:** Tap the blinking lightbulb icon at the top of any module page to learn exactly what that specific tool does and how it affects your system.
* **ℹ️ Feature Details:** Tap the `( i )` buttons next to individual sections for in-depth technical explanations of toggles, switches, and colored status badges.
* **🤖 AI Assistant:** An offline, built-in AI Assistant is available in the WebUI to answer common questions and troubleshoot issues interactively.

---

## 💡 Quick Troubleshooting
* **Failing Play Integrity?** Ensure your SELinux is set to `Enforcing` (Use **Spoof SeLinux** in the WebUI). Permissive mode will cause immediate failures. Check if your hardware keybox is valid or banned.
* **"Device not certified" in Play Store?** Even if you pass DEVICE/STRONG integrity, the Play Store caches old statuses. Use **GMS Tools** -> **Deep GMS Wipe** and reboot to fix this.
* **Google Wallet / GPay failing?** If you just updated a banned keybox, the Wallet app still remembers the security failure. Use **GMS Tools** -> **Wallet Reset** to clear its local security cache.
* **Banking apps crashing?** Use the **Applist Detector** and **Hide Suspicious Files** modules to mask your root environment (TWRP, Magisk folders) from aggressive anti-cheat scans.
* **Failing strict bootloader checks?** Some advanced apps verify the cryptographic hash of your boot image. Use the **Boot Hash Spoofer** module to inject a trusted hash and hide your unlocked state.
* **Failing hardware attestation (TEE)?** If an app enforces strict Keystore checks and refuses to work, use the **Target Simulator** module to spoof the Trusted Execution Environment.

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
  <p><b>Продвинутый менеджер среды и аттестации Android</b></p>
  
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
**IntegrityBox Ultimate** — это комплексный модульный набор инструментов, созданный для продвинутого управления средой Android, подмены идентификаторов системы и глубокой диагностики. Разработанный с упором на производительность, безопасность и красивый веб-интерфейс (WebUI) в стиле Material You, он предоставляет надежный фреймворк для управления компонентами аппаратной аттестации и обхода строгих системных проверок.

---

## 📋 Требования
Для использования всего потенциала IntegrityBox Ultimate убедитесь, что ваша система соответствует следующим критериям:

**Основные требования:**

1. Поддерживаемый Root-менеджер: **KernelSU**, **APatch** или **Magisk**.
2. **Tricky Store** или **TEE Simulator** *(Строго необходимы для аппаратной аттестации хранилища ключей)*.
3. Хост для WebUI: **KsuWebUIStandalone**, **MMRL** или встроенная поддержка WebUI для доступа к панели управления модуля.

**Дополнительные (но настоятельно рекомендуемые):**

4. **Zygisk Next** или **ReZygisk** *(Необходимы для Zygisk-инъекций, если вы не используете автономный "Zygiskless" Pixel Mode)*.
5. **LSPosed** и **HideMyApplist (HMA)** *(Необходимы для продвинутой скрытой настройки, чтобы скрыть root-окружение от банковских приложений)*.

---

## 🛠️ Установка и Полное руководство по настройке
Чтобы гарантировать полную сертификацию устройства с нуля и избавиться от любых предыдущих блокировок (банов) Google, следуйте этому точному алгоритму:

1. **Установите зависимости:** Убедитесь, что у вас установлен Root-менеджер (KernelSU/APatch/Magisk) и необходимые модули (TrickyStore/TEESimulator + ZygiskNext).
2. **Прошейте IntegrityBox Ultimate:** Установите zip-архив модуля и **перезагрузите** устройство.
3. **Запустите глобальную синхронизацию:** Перейдите в список модулей вашего Root-менеджера и нажмите кнопку **Action (Действие)** на карточке IntegrityBox Ultimate. Дождитесь завершения выполнения; это автоматически скачает лучший рабочий Keybox и сгенерирует свежий отпечаток (Fingerprint).
4. **Проверьте статус:** Откройте WebUI (кнопка настроек на карточке модуля), перейдите в **Toolkit** -> **Integrity Checker** и убедитесь, что ваш Active Keybox имеет статус `ONLINE`, а Device Identity (идентификатор устройства) загружен.
5. **Глубокая очистка GMS (Критический шаг):** Перейдите в **Toolkit** -> **GMS Tools** и выполните **Deep GMS Wipe**. Это полностью удалит старые следы банов, кэшированные статусы "Не сертифицировано" и Google Services Framework. Следуйте подсказке на экране, чтобы немедленно **перезагрузить** устройство. *(Примечание: выйдете из своего аккаунта Google).*
6. **Повторный вход и проверка:** После перезагрузки откройте Play Маркет, снова войдите в свой аккаунт Google и проверьте статус сертификации Play Защиты.
7. **Включите AutoPilot:** Наконец, перейдите в **Auto Pilot** -> **AutoPilot Manager** и включите фоновый демон (рекомендуется режим Xtreme) для автоматической ротации ключей и отпечатков до того, как Google их заблокирует!

### 🥷 Продвинутая скрытая настройка (Рекомендуется)
Пользователям, которым необходимо скрыть root от агрессивных банковских или государственных приложений, мы настоятельно рекомендуем настроить HideMyApplist (HMA) с помощью наших автоматизированных инструментов:
1. **Скачайте инструменты:** Откройте WebUI -> **Miscellaneous** -> **Module Settings**. Включите **Integrity Downloader** и нажмите **Apply Changes**. Последние установщики LSPosed и HMA будут сохранены в `/sdcard/IntegrityBox/Downloads`.
2. **Установите LSPosed:** Прошейте скачанный модуль LSPosed (`Vector.zip`) в вашем Root-менеджере и перезагрузите устройство.
3. **Установите HMA:** Установите `HideMyApplist.apk` из папки загрузок, включите его модуль в LSPosed, откройте один раз для инициализации, а затем принудительно закройте.
4. **Внедрите конфиг:** Откройте WebUI -> **Hide My Stuff** -> **Inject HMA Template**. Это автоматически применит нашу ультимативную скрытую конфигурацию (с более чем 50 предварительно настроенными банковскими/гос. приложениями) прямо в HMA!
5. **Обход проверок TEE:** Если нужные вам приложения требуют строгой аппаратной аттестации Keystore, откройте WebUI -> **Keybox Hub** -> **Target Simulator** и настройте эмуляцию безопасной среды для этих конкретных приложений.
6. **Подмена хэша загрузчика:** Для обхода строгих проверок загрузчика откройте WebUI -> **Detection** -> **Boot Hash Spoofer**, сгенерируйте и внедрите доверенный криптографический хэш.

---

## 📚 Встроенная база знаний
Мы избавились от необходимости в огромном, трудночитаемом файле README. **IntegrityBox Ultimate включает обширную интерактивную Базу Знаний прямо внутри WebUI.**

* **💡 Руководства по модулям:** Нажмите на мигающую иконку лампочки в верхней части любой страницы модуля, чтобы точно узнать, что делает этот конкретный инструмент и как он влияет на вашу систему.
* **ℹ️ Описание функций:** Нажимайте кнопки `( i )` рядом с отдельными разделами для подробных технических объяснений переключателей и цветных значков статуса.
* **🤖 AI Ассистент:** Офлайн AI-ассистент, встроенный в WebUI, готов ответить на распространенные вопросы и помочь в решении проблем в интерактивном режиме.

---

## 💡 Быстрое решение проблем
* **Не проходит Play Integrity?** Убедитесь, что SELinux установлен в режим `Enforcing` (Используйте **Spoof SeLinux** в WebUI). Режим Permissive вызовет немедленный сбой. Проверьте, является ли ваш аппаратный keybox валидным и не заблокирован ли он.
* **"Устройство не сертифицировано" в Play Маркете?** Даже если вы проходите DEVICE/STRONG integrity, Play Маркет кэширует старые статусы. Используйте **GMS Tools** -> **Deep GMS Wipe** и перезагрузитесь, чтобы исправить это.
* **Google Wallet / GPay не работает?** Если вы только что обновили заблокированный keybox, приложение Wallet все еще помнит ошибку безопасности. Используйте **GMS Tools** -> **Wallet Reset**, чтобы очистить его локальный кэш безопасности.
* **Банковские приложения вылетают?** Используйте модули **Applist Detector** и **Hide Suspicious Files**, чтобы скрыть ваше root-окружение (папки TWRP, Magisk) от агрессивных античит-сканирований.
* **Не проходите строгие проверки загрузчика?** Некоторые продвинутые приложения проверяют криптографический хэш вашего boot-образа. Используйте модуль **Boot Hash Spoofer**, чтобы внедрить доверенный хэш и скрыть статус разблокировки.
* **Не проходите аппаратную аттестацию (TEE)?** Если приложение требует строгой проверки Keystore и отказывается работать, используйте модуль **Target Simulator** для подмены Trusted Execution Environment.

---

## 🤝 Благодарности
Этот проект использует концепции и код из следующих потрясающих open-source проектов:
- @ez-me за ezme-nodebug.
- @osm0sis за PlayIntegrityFork.
- **Команде LSPosed** за скрипт отложенного запуска сервиса Shamiko.
- **MeowDump** за оригинальную основу Integrity-Box.
- **Вам**, за использование этого модуля.
- 🧠 **Безграничной человеческой изобретательности и уму**, за всё 🙌.