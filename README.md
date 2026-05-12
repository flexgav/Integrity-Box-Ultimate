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

<p align="center">
  <img src="https://img.shields.io/badge/Recommended-Kitsune%20Magisk%20%2F%20KSU%20Next%20Spoofed-blue" alt="Recommended">
  <img src="https://img.shields.io/badge/Warning-Remove%20conflicting%20modules-orange" alt="Warning">
  <img src="https://img.shields.io/badge/Critical-Do%20not%20mix%20attestation%20backends-red" alt="Critical">
</p>

## 📌 Обзор
**IntegrityBox Ultimate** — это удобный набор инструментов для Android с root-доступом: он помогает вернуть сертификацию Play Store, управлять Keybox, очищать следы Google-сервисов, настраивать скрытие приложений и проверять состояние устройства через понятный интерфейс в стиле Material You.

### ✨ Основные возможности
* 📌 **Quick Access:** Зажмите любую плитку WebUI, чтобы закрепить ее наверху главного экрана. Список хранится в `/data/adb/Box-Brain/quick_access.cfg`.
* 🛡️ **Автоматизация Security Patch:** Модуль берет дату из активных данных PIF, записывает файл Security Patch для TrickyStore в нужном формате и поддерживает эти значения после загрузки устройства.
* 🧹 **Anti-Detection Nuke:** Режимы Soft, Standard и Aggressive очищают обычные следы проверок, остатки приложений и более глубокие системные следы, если вы выбираете такой режим. Там, где нужна перезагрузка, модуль сразу предупреждает об этом.
* 🔐 **Починка TEE / Widevine:** **Fix Widevine L1** может восстановить встроенный Keybox на поддерживаемых устройствах, где есть системная утилита `KmInstallKeybox`.
* 📦 **Integrity Downloader:** Скачивает полезные приложения и модули: ZygiskNext, TrickyStore, HMA, PixelMask, KeyAttestation и другие инструменты.

---

## ✅ Требования
Для комфортной работы убедитесь, что на устройстве есть:

**🧩 Основные требования:** ![Required](https://img.shields.io/badge/required-core-blue)

1. Поддерживаемый Root-менеджер: [**KernelSU Next**](https://github.com/KernelSU-Next/KernelSU-Next/releases/latest), [**APatch**](https://github.com/bmax121/APatch/releases/latest) или [**Kitsune Magisk / Kitsune Ufork**](https://t.me/KitsuneUfork).
2. Backend для аппаратной аттестации: [**Tricky Store**](https://github.com/5ec1cff/TrickyStore/releases/latest) или [**TEE Simulator**](https://github.com/JingMatrix/TEESimulator/releases/latest) *(нужны для приложений, которые проверяют аппаратные ключи устройства)*. Используйте только один backend: Tricky Store, TrickyStoreOSS, TEE Simulator и их форки не должны работать одновременно.
3. Приложение для открытия WebUI: [**MMRL**](https://github.com/MMRLApp/MMRL/releases/latest), [**WebUI X Portable**](https://github.com/MMRLApp/WebUI-X-Portable/releases/latest) или встроенная поддержка WebUI в Root-менеджере. [**KsuWebUIStandalone**](https://github.com/5ec1cff/KsuWebUIStandalone/releases/latest) можно использовать только как старый fallback-вариант, так как репозиторий архивирован.

> [!IMPORTANT]
> Перед установкой удалите другие модули и решения для починки Integrity / Play Integrity сертификации, чтобы они не конфликтовали с IntegrityBox Ultimate.

**⚠️ Конфликтующие модули, которые нужно удалить или отключить:** ![Critical](https://img.shields.io/badge/critical-remove-red)

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

**🚨 Важно для пользователей классического Magisk Stable:** ![Warning](https://img.shields.io/badge/warning-magisk%20stable-orange)

> [!WARNING]
> Классический [**Magisk Stable**](https://github.com/topjohnwu/Magisk/releases/latest) не является рекомендуемым вариантом для IntegrityBox Ultimate, если цель — стабильная работа банковских приложений и строгих проверок окружения. Настоятельно рекомендуется перейти на [**Kitsune Magisk / Kitsune Ufork**](https://t.me/KitsuneUfork) или на [**KSU Next Spoofed**](https://github.com/KernelSU-Next/KernelSU-Next/releases/latest) *(в релизах выбирайте APK с `-spoofed_...-release.apk`)*, иначе стабильная работа банковских приложений не гарантируется.

**➕ Дополнительные, но настоятельно рекомендуемые:** ![Recommended](https://img.shields.io/badge/recommended-stealth-green)

1. [**Zygisk Next**](https://github.com/Dr-TSNG/ZygiskNext/releases/latest) или [**ReZygisk**](https://github.com/PerformanC/ReZygisk/releases/latest) *(нужны для функций на базе Zygisk, если вы не используете автономный Zygiskless Pixel Mode)*.
2. [**LSPosed / Vector**](https://github.com/JingMatrix/Vector/releases/latest) и [**HideMyApplist / HMA-OSS**](https://github.com/frknkrc44/HMA-OSS/releases/latest) *(рекомендуются, если банковские или государственные приложения реагируют на список приложений, root-следы или установленные модули)*. Альтернативная ветка HMA: [**Hide-My-Applist**](https://github.com/Dr-TSNG/Hide-My-Applist/releases/latest).

**📦 Полезные инструменты из Integrity Downloader:** ![Tools](https://img.shields.io/badge/tools-downloader-blueviolet) [PixelMask](https://github.com/kinginu/PixelMask/releases/latest), [KeyAttestation](https://github.com/vvb2060/KeyAttestation/releases/latest), [UpdateLocker](https://github.com/Xposed-Modules-Repo/ru.mike.updatelocker/releases/latest), [CorePatch](https://github.com/LSPosed/CorePatch/releases/latest), [Reverse Pixelify](https://github.com/uragiristereo/Reverse_Pixelify/releases/latest).

**📁 Где искать файлы, скачанные через Integrity Downloader:** ![Path](https://img.shields.io/badge/path-storage-lightgrey)

> [!NOTE]
> Все APK/ZIP/JSON, скачанные через Integrity Downloader, сохраняются в `/sdcard/IntegrityBox/Downloads`.

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

## 🚀 Установка и полное руководство по настройке
Для чистой настройки и лучшего шанса вернуть сертификацию Play Store выполните эти шаги:

> [!TIP]
> Если вы настраиваете модуль впервые, проходите шаги по порядку и не включайте дополнительные инструменты до первичной проверки сертификации Play Маркета.

1. ✅ **Установите зависимости:** Убедитесь, что у вас установлен Root-менеджер и необходимые модули.
2. 📲 **Прошейте IntegrityBox Ultimate:** Установите zip-архив модуля и **перезагрузите** устройство.
3. ▶️ **Запустите основное действие:** Перейдите в список модулей вашего Root-менеджера и нажмите **Action** на карточке IntegrityBox Ultimate. Дождитесь завершения: модуль скачает рабочий Keybox и подготовит свежие данные устройства.
4. 🔎 **Проверьте статус:** Откройте WebUI, перейдите в **Toolkit** -> **Integrity Checker** и убедитесь, что активный Keybox имеет статус `ONLINE`, а данные устройства загружены.
5. 🔐 **Почините TEE / Widevine при необходимости:** Поддерживаемые устройства могут использовать **Keybox Hub** -> **Fix Widevine L1** для восстановления Widevine/TEE через встроенный установщик Keybox. Используйте только на совместимых ROM/устройствах. После завершения подтвердите перезагрузку.
6. 🧼 **Глубокая очистка GMS:** Перейдите в **Toolkit** -> **GMS Tools** и выполните **Deep GMS Wipe**. Это удалит старые состояния сертификации Google и данные Google Services Framework. Следуйте подсказке на экране, чтобы **перезагрузить** устройство. *(Вы выйдете из своего аккаунта Google.)*
7. ✅ **Повторный вход и проверка:** После перезагрузки откройте Play Маркет, снова войдите в свой аккаунт Google и проверьте статус сертификации Play Защиты.
8. 🤖 **Включите AutoPilot:** Перейдите в **Auto Pilot** -> **AutoPilot Manager** и включите автоматическое фоновое обновление.

### 🕶️ Продвинутая настройка скрытности
Если банковские или государственные приложения слишком внимательно проверяют устройство, рекомендуем настроить HideMyApplist (HMA) через встроенные инструменты:

> [!IMPORTANT]
> Обычно HMA не нужно открывать вручную перед применением профиля: IntegrityBox Ultimate пытается сам создать нужные data-директории и записать конфигурацию. Если автоматическое применение не сработало, откройте HMA один раз, закройте его и повторите **Inject HMA Template**.

1. 📥 **Скачайте инструменты:** Откройте WebUI -> **Miscellaneous** -> **Module Settings**. Включите **Integrity Downloader** и нажмите **Apply Changes**. Скачанные APK/ZIP появятся в папке `/sdcard/IntegrityBox/Downloads`.
2. 🧩 **Установите LSPosed:** Прошейте скачанный модуль LSPosed в вашем Root-менеджере и перезагрузите устройство.
3. 🕵️ **Установите HMA:** Откройте `/sdcard/IntegrityBox/Downloads/HideMyApplist.apk`, установите HideMyApplist и включите его в LSPosed.
4. 🛡️ **Примените готовый профиль HMA:** Откройте WebUI -> **Hide My Stuff** -> **Inject HMA Template**. Это применит готовые правила скрытия для многих банковских и государственных приложений прямо в HMA.
5. 📱 **Установите PixelMask при необходимости:** PixelMask не является частью настройки HMA. Используйте его отдельно, если вам нужны Pixel/GMS-сценарии, которые он обслуживает.
6. 🧬 **Подмена хэша загрузки при необходимости:** Если приложение прямо указывает на проблему с загрузчиком или boot hash, откройте WebUI, нажмите плитку **Boot Hash Spoofer** в разделе **Detection** и следуйте подсказкам на экране.

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
2. Откройте WebUI -> **Keybox Hub** -> **Target Simulator**.
3. Найдите нужное приложение по названию или package name.
4. Для первой попытки выберите профиль **Default** и режим **AUTO**, затем нажмите **Save**.
5. Принудительно остановите проблемное приложение или перезагрузите устройство, затем проверьте приложение снова.
6. Если **AUTO** не помог, попробуйте **LEAF** для этого же приложения. **GENERATE** используйте только как последний вариант, если понятно, что приложению не подходит обычная цепочка аттестации.

### 🔓 Приложение ругается на загрузчик, VBMeta или boot hash
1. Откройте WebUI -> **Detection** -> **Boot Hash Spoofer**.
2. Сначала нажмите **Get Real Boot Hash**. Модуль попытается извлечь реальный `androidboot.vbmeta.digest` устройства из `/proc/cmdline`, device-tree или bootconfig и автоматически подставит его в поле.
3. Если реальный hash найден, нажмите **Apply**, затем **Reboot** и проверьте приложение снова.
4. Если появилось **Extraction Failed** и реальный hash извлечь не удалось, используйте иконку **Magic Wand** для генерации 64-символьного hash, нажмите **Apply**, затем **Reboot**.
5. Если нужно откатить изменение, вернитесь в **Boot Hash Spoofer**, нажмите **Reset** и перезагрузите устройство.

### 📌 Нужен быстрый доступ к часто используемым инструментам
Зажмите нужную плитку WebUI примерно на 300 мс, чтобы закрепить ее в **Quick Access** на главной странице.

### 🆘 Ничего не помогло
Если после всех шагов не удалось добиться сертификации Google или стабильной работы нужных приложений, перейдите в Telegram-группу по ссылкам в шапке README и напишите в тему помощи и поддержки. Опишите модель устройства, прошивку, Root-менеджер, используемый backend аттестации, результат Play Integrity из Play Маркета и что уже пробовали сделать.

---

## 🙏 Благодарности
Этот проект использует концепции и код из следующих open-source проектов:
- @ez-me за ezme-nodebug.
- @osm0sis за PlayIntegrityFork.
- **Команде LSPosed** за скрипт отложенного запуска сервиса Shamiko.
- **MeowDump** за оригинальную основу Integrity-Box.
- **Вам**, за использование этого модуля.
