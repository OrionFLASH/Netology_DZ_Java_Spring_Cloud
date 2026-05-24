# Netology — Spring Cloud Config

Учебный проект по курсу Java Spring Cloud. Реализовано задание по настройке **Spring Cloud Config Server** и клиентского приложения для получения внешней конфигурации из git-репозитория.

## Структура проекта

```
Netology_DZ_Java_Spring_Cloud/
├── Docs/                              # Исходные материалы задания
│   ├── spring-cloud-config-assignment.md
│   └── spring-cloud-config-reference.md
├── spring-cloud-config/               # Реализация задания
│   ├── config-repo/                   # Git-репозиторий с YAML-конфигурацией
│   ├── config-server/                 # Spring Cloud Config Server (порт 8888)
│   ├── config-client/                 # Клиентское приложение (порт 8080)
│   ├── init-config-repo.sh            # Скрипт инициализации config-repo
│   └── README.md                      # Документация по модулю
└── README.md
```

## Требования

- Java 17+ (рекомендуется 21)
- Maven 3.9+
- Git

## Установка и запуск

### 1. Клонирование и подготовка config-repo

```bash
git clone https://github.com/OrionFLASH/Netology_DZ_Java_Spring_Cloud.git
cd Netology_DZ_Java_Spring_Cloud
./spring-cloud-config/init-config-repo.sh
```

Скрипт создаёт локальный git-репозиторий в `config-repo`, необходимый для работы Config Server.

### 2. Запуск Config Server

```bash
cd spring-cloud-config/config-server
mvn spring-boot:run
```

Сервер стартует на порту **8888** и читает конфигурацию из `config-repo`.

### 3. Проверка Config Server

Откройте в браузере или выполните curl:

| URL | Ожидаемое поведение |
|-----|---------------------|
| http://localhost:8888/config-client/default | JSON с `app.message` для профиля по умолчанию |
| http://localhost:8888/config-client/dev | JSON с DEV-конфигурацией |
| http://localhost:8888/config-client/prod | JSON с PROD-конфигурацией |

### 4. Запуск Config Client

В **отдельном терминале** (Config Server должен быть запущен):

```bash
cd spring-cloud-config/config-client

# Профиль dev
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Профиль prod
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

### 5. Проверка клиентского приложения

| URL | Описание |
|-----|----------|
| http://localhost:8080/api/config/message | Параметр `app.message` с Config Server |
| http://localhost:8080/actuator/env | Свойства окружения (в т.ч. с Config Server) |

## Сценарии тестирования

### Базовое задание

1. Запустить Config Server — убедиться, что порт 8888 отвечает.
2. Запросить `http://localhost:8888/config-client/default` — в ответе есть `app.message` и `app.environment`.
3. Запустить Config Client без профиля — эндпоинт `/api/config/message` возвращает конфигурацию по умолчанию.
4. Убедиться, что значение `message` совпадает с данными из config-repo.

### Дополнительное задание (профили dev / prod)

1. Запустить клиент с `-Dspring-boot.run.profiles=dev`.
2. Проверить `/api/config/message` — `message` содержит «DEV», `activeProfiles`: `["dev"]`.
3. Перезапустить клиент с профилем `prod`.
4. Проверить `/api/config/message` — `message` содержит «PROD», `activeProfiles`: `["prod"]`.

## Технологии

- Java 21
- Spring Boot 3.4.5
- Spring Cloud Config 2024.0.1
- Maven

## История версий

| Версия | Описание |
|--------|----------|
| 1.0.0  | Spring Cloud Config Server, config-repo, config-client с профилями dev/prod |
