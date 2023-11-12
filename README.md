# Демопроект по автоматизации тестовых сценариев для сайта проекта [СБЕР-ЗДОРОВЬЕ](https://sberhealth.ru/)

## :star: Содержание:
- [Технологии и инструменты](#технологии-и-инструменты)
- [Реализованные проверки](#реализованные-проверки)
- [Запуск из терминала](#запуск-из-терминала)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Интеграция с Allure TestOps](#пример-allure-отчета)
- [Интеграция с Jira](#интеграция-с-jira)
- [Уведомление в Telegram о результатах прогона тестов](#уведомление-в-telegram-о-результатах-прогона-тестов)
- [Видео пример запуска тестов в Selenoid](#видео-пример-запуска-тестов-в-selenoid)

## Технологии и инструменты
___

<p align="center">
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" alt="Java"></a>
<a href="https://www.jetbrains.com/ru-ru/idea/"><img src="media/logo/Intellij Idea.svg" width="50" alt="IntelliJ IDEA"></a>
<a href="https://junit.org/junit5/docs/current/user-guide/"><img src="media/logo/JUnit.svg" width="50" alt="JUnit 5"></a>
<a href="https://selenide.org/"><img src="media/logo/Selenide.svg" width="50" alt="Selenide"></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" alt="Gradle"></a>
<a href="https://allurereport.org/"><img src="media/logo/Allure_Report.svg" width="50" alt="Allure Report"></a>
<a href="https://aerokube.com/selenoid/latest/"><img src="media/logo/Selenoid.svg" width="50" alt="Selenoid"></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" alt="Jenkins"></a>
<a href="https://web.telegram.org/"><img src="media/logo/Telegram.svg" width="50" alt="Telegram"></a>
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" alt="GitHub"></a>
<a href="https://qameta.io/"><img src="media/logo/AllureTestOps.svg" width="50" alt="Allure TestOps"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img src="media/logo/Jira.svg" width="50" alt="Jira"></a>
</p>

- Тесты написаны на языке `Java`
- Под капотом `Selenide` и `JUnit 5`
- Проект собирается в `Gradle`
- Удаленно тесты запускаются в `Jenkins`
- `Seleniod` играет роль удаленного браузера
- Результаты `Allure-отчета` приходят в `Telegram`
- Есть интеграция с `Jira` и `Allure TestOps`


## Реализованные проверки
___
:heavy_check_mark:Наличие номера телефона контакт-центра 

:heavy_check_mark:На главной странице присутствует реклама приложения

:heavy_check_mark:Переход на страницу авторизации в личный кабинет

:heavy_check_mark:Ошибка валидации при попытке входа с несуществующим номером

:heavy_check_mark:Ошибка валидации при попытке входа с неполным номером

:heavy_check_mark:Параметризированный тест на проверку заголовка контента при сортировке по метро

:heavy_check_mark:Работа чекбокса "Детские врачи"

## Запуск из терминала
___
***Локальный запуск***:
```bash
gradle clean test
```
Тесты запустятся удаленно в `Selenoid`.

***Удаленный запуск через Jenkins***:
```bash
clean
${TAG}
-Dbrowser=${BROWSER}
-Dversion=${VERSION}
-DwindowSize=${WINDOW_SIZE}
-Dremote=https://user1:1234@selenoid.autotests.cloud/wd/hub
```

При необходимости можно переопределить параметры сборки:
- `TAG` - тесты с определенным тэгом (по умолчанию - `prod`)
- `BROWSER` – браузер, в котором выполняются тесты (по умолчанию - `chrome`).
- `WINDOW_SIZE` – размер окна во время выполнения тестов (по умолчанию - `1920x1080`)
- `VERSION` – версия браузера, в которой выполняются тесты (по умолчанию - `100.0`).


## Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C22-alyonachern-17-project/)
___
<p align="center">
<img src="media/screenshots/Jenkins.png" alt="Страница в Jenkins" width="900">
</p>

Для запуска сборки необходимо перейти в раздел `Build with Parameters` и нажать кнопку `Build`.

После выполнения сборки, в блоке `Build History` напротив номера сборки появятся значки `Allure Report` и `Allure TestOps`. По нажатию открывается сформированный Allure-отчет и тестовая документация соответственно.


## Пример [Allure-отчета](https://jenkins.autotests.cloud/job/C22-alyonachern-17-project/13/allure/)
___
<p align="center">
<img src="media/screenshots/Allure-Overview.png" alt="Основной экран Allure Reports" width="900">
<img src="media/screenshots/Allure-Suites.png" alt="Экран с тест-кейсами" width="900">
</p>

## Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3772/dashboards)
___
На `Dashboard` видна статистика количества тестов: сколько ручных, сколько автоматизированных. Новые тесты и результаты прогона приходят по интеграции при каждом запуске сборки.

<p align="center">
<img src="media/screenshots/Allire-TestOps-Dashbord.png" alt="Дашборд прогона кейсов" width="900">
<img src="media/screenshots/Allure-TestOps-Auto.png" alt="Автоматизированные кейсы" width="900">
<img src="media/screenshots/Allure-TestOps-Manual.png" alt="Ручные кейсы" width="900">
</p>

## Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-946)
___
В тикете отображается информация о тест-кейсах в рамках задачи и результатах прогона.
<p align="center">
<img src="media/screenshots/Jira-Integration.png" alt="Интеграция с Jira" width="900">
</p>

## Уведомление в Telegram о результатах прогона тестов
___
После завершения сборки специальный бот автоматически присылает сообщение с отчетом о прогоне тестов.
<p align="center">
<img src="media/screenshots/Telegram.png" alt="Сообщение от телеграм-бота" width="550">
</p>

## Видео пример запуска тестов в Selenoid
___
К каждому тесту в отчете прилагается не только скриншоты, но и видео прогона.
<p align="center">
<img src="media/screenshots/Selenoid.gif" alt="Видео прогона теста в Selenoid" width="550">
</p>