# Spring Cloud Config — реализация задания

Модули:

| Модуль | Порт | Описание |
|--------|------|----------|
| `config-repo` | — | Git-репозиторий с YAML-конфигурацией |
| `config-server` | 8888 | Spring Cloud Config Server |
| `config-client` | 8080 | Клиентское приложение с REST API |

## Порядок запуска

### 1. Инициализация config-repo

После клонирования основного репозитория выполните:

```bash
./spring-cloud-config/init-config-repo.sh
```

### 2. Запуск Config Server

```bash
cd spring-cloud-config/config-server
mvn spring-boot:run
```

### 3. Проверка Config Server (браузер или curl)

| URL | Описание |
|-----|----------|
| http://localhost:8888/config-client/default | Базовая конфигурация |
| http://localhost:8888/config-client/dev | Профиль dev |
| http://localhost:8888/config-client/prod | Профиль prod |

### 4. Запуск Config Client

```bash
cd spring-cloud-config/config-client

# Профиль dev
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Профиль prod
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

### 5. Проверка клиента

```bash
curl http://localhost:8080/api/config/message
```

Ожидаемый ответ (dev):

```json
{
  "message": "Конфигурация получена с Config Server (DEV)",
  "environment": "development",
  "activeProfiles": ["dev"]
}
```

## Проверка

```bash
# Быстрая проверка Config Server (должен быть запущен)
./verify.sh
```

Результаты последней проверки (24.05.2026): **11/11 PASS** — см. [`Docs/spring-cloud-config-verification.md`](../Docs/spring-cloud-config-verification.md).

## Стек

- Java 21
- Spring Boot 3.4.5
- Spring Cloud 2024.0.1
