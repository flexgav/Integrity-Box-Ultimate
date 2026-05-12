<div align="center">
  <img src="ibu.png" alt="IntegrityBox Ultimate" width="100%">
</div>

<br>

<div align="center">
  <a href="./README.md"><img src="./assets/readme_ru_icon.png" alt="Русский" height="72"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="./readme_local/README.en.md"><img src="./assets/readme_en_icon.png" alt="English" height="72"></a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="https://github.com/flexgav/IntegrityBox-Ultimate/releases/latest"><img src="./assets/download.png" alt="Скачать" height="54"></a>
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

## Обзор
**IntegrityBox Ultimate** — это удобный набор инструментов для Android с root-доступом: он помогает вернуть сертификацию Play Store, управлять Keybox, очищать следы Google-сервисов, настраивать скрытие приложений и проверять состояние устройства через понятный интерфейс в стиле Material You.

### Основные возможности
* **Quick Access:** Зажмите любую плитку WebUI, чтобы закрепить ее наверху главного экрана. Список хранится в `/data/adb/Box-Brain/quick_access.cfg`.
* **Автоматизация Security Patch:** Модуль берет дату из активных данных PIF, записывает файл Security Patch для TrickyStore в нужном формате и поддерживает эти значения после загрузки устройства.
* **Anti-Detection Nuke:** Режимы Soft, Standard и Aggressive очищают обычные следы проверок, остатки приложений и более глубокие системные следы, если вы выбираете такой режим. Там, где нужна перезагрузка, модуль сразу предупреждает об этом.
* **Починка TEE / Widevine:** **Fix Widevine L1** может восстановить встроенный Keybox на поддерживаемых устройствах, где есть системная утилита `KmInstallKeybox`.
* **Integrity Downloader:** Скачивает полезные приложения и модули: ZygiskNext, TrickyStore, HMA, PixelMask, KeyAttestation и другие инструменты.

---

## Требования
Для комфортной работы убедитесь, что на устройстве есть:

**Основные требования:**

1. Поддерживаемый Root-менеджер: [**KernelSU Next**](https://github.com/KernelSU-Next/KernelSU-Next/releases/latest), [**APatch**](https://github.com/bmax121/APatch/releases/latest) или [**Kitsune Magisk / Kitsune Ufork**](https://t.me/KitsuneUfork).
2. Backend для аппаратной аттестации: [**Tricky Store**](https://github.com/5ec1cff/TrickyStore/releases/latest) или [**TEE Simulator**](https://github.com/JingMatrix/TEESimulator/releases/latest) *(нужны для приложений, которые проверяют аппаратные ключи устройства)*. Используйте только один backend: Tricky Store, TrickyStoreOSS, TEE Simulator и их форки не должны работать одновременно.
3. Приложение для открытия WebUI: [**MMRL**](https://github.com/MMRLApp/MMRL/releases/latest), [**WebUI X Portable**](https://github.com/MMRLApp/WebUI-X-Portable/releases/latest) или встроенная поддержка WebUI в Root-менеджере. [**KsuWebUIStandalone**](https://github.com/5ec1cff/KsuWebUIStandalone/releases/latest) можно использовать только как старый fallback-вариант, так как репозиторий архивирован.
4. Перед установкой удалите другие модули и решения для починки Integrity / Play Integrity сертификации, чтобы они не конфликтовали с IntegrityBox Ultimate.

**Конфликтующие модули, которые нужно удалить или отключить:**

<ul>
  <li><b>Play Integrity / DroidGuard spoofers:</b> PlayIntegrityFix / PIF, Play Integrity Fix Next / PlayIntegrityFix-NEXT, Play Integrity Fork / PIFork, PlayIntegritySuperFork, Play Integrity Fix Advanced, Strong Integrity Fix, SafetyNet Fix, Universal SafetyNet Fix, Displax SafetyNet Fix и другие PIF/SafetyNet-форки.</li>
  <li><b>All-in-one решения для Integrity / Keybox:</b> Integrity-Box, Integrity Box forks, старые сборки IntegrityBox, Tricky Addon, Tricky Addon Enhanced / Update Target List и аналоги, если они самостоятельно управляют keybox, target.txt, security patch, VBHash или GMS-состоянием.</li>
  <li><b>Key attestation / Keybox backend:</b> не держите одновременно Tricky Store, TrickyStoreOSS, TEE Simulator, TEESimulator-RS и их форки. Оставьте только тот backend, который выбран для работы с IntegrityBox Ultimate.</li>
  <li><b>Build props / fingerprint / security patch spoofers:</b> MagiskHide Props Config, Sensitive Props, Pixel Props / build.prop, Build-Prop-BETA, PixelFlasher PIF helper, XiaomiEU Injected PIF и любые ROM-встроенные PIF / Pixel props spoof.</li>
  <li><b>Pixel spoofing modules:</b> Pixelify, Pixelify Next, Pix3lify, Pixel Features, Google Photos Unlimited Backup и похожие модули, если они меняют <code>ro.product*</code>, fingerprint, model, brand, security patch или свойства GMS.</li>
  <li><b>VBMeta / boot hash spoofers:</b> Android VBMeta Fixer, VBMeta Disguiser и аналоги, если одновременно используются функции IntegrityBox Ultimate для Boot Hash / verifiedBootHash / VBMeta.</li>
  <li>Другие модули, которые меняют fingerprint, build props, GMS-состояние, DroidGuard, Keybox, attestation, security patch, VBMeta, boot hash или Play Integrity verdicts.</li>
</ul>

**Важно для пользователей классического Magisk Stable:**

Классический [**Magisk Stable**](https://github.com/topjohnwu/Magisk/releases/latest) не является рекомендуемым вариантом для IntegrityBox Ultimate, если цель — стабильная работа банковских приложений и строгих проверок окружения. Настоятельно рекомендуется перейти на [**Kitsune Magisk / Kitsune Ufork**](https://t.me/KitsuneUfork) или на [**KSU Next Spoofed**](https://github.com/KernelSU-Next/KernelSU-Next/releases/latest) *(в релизах выбирайте APK с `-spoofed_...-release.apk`)*, иначе стабильная работа банковских приложений не гарантируется.

**Дополнительные, но настоятельно рекомендуемые:**

5. [**Zygisk Next**](https://github.com/Dr-TSNG/ZygiskNext/releases/latest) или [**ReZygisk**](https://github.com/PerformanC/ReZygisk/releases/latest) *(нужны для функций на базе Zygisk, если вы не используете автономный Zygiskless Pixel Mode)*.
6. [**LSPosed / Vector**](https://github.com/JingMatrix/Vector/releases/latest) и [**HideMyApplist / HMA-OSS**](https://github.com/frknkrc44/HMA-OSS/releases/latest) *(рекомендуются, если банковские или государственные приложения реагируют на список приложений, root-следы или установленные модули)*. Альтернативная ветка HMA: [**Hide-My-Applist**](https://github.com/Dr-TSNG/Hide-My-Applist/releases/latest).

**Полезные инструменты из Integrity Downloader:** [PixelMask](https://github.com/kinginu/PixelMask/releases/latest), [KeyAttestation](https://github.com/vvb2060/KeyAttestation/releases/latest), [UpdateLocker](https://github.com/Xposed-Modules-Repo/ru.mike.updatelocker/releases/latest), [CorePatch](https://github.com/LSPosed/CorePatch/releases/latest), [Reverse Pixelify](https://github.com/uragiristereo/Reverse_Pixelify/releases/latest).

**Где искать файлы, скачанные через Integrity Downloader:**

Все APK/ZIP/JSON сохраняются в `/sdcard/IntegrityBox/Downloads`.

| Инструмент | Имя файла | Полный путь |
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

## Установка и полное руководство по настройке
Для чистой настройки и лучшего шанса вернуть сертификацию Play Store выполните эти шаги:

1. **Установите зависимости:** Убедитесь, что у вас установлен Root-менеджер и необходимые модули.
2. **Прошейте IntegrityBox Ultimate:** Установите zip-архив модуля и **перезагрузите** устройство.
3. **Запустите основное действие:** Перейдите в список модулей вашего Root-менеджера и нажмите **Action** на карточке IntegrityBox Ultimate. Дождитесь завершения: модуль скачает рабочий Keybox и подготовит свежие данные устройства.
4. **Проверьте статус:** Откройте WebUI, перейдите в **Toolkit** -> **Integrity Checker** и убедитесь, что активный Keybox имеет статус `ONLINE`, а данные устройства загружены.
5. **Почините TEE / Widevine при необходимости:** Поддерживаемые устройства могут использовать **Keybox Hub** -> **Fix Widevine L1** для восстановления Widevine/TEE через встроенный установщик Keybox. Используйте только на совместимых ROM/устройствах. После завершения подтвердите перезагрузку.
6. **Глубокая очистка GMS:** Перейдите в **Toolkit** -> **GMS Tools** и выполните **Deep GMS Wipe**. Это удалит старые состояния сертификации Google и данные Google Services Framework. Следуйте подсказке на экране, чтобы **перезагрузить** устройство. *(Вы выйдете из своего аккаунта Google.)*
7. **Повторный вход и проверка:** После перезагрузки откройте Play Маркет, снова войдите в свой аккаунт Google и проверьте статус сертификации Play Защиты.
8. **Включите AutoPilot:** Перейдите в **Auto Pilot** -> **AutoPilot Manager** и включите автоматическое фоновое обновление.

### Продвинутая настройка скрытности
Если банковские или государственные приложения слишком внимательно проверяют устройство, рекомендуем настроить HideMyApplist (HMA) через встроенные инструменты:

1. **Скачайте инструменты:** Откройте WebUI -> **Miscellaneous** -> **Module Settings**. Включите **Integrity Downloader** и нажмите **Apply Changes**. Скачанные APK/ZIP появятся в папке `/sdcard/IntegrityBox/Downloads`.
2. **Установите LSPosed:** Прошейте скачанный модуль LSPosed в вашем Root-менеджере и перезагрузите устройство.
3. **Установите HMA:** Откройте `/sdcard/IntegrityBox/Downloads/HideMyApplist.apk`, установите HideMyApplist, включите его в LSPosed, откройте один раз для создания рабочей папки, а затем принудительно закройте.
4. **Примените готовый профиль HMA:** Откройте WebUI -> **Hide My Stuff** -> **Inject HMA Template**. Это применит готовые правила скрытия для многих банковских и государственных приложений прямо в HMA.
5. **Установите PixelMask при необходимости:** PixelMask не является частью настройки HMA. Используйте его отдельно, если вам нужны Pixel/GMS-сценарии, которые он обслуживает.
6. **Подмена хэша загрузки при необходимости:** Если приложение прямо указывает на проблему с загрузчиком или boot hash, откройте WebUI, нажмите плитку **Boot Hash Spoofer** в разделе **Detection** и следуйте подсказкам на экране.

---

## Встроенная база знаний
Больше не нужно искать каждую мелочь в огромном README. **IntegrityBox Ultimate включает интерактивную Базу Знаний прямо внутри WebUI.**

* **Руководства по модулям:** Нажмите на иконку лампочки в верхней части любой страницы модуля, чтобы узнать, что делает конкретный инструмент.
* **Описание функций:** Нажимайте кнопки `( i )` рядом с отдельными разделами, чтобы получить понятное описание переключателей и цветных значков статуса.
* **AI Ассистент:** Офлайн AI-ассистент, встроенный в WebUI, готов ответить на распространенные вопросы и помочь в решении проблем.

---

## Быстрое решение проблем
* **Не проходит Play Integrity?** Убедитесь, что SELinux установлен в режим `Enforcing`, и проверьте, не заблокирован ли ваш Keybox.
* **"Устройство не сертифицировано" в Play Маркете?** Используйте **GMS Tools** -> **Deep GMS Wipe** и перезагрузитесь.
* **Google Wallet / GPay не работает?** Используйте **GMS Tools** -> **Wallet Reset**, чтобы очистить локальные данные Wallet.
* **Банковские приложения вылетают?** Используйте **Applist Detector** и **Hide Suspicious Files**, чтобы найти и скрыть видимые следы.
* **Не проходите строгие проверки загрузчика?** Используйте **Boot Hash Spoofer**.
* **Не проходите аппаратную аттестацию?** Используйте **Target Simulator** для нужного приложения. На поддерживаемых устройствах также попробуйте **Fix Widevine L1** и перезагрузитесь.
* **Нужен быстрый доступ в WebUI?** Зажмите часто используемую плитку на 300 мс и закрепите ее в **Quick Access**.

---

## Благодарности
Этот проект использует концепции и код из следующих open-source проектов:
- @ez-me за ezme-nodebug.
- @osm0sis за PlayIntegrityFork.
- **Команде LSPosed** за скрипт отложенного запуска сервиса Shamiko.
- **MeowDump** за оригинальную основу Integrity-Box.
- **Вам**, за использование этого модуля.
