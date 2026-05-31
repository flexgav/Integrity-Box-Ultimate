<div align="center">
  <img src="ibu.png" alt="IntegrityBox Ultimate" width="100%">
</div>

<br>

<div align="center">
  <a href="./README.md"><img src="./assets/readme_ru_icon.png" alt="Русский" height="72"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="./readme_local/README.en.md"><img src="./assets/readme_en_icon.png" alt="English" height="72"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="https://t.me/IntegrityBoxUltimateChatRU/519"><img src="./assets/download.png" alt="Скачать" height="54"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="https://t.me/IntegrityBoxUltimateChatRU"><img src="./assets/tgru_icon.png" alt="Telegram RU" height="72"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="https://t.me/IntegrityBoxUltimateChatEN"><img src="./assets/tgen_icon.png" alt="Telegram EN" height="72"></a>
</div>

---

<h1 align="center">IntegrityBox Ultimate</h1>

<p align="center">
  <b>Набор инструментов для сертификации, Keybox и приватности Android</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Recommended-Kitsune%20Magisk%20%2F%20KSU%20Next%20Spoofed-blue.svg" alt="Recommended">
  <img src="https://img.shields.io/badge/Warning-Remove%20conflicting%20modules-orange.svg" alt="Warning">
  <img src="https://img.shields.io/badge/Critical-Do%20not%20mix%20attestation%20backends-red.svg" alt="Critical">
</p>

## 📌 Обзор
**IntegrityBox Ultimate** — это удобный набор инструментов для Android с root-доступом: он помогает вернуть сертификацию Play Store, управлять Keybox, очищать следы Google-сервисов, настраивать скрытие приложений и проверять состояние устройства через понятный интерфейс в стиле Material You.

### ✨ Основные возможности
* ️ **Комплексная аттестация (Core Attestation):** Автоматическое управление `fingerprint` (PIF), инъекция `Keybox` из облака, подмена `Boot Hash` и `Security Patch` для прохождения проверок Play Integrity.
* 🕶️ **Продвинутая маскировка (Stealth):** Готовый шаблон для `HideMyApplist` (HMA) со списком из 200+ банков и детекторов, сканер опасных приложений, маскировщик файлов (`TWRP`, `Magisk`) и `Anti-Detection Nuke` для глубокой очистки следов root.
* 🤖 **Полная автоматизация (AutoPilot):** Фоновый демон, который самостоятельно скачивает и ротирует рабочие `Keybox` и `fingerprint` до того, как Google их забанит, поддерживая систему в актуальном состоянии.
* 🛠️ **Системные утилиты (System Toolkit):** Инструменты для сброса `Google Wallet`, глубокой очистки кэша `GMS`, восстановления `Widevine L1` на поддерживаемых устройствах, принудительного включения `SELinux Enforcing`, очистки данных выбранных приложений и экспорта диагностического архива для поддержки.
* 🎨 **Удобный интерфейс (Modern UI):** Понятный WebUI в стиле Material You с интерактивными плитками, быстрым доступом (`Quick Access`), встроенным `AI Assistant` и центром помощи с генерацией диагностических отчетов.
* 📥 **Выборочная загрузка утилит:** `Integrity Downloader` показывает список доступных APK/ZIP/JSON с чекбоксами, поэтому можно скачать только нужные инструменты, а не весь набор сразу.
* ⚙️ **Гибкая настройка (Advanced Configuration):** `Target Box` и `Target Simulator` поддерживают Auto/Manual режимы, импорт собственного `target.txt`, ручное управление списком приложений, `Zygiskless Mode` и селектор профилей для переключения между разными стратегиями маскировки.

---

## 🧩 Основные требования

Для комфортной работы и максимальной скрытности убедитесь, что окружение собрано без конфликтующих root-движков, backend’ов аттестации и лишних следов в пользовательском профиле.

1. **Root-решение.** Рекомендуемый порядок для устройств, где важна работа банковских и государственных приложений:

   - **Предпочтительно:** [**SukiSU Ultra**](https://github.com/SukiSU-Ultra/SukiSU-Ultra/releases/latest) или [**KernelSU Next**](https://github.com/KernelSU-Next/KernelSU-Next/releases/latest) в связке с **SUSFS**.
     Для полноценной работы SUSFS требуется не только Manager APK, а ядро/AnyKernel3/boot-образ, в который уже встроены SUSFS-патчи. После прошивки такого ядра дополнительно установите userspace-модуль [**susfs4ksu / SUSFS-FOR-KERNELSU**](https://github.com/sidex15/susfs4ksu-module/releases/latest).

   - **Альтернатива:** [**APatch**](https://github.com/bmax121/APatch/releases/latest), если для устройства нет стабильного KernelSU/SukiSU/SUSFS-ядра или требуется kernel-based root без Magisk-подобной схемы.

   - **Fallback-вариант:** [**Kitsune Magisk / Kitsune Ufork**](https://t.me/KitsuneUfork). Используйте его только если KernelSU Next, SukiSU Ultra или APatch недоступны для вашего устройства. Для строгих банковских приложений стабильная работа на Kitsune не гарантируется, так как Magisk-подобные окружения чаще оставляют видимые следы.

   Используйте только **одно** root-решение одновременно. Не смешивайте Magisk/Kitsune, KernelSU Next, SukiSU Ultra и APatch в одной системе без полного понимания последствий.

2. **SUSFS и скрытность.** Если выбран SukiSU Ultra или KernelSU Next, для лучшего антидетекта рекомендуется использовать сборку ядра с **SUSFS** под конкретное устройство, версию Android, ветку ядра и прошивку.

   Простое патчирование `boot.img` или `init_boot.img` через Manager может дать root-доступ, но не гарантирует наличие SUSFS. Если ядро не содержит SUSFS-патчи, модуль `susfs4ksu` не сможет включить kernel-level скрытие.

3. **Backend для аппаратной аттестации.** Установите [**Tricky Store**](https://github.com/5ec1cff/TrickyStore/releases/latest) или [**TEE Simulator**](https://github.com/JingMatrix/TEESimulator/releases/latest), если приложения проверяют hardware-backed ключи и TEE/KeyMint-аттестацию.

   Используйте только **один** backend аттестации. Tricky Store, TrickyStoreOSS, TEE Simulator и их форки не должны работать одновременно.

4. **WebUI.** Для открытия панели управления установите [**MMRL**](https://github.com/MMRLApp/MMRL/releases/latest), [**WebUI X Portable**](https://github.com/MMRLApp/WebUI-X-Portable/releases/latest) или используйте встроенную поддержку WebUI в root-менеджере.

   Если WebUI не открывается напрямую, заранее установите [**KsuWebUIStandalone**](https://github.com/KOWX712/KsuWebUIStandalone/releases/latest) вручную как fallback-вариант. После первого входа в WebUI его APK также можно скачать через Integrity Downloader.

## ⚠️ Конфликтующие модули, которые нужно удалить или отключить

> [!IMPORTANT]
> Перед установкой удалите другие модули и решения для починки Integrity / Play Integrity сертификации, чтобы они не конфликтовали с IntegrityBox Ultimate.

> [!CAUTION]
> Не смешивайте несколько модулей, которые одновременно меняют Keybox, fingerprint, GMS-состояние, DroidGuard, VBMeta или Play Integrity verdicts. Такие конфликты часто дают нестабильную сертификацию и ложные срабатывания банковских приложений.

<ul>
  <li><b>🧬 Play Integrity / DroidGuard spoofers:</b> PlayIntegrityFix / PIF, Play Integrity Fix Next / PlayIntegrityFix-NEXT, Play Integrity Fork / PIFork, PlayIntegritySuperFork, Play Integrity Fix Advanced, Strong Integrity Fix, SafetyNet Fix, Universal SafetyNet Fix, Displax SafetyNet Fix и другие PIF/SafetyNet-форки.</li>
  <li><b>🧰 All-in-one решения для Integrity / Keybox:</b> Integrity-Box, Integrity Box forks, старые сборки IntegrityBox, Tricky Addon, Tricky Addon Enhanced / Update Target List и аналоги, если они самостоятельно управляют keybox, target.txt, security patch, VBHash или GMS-состоянием.</li>
  <li><b>🔑 Key attestation / Keybox backend:</b> не держите одновременно Tricky Store, TrickyStoreOSS, TEE Simulator, TEESimulator-RS и их форки. Оставьте только тот backend, который выбран для работы с IntegrityBox Ultimate.</li>
  <li><b>🧾 Build props / fingerprint / security patch spoofers:</b> MagiskHide Props Config, Sensitive Props, Pixel Props / build.prop, Build-Prop-BETA, PixelFlasher PIF helper, XiaomiEU Injected PIF и любые ROM-встроенные PIF / Pixel props spoof.</li>
  <li><b>📱 Pixel spoofing modules:</b> Pixelify, Pixelify Next, Pix3lify, Pixel Features, Google Photos Unlimited Backup и похожие модули, если они меняют <code>ro.product*</code>, fingerprint, model, brand, security patch или свойства GMS.</li>
  <li><b>🧱 VBMeta / boot hash spoofers:</b> Android VBMeta Fixer, VBMeta Disguiser и аналоги, если одновременно используются функции IntegrityBox Ultimate для Boot Hash / verifiedBootHash / VBMeta.</li>
  <li>Другие модули, которые меняют fingerprint, build props, GMS-состояние, DroidGuard, Keybox, attestation, security patch, VBMeta, boot hash или Play Integrity verdicts.</li>
</ul>

## 🚨 Важно для пользователей классического Magisk Stable

> [!WARNING]
> Классический [**Magisk Stable**](https://github.com/topjohnwu/Magisk/releases/latest) не является рекомендуемым вариантом для IntegrityBox Ultimate, если цель — стабильная работа банковских приложений и строгих проверок окружения. Настоятельно рекомендуется перейти на [**Kitsune Magisk / Kitsune Ufork**](https://t.me/KitsuneUfork) или на [**KSU Next Spoofed**](https://github.com/KernelSU-Next/KernelSU-Next/releases/latest) *(в релизах выбирайте APK с `-spoofed_...-release.apk`)*, иначе стабильная работа банковских приложений не гарантируется.

## ➕ Дополнительные, но настоятельно рекомендуемые

1. [**Zygisk Next**](https://github.com/Dr-TSNG/ZygiskNext/releases/latest) или [**ReZygisk**](https://github.com/PerformanC/ReZygisk/releases/latest) *(нужны для функций на базе Zygisk, если вы не используете автономный Zygiskless Pixel Mode)*.
2. [**LSPosed / Vector**](https://github.com/JingMatrix/Vector/releases/latest) и [**HideMyApplist / HMA-OSS**](https://github.com/frknkrc44/HMA-OSS/releases/latest) *(рекомендуются, если банковские или государственные приложения реагируют на список приложений, root-следы или установленные модули)*. Альтернативная ветка HMA: [**Hide-My-Applist**](https://github.com/Dr-TSNG/Hide-My-Applist/releases/latest).

## 📦 Полезные инструменты из Integrity Downloader

> [!TIP]
> Integrity Downloader больше не скачивает весь набор вслепую. После включения плитки **Integrity Downloader** и нажатия **Apply Changes** появится окно выбора: отметьте чекбоксами только нужные утилиты и нажмите **Download Selected**. После подтверждения откроется терминальное окно с прогрессом загрузки.

Текущий список из `assets/tools.list`:

* **ZygiskNext.zip** — актуальный Zygisk Next для Root-менеджеров без встроенного Zygisk.
* **TrickyStore.zip** — backend для аппаратной аттестации.
* **KeyAttestation.apk** — приложение для ручной проверки сертификатов и verdict-данных.
* **UpdateLocker.apk** — LSPosed-модуль для блокировки нежелательных обновлений приложений.
* **HMA_Config.json** — готовый профиль IntegrityBox для HideMyApplist.
* **HMA_OSS.apk** — актуальная сборка HideMyApplist OSS.
* **PixelMask.apk** — LSPosed-модуль для Pixel/GMS-сценариев.
* **KSU_WebUI.apk** — отдельное приложение WebUI для устройств, где Root-менеджер не открывает WebUI напрямую.
* **Core_Patch.apk** — LSPosed-модуль для патча системных ограничений установки/подписи.
* **Thor_Installer.apk** — менеджер/инсталлер для дополнительных Android-инструментов.
* **Android_Faker.apk** — утилита для ручной проверки и настройки Android-идентификаторов.
* **LSPosedVector.zip** — LSPosed / Vector для работы HMA и других LSPosed-модулей.
* **Duck_Detector.apk** — детектор root/Xposed/Magisk с нативными проверками; полезен для диагностики обнаружения рут-среды.
* **Native_Root_Detector.apk** — нативный детектор рут, показывающий что именно приложения могут видеть при низкоуровневом сканировании.

## 📁 Где искать файлы, скачанные через Integrity Downloader

> [!NOTE]
> Все выбранные APK/ZIP/JSON, скачанные через Integrity Downloader, сохраняются в `/sdcard/IntegrityBox/Downloads`.

| Инструмент | Имя файла | Полный путь |
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

## 🚀 Установка и полное руководство по настройке
Для чистой настройки и лучшего шанса вернуть сертификацию Play Store выполните эти шаги:

> [!TIP]
> Если вы настраиваете модуль впервые, проходите шаги по порядку и не включайте дополнительные инструменты до первичной проверки сертификации Play Маркета.

1. ✅ **Установите зависимости:** Убедитесь, что у вас установлен Root-менеджер и выбран только один backend аппаратной аттестации.
2. 📲 **Прошейте IntegrityBox Ultimate:** Установите zip-архив модуля. Во время установки модуль автоматически синхронизирует каталог Keybox из облака. Если отображается запрос **«Стереть данные предыдущей установки?»** — нажмите **Vol Up** для сброса или **Vol Down** для сохранения настроек.
3. 🔄 **Перезагрузите устройство.** При первой загрузке модуль автоматически выполняет начальную настройку: отключает встроенный ROM-спуфинг, активирует режим банков, извлекает реальный Boot Hash, запускает Standard Nuke, применяет настройки ZygiskNext, пробует восстановить Widevine L1 и включает AutoPilot Xtreme.
4. ▶️ **Запустите основное действие:** Перейдите в список модулей Root-менеджера и нажмите **Action** на карточке IntegrityBox Ultimate. Дождитесь завершения: модуль обновит Keybox и подготовит свежие данные устройства.
5. 🔎 **Проверьте статус:** Откройте WebUI → **Toolkit** → **Integrity Checker** и убедитесь, что активный Keybox имеет статус `ONLINE`, а данные устройства загружены.
6. 🧼 **Глубокая очистка GMS:** Перейдите в **Toolkit** → **GMS Tools** и выполните **Deep GMS Wipe**. Это удалит старые состояния сертификации Google и данные Google Services Framework. Следуйте подсказке, чтобы **перезагрузить** устройство. *(Вы выйдете из аккаунта Google.)*
7. ✅ **Повторный вход и проверка:** После перезагрузки откройте Play Маркет, снова войдите в аккаунт Google и проверьте статус сертификации Play Защиты.
8. 🤖 **Проверьте AutoPilot:** Перейдите в **Auto Pilot** → **AutoPilot Manager** — демон уже должен быть включён в режиме Xtreme. При необходимости переключите режим на **Keybox Only** для минимального воздействия на систему.
9. 🧹 **Custom ROM Props при необходимости:** Если устройство работает на кастомной прошивке, откройте **Custom ROM Spoofing** → **Spoof ROM Props** и нажмите **Auto Mode** — модуль сам определит, следы каких ROM-семейств есть на устройстве, и включит нужные карточки очистки.
10. 📦 **Соберите диагностический архив при проблемах:** Если сертификация или приложения всё ещё работают нестабильно, откройте **Help Center** → **Export Report**. Архив появится в `/sdcard/IntegrityBox/Reports`.

> [!NOTE]
> Boot Hash и Widevine L1 настраиваются автоматически при первой установке. Если потребуется изменить Boot Hash вручную — откройте **Detection** → **Boot Hash Spoofer**. Для повторного запуска Widevine L1 — **Keybox Hub** → **Fix Widevine L1**.

### 🕶️ Продвинутая настройка скрытности
Если банковские или государственные приложения слишком внимательно проверяют устройство, рекомендуем настроить HideMyApplist (HMA) через встроенные инструменты:

> [!IMPORTANT]
> Обычно HMA не нужно открывать вручную перед применением профиля: IntegrityBox Ultimate пытается сам создать нужные data-директории и записать конфигурацию. Если автоматическое применение не сработало, откройте HMA один раз, закройте его и повторите **Inject HMA Template**.

1. 📥 **Скачайте инструменты:** Откройте WebUI -> **Miscellaneous** -> **Module Settings**. Включите **Integrity Downloader** и нажмите **Apply Changes**. В появившемся окне отметьте чекбоксами нужные позиции. Для HMA-сценария обычно нужны **LSPosedVector.zip**, **HMA_OSS.apk** и **HMA_Config.json**. Скачанные файлы появятся в `/sdcard/IntegrityBox/Downloads`.
2. 🧩 **Установите LSPosed / Vector:** Прошейте `/sdcard/IntegrityBox/Downloads/LSPosedVector.zip` в вашем Root-менеджере и перезагрузите устройство.
3. 🕵️ **Установите HMA:** Откройте `/sdcard/IntegrityBox/Downloads/HMA_OSS.apk`, установите HideMyApplist и включите его в LSPosed.
4. 🛡️ **Примените готовый профиль HMA:** Откройте WebUI -> **Hide My Stuff** -> **Inject HMA Template**. Это применит готовые правила скрытия для многих банковских и государственных приложений прямо в HMA.
5. 📱 **Установите PixelMask для функций Google Photos:** PixelMask позволяет открыть на вашем смартфоне некоторые Pixel-функции Google Photos. В зависимости от выбранного профиля это может быть безлимитная загрузка фото и видео в исходном качестве или Pixel-only возможности вроде Video Boost, Night Sight Video, Add Me, Reimagine и Magic Editor.

Для максимальной скрытности и антидетекта дополнительно используйте эти функции по симптомам:

1. 🏦 **Banking Mode:** Откройте **Toolkit** -> **Utility Box** и включите **Banking Mode**. Он скрывает ADB/debug-состояние и выставляет `sys.oem_unlock_allowed=0`.
2. 🛡️ **SELinux Enforcing:** На главной откройте **Cleanup & SELinux** -> **Enforce SELinux** и убедитесь, что в статусе модуля SELinux отображается как `Enforcing`.
3. 🧩 **Строгая изоляция Zygisk/Shamiko:** Используйте **ZygiskNext & Shamiko** -> **Enable Whitelist Mode**, чтобы включить строгий режим изоляции. Список приложений для скрытия root/Zygisk настраивается отдельно в DenyList вашего Root-менеджера или в настройках ZygiskNext/Shamiko.
4. ⚙️ **Оптимизация ZygiskNext:** Нажмите **ZygiskNext & Shamiko** -> **Optimize ZygiskNext**, если используете Zygisk Next. Модуль применит рекомендуемые stealth-настройки контроллера.
5. 🧰 **Антидетект-флаги:** В **Miscellaneous** → **Module Settings** включайте только нужные пункты: **Debug Fingerprint**, **Debug Build**, **Build Tag**, **Clear LSposed**, **Spoof Encryption**, **Hide Recovery**, **Clear Gapps Logs** и **Archive Manager Logs**. Для очистки следов прошивки используйте **Custom ROM Spoofing** → **Spoof ROM Props**.
6. 🗂️ **Скрытие подозрительных файлов:** Используйте **Hide My Stuff** -> **Hide Suspicious Files**, если приложение видит папки `TWRP`, `Fox`, `Magisk`, менеджеры root или старые следы на `/sdcard`. Не добавляйте случайные системные пути.
7. 🧹 **Сброс состояния приложения:** После изменения HMA, Target, props или Boot Hash откройте **Cleanup & SELinux** -> **App Data Cleaner** и очистите данные/кэш проблемного приложения, чтобы оно заново проверило окружение.
8. 🔥 **Anti-Detection Nuke:** Используйте **Detection** -> **Anti-Detection Nuke** только при явных остаточных следах. Начинайте с **Soft Cleanup**, затем **Standard Nuke**. **Aggressive Nuke** оставьте как крайний вариант.
9. 🧪 **System Prop Spoofer:** Используйте **Detection** -> **System Prop Spoofer** только если понимаете, какие `getprop`-следы нужно сбросить или удалить.

<details>
<summary><strong>Подробная таблица System Prop Spoofer</strong></summary>

#### Сводка по назначению

| Раздел | Что затрагивает | Когда использовать |
| --- | --- | --- |
| Reset Props | ADB, debug/dev state, secure mode, bootloader/Verified Boot, build type, OEM unlock, emulator flags. | Когда нужно подставить безопасные user/locked/release-like значения вместо опасных текущих значений. |
| Duck Detector Props | Небольшой набор props, которые часто проверяют строгие native-детекторы. | Когда нужно удалить сами ключи из текущего property space, а не подменить их значения. |
| Delete Props | ROM-брендовые свойства, Pixel/EliteProps/PIF leftovers и другие следы старых spoof-модулей. | Когда нужно удалить сам факт наличия кастомного/спуфинг-свойства из текущего property space. |
| Nuke Trash | `*.odex`, `*.vdex`, `base.odex` в `/data/app`. | Когда детектор цепляется за старые odex/vdex-артефакты после модулей или обновлений приложений. |

#### Reset Props

| Пункт в UI | Props / действие | За что отвечает |
| --- | --- | --- |
| USB Debug Block | `sys.usb.adb.disabled=1` | Подставляет признак отключенного ADB по USB. |
| MTP Only Mode | `persist.sys.usb.config=mtp`, `sys.usb.config=mtp`, `sys.usb.state=mtp` | Убирает ADB из USB-конфигурации и оставляет режим MTP. |
| ADB Root Off | `service.adb.root=0`, `service.adb.tcp.port=-1` | Отключает root shell через ADB и ADB over TCP. |
| Secure Mode | `ro.secure=1`, `ro.adb.secure=1` | Возвращает признаки secure-сборки и защищенного ADB. |
| Debug Off | `ro.debuggable=0`, `persist.sys.debuggable=0` | Скрывает debug/userdebug-состояние. |
| Dev Options Off | `persist.sys.developer_options=0`, `persist.sys.dev_mode=0` | Сбрасывает persistent-признаки режима разработчика. |
| Global Settings | `development_settings_enabled=0`, `adb_enabled=0`, `oem_unlock_allowed=0` | Сбрасывает глобальные Android-настройки Developer Options, ADB и OEM unlock. |
| Verified Boot | `ro.boot.verifiedbootstate=green`, `vendor.boot.verifiedbootstate=green` | Подставляет green-состояние Verified Boot. |
| Flash Locked | `ro.boot.flash.locked=1` | Подставляет признак заблокированной прошивки flash-разделов. |
| VBMeta Locked | `ro.boot.vbmeta.device_state=locked`, `vendor.boot.vbmeta.device_state=locked` | Подставляет locked-состояние VBMeta/device state. |
| SecureBoot | `ro.secureboot.lockstate=locked` | Подставляет locked-состояние Secure Boot. |
| Warranty Valid | `ro.boot.warranty_bit=0` | Сбрасывает warranty bit к значению без срабатывания. |
| User Build | `ro.build.type=user`, `ro.build.tags=release-keys` | Подставляет признаки обычной release-сборки. |
| OEM Lock | `ro.oem_unlock_supported=0`, `sys.oem_unlock_allowed=0` | Скрывает поддержку/разрешение OEM unlock. |
| No Emulator | `ro.kernel.qemu=0`, `ro.boot.qemu=0`, `ro.hardware.virtual_device=0` | Убирает базовые признаки emulator/virtual device. |
| Nuke Trash | Удаление `*.odex`, `*.vdex`, `base.odex` в `/data/app` | Очищает старые артефакты оптимизации приложений; это не `getprop`. |

#### Duck Detector Props

| Пункт в UI | Prop | Действие |
| --- | --- | --- |
| ADB Secure | `ro.adb.secure` | Удаляет prop через `resetprop --delete`, если он есть в текущем property space. |
| Verified Boot State | `ro.boot.verifiedbootstate` | Удаляет prop через `resetprop --delete`, если он есть в текущем property space. |
| Verity Mode | `ro.boot.veritymode` | Удаляет prop через `resetprop --delete`, если он есть в текущем property space. |
| Build Tags | `ro.build.tags` | Удаляет prop через `resetprop --delete`, если он есть в текущем property space. |
| Build Type | `ro.build.type` | Удаляет prop через `resetprop --delete`, если он есть в текущем property space. |

#### Delete Props

Все пункты ниже **удаляют выбранный prop** из текущего Android property space через `resetprop --delete`. Значение не спуфится и не заменяется. Если prop отсутствует, модуль пропускает его.

| Пункт в UI | Prop |
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

### 🎯 Ручное управление Target List
Если вы хотите использовать собственный список приложений вместо автоматического шаблона:

1. Откройте WebUI -> **Customize Tricky Store** -> **Target Box**.
2. Отключите **Auto Update Target List**, если хотите полностью контролировать `target.txt` вручную.
3. Используйте **Import Target**, чтобы выбрать свой файл `target.txt` через встроенный проводник.
4. Для точечной настройки отдельных приложений откройте **Customize Tricky Store** -> **Target Simulator**: там можно выбрать приложение, профиль и режим, а также импортировать собственный target-файл.
5. Если **Auto Update Target List** снова включить, модуль применит свои правила и обновит отображение списка из актуального `target.txt`.

---

## 📚 Встроенная база знаний
Больше не нужно искать каждую мелочь в огромном README. **IntegrityBox Ultimate включает интерактивную Базу Знаний прямо внутри WebUI.**

* 💡 **Руководства по модулям:** Нажмите на иконку лампочки в верхней части любой страницы модуля, чтобы узнать, что делает конкретный инструмент.
* ℹ️ **Описание функций:** Нажимайте кнопки `( i )` рядом с отдельными разделами, чтобы получить понятное описание переключателей и цветных значков статуса.
* 🤖 **AI Ассистент:** Офлайн AI-ассистент, встроенный в WebUI, готов ответить на распространенные вопросы и помочь в решении проблем.

---

## 🛠️ Быстрое решение проблем
> [!NOTE]
> Начинайте с простых действий: проверка Keybox, Deep GMS Wipe, перезагрузка и повторная проверка Play Маркета. Target Simulator, Boot Hash Spoofer и Nuke используйте только когда понятно, какая именно проверка не проходит.

### 🧪 Play Integrity не проходит
1. Откройте WebUI -> **Toolkit** -> **Integrity Checker**.
2. Проверьте **Active Keybox**: статус должен быть `ONLINE`, а источник Keybox должен отображаться корректно.
3. Если Keybox отсутствует или статус не `ONLINE`, откройте WebUI -> **Keybox Hub** -> **Keybox Loader**. Сверху выберите **Slot 1** *(основной слот)*, нажмите **Force Cloud Sync**, дождитесь обновления списка, затем нажмите на свежий Keybox с бейджем `PROVIDER` и подтвердите загрузку в **Slot 1**. Если cloud-список не появился, проверьте интернет и доступ к GitHub. Если синхронизация все равно недоступна, положите свой XML Keybox в `/sdcard/Download` или `/sdcard/Documents`, нажмите кнопку обновления списка и загрузите найденный `LOCAL` Keybox в **Slot 1**.
4. После обновления Keybox выполните WebUI -> **Toolkit** -> **GMS Tools** -> **Deep GMS Wipe**, перезагрузите устройство и снова проверьте Play Маркет.

### 🛒 Play Маркет пишет "Устройство не сертифицировано"
1. Убедитесь, что Play Integrity уже проходит в **Integrity Checker**.
2. Включите скрытые параметры разработчика Play Маркета: откройте **Play Маркет** -> нажмите на аватар профиля справа сверху -> **Настройки** -> **О приложении** -> нажмите **Версия Play Маркета** 7 раз, пока не появится сообщение о включении режима разработчика.
3. Проверьте verdict целостности: вернитесь в **Настройки** Play Маркета -> **Общие** -> **Параметры разработчика** -> в блоке **Play Integrity** нажмите **Проверить целостность**.
4. В результате проверки устройство должно получать успешный verdict. Для обычной сертификации Play Маркета должен проходить **Device integrity** / `MEETS_DEVICE_INTEGRITY`; для Google Wallet и строгих банковских приложений обычно нужен успешный **Strong integrity** / `MEETS_STRONG_INTEGRITY`.
5. Отдельно проверьте статус сертификации: **Play Маркет** -> аватар профиля -> **Настройки** -> **О приложении** -> **Сертификация Play Защиты**. В норме там должно быть написано **Устройство сертифицировано**.
6. Если verdict целостности проходит, но Play Маркет все еще пишет **Устройство не сертифицировано**, откройте WebUI -> **Toolkit** -> **GMS Tools** -> **Deep GMS Wipe**.
7. Перезагрузите устройство, откройте Play Маркет, войдите в аккаунт заново и подождите несколько минут. Затем повторите проверку целостности и сертификации по шагам выше.

### 💳 Google Wallet / GPay не работает
1. Сначала выполните встроенную проверку Play Integrity через Play Маркет: **Play Маркет** -> аватар профиля -> **Настройки** -> **Общие** -> **Параметры разработчика** -> **Play Integrity** -> **Проверить целостность**. Если раздела **Параметры разработчика** нет, включите его по инструкции из сценария выше.
2. Для Google Wallet обычно должен проходить **Strong integrity** / `MEETS_STRONG_INTEGRITY`. Если проходит только **Device integrity**, Play Маркет может быть сертифицирован, но Wallet все равно может отклонять оплату.
3. Если **Strong integrity** не проходит, вернитесь к сценарию **Play Integrity не проходит**: проверьте **Active Keybox**, обновите Keybox через **Keybox Loader**, затем выполните **Deep GMS Wipe** и перезагрузитесь.
4. Если **Strong integrity** проходит, но Wallet все равно не работает, откройте WebUI -> **Toolkit** -> **GMS Tools** -> **Wallet Reset**. Это очищает локальное состояние Wallet, которое могло запомнить прошлую ошибку безопасности.
5. Перезагрузите устройство, откройте Google Wallet, снова добавьте карты при необходимости и проверьте бесконтактную оплату.

### 🏦 Банковское приложение видит root, Xposed или подозрительные приложения
1. Убедитесь, что установлен **HideMyApplist / HMA-OSS**, модуль HMA включен в LSPosed, а банковское приложение отмечено в области действия LSPosed для HMA.
2. Если профиль еще не применялся, откройте WebUI -> **Hide My Stuff** -> **Inject HMA Template**. Это загрузит готовую конфигурацию IntegrityBox в HMA.
3. Откройте HMA и выберите нужное банковское приложение в разделе приложений, от которых нужно скрывать окружение.
4. Примените к нему шаблоны и пресеты **FlexGAV 5.5**: blacklist/template для скрываемых приложений, detector/root/sus-apps пресеты, а также пресеты настроек вроде accessibility/dev options/input method, если они доступны в вашем HMA.
5. Сохраните конфигурацию HMA, принудительно остановите банковское приложение или перезагрузите устройство, затем проверьте приложение снова.

### 🔐 Приложение не проходит аппаратную аттестацию / TEE
> [!IMPORTANT]
> Target Simulator настраивается для конкретного приложения. Не применяйте его ко всем приложениям сразу.

1. Сначала убедитесь, что **Active Keybox** в **Integrity Checker** имеет статус `ONLINE`.
2. Откройте WebUI -> **Customize Tricky Store** -> **Target Simulator**.
3. Найдите нужное приложение по названию или package name.
4. Для первой попытки выберите профиль **Default** и режим **AUTO**, затем нажмите **Save**.
5. Принудительно остановите проблемное приложение или перезагрузите устройство, затем проверьте приложение снова.
6. Если **AUTO** не помог, попробуйте **LEAF** для этого же приложения. **GENERATE** используйте только как последний вариант, если понятно, что приложению не подходит обычная цепочка аттестации.

### 🔓 Приложение ругается на загрузчик, VBMeta или boot hash
1. Откройте WebUI -> **Detection** -> **Boot Hash Spoofer**.
2. Нажмите **Get Real Boot Hash**. Модуль сначала проверит аппаратные boot-источники: `/proc/cmdline`, device-tree и `/proc/bootconfig`.
3. Если boot-источники не вернули валидный hash, модуль автоматически попробует fallback через локальную Java Key Attestation операцию. Отдельно запускать ее не нужно.
4. Если поле заполнилось 64-символьным hash, нажмите **Apply**, затем **Reboot** и проверьте приложение снова.
5. Если появилось **Extraction Failed**, откройте **Help Center** -> **Export Report** и сохраните диагностический архив: в нем будут логи `boot_hash_extract.log` и `boot_hash_attestation.log`.
6. Если реальный hash получить не удалось, используйте **Magic Wand** только как запасной вариант: она генерирует валидный 64-символьный hash, но это не реальное значение устройства.
7. Если нужно откатить изменение, вернитесь в **Boot Hash Spoofer**, нажмите **Reset** и перезагрузите устройство.

### 📌 Нужен быстрый доступ к часто используемым инструментам
Зажмите нужную плитку WebUI примерно на 300 мс, чтобы закрепить ее в **Quick Access** на главной странице.

### 🆘 Ничего не помогло
Если после всех шагов не удалось добиться сертификации Google или стабильной работы нужных приложений, перейдите в Telegram-группу по ссылкам в шапке README и напишите в тему помощи и поддержки. Опишите модель устройства, прошивку, Root-менеджер, используемый backend аттестации, результат Play Integrity из Play Маркета и что уже пробовали сделать.

---

## 🧩 Исходники бинарных компонентов
JS, HTML, CSS, shell-скрипты и конфиги модуля уже лежат в ZIP в открытом виде. Отдельно публикуются только исходники компонентов, которые попадают в модуль как собранные бинарные файлы:

- `sources/zygisk/` — исходники и заметки по сборке native Zygisk-библиотек из `IntegrityBox-Ultimate-Clnt/zygisk/*.so`.
- `sources/boot-hash-attestation/` — исходники и заметки по сборке helper-файла `boot_attest.jar`.
- `sources/licenses/` — лицензии и notices для собранных компонентов.

---

## 🙏 Благодарности
Этот проект использует концепции и код из следующих open-source проектов:
- @ez-me за ezme-nodebug.
- @osm0sis за PlayIntegrityFork.
- **Команде LSPosed** за скрипт отложенного запуска сервиса Shamiko.
- **MeowDump** за оригинальную основу Integrity-Box.
- **Вам**, за использование этого модуля.
