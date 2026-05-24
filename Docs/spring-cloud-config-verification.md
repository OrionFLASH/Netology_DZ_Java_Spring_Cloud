# Отчёт о проверке — Spring Cloud Config

**Дата:** 24.05.2026  
**Окружение:** Java 25, Maven 3.9.11, macOS

## Результаты интеграционных тестов

| № | Проверка | Результат |
|---|----------|-----------|
| 1 | Config Server `GET /config-client/default` | PASS |
| 2 | Config Server `GET /config-client/dev` | PASS |
| 3 | Config Server `GET /config-client/prod` | PASS |
| 4 | Config Client без профиля — `/api/config/message` | PASS |
| 5 | Config Client профиль `dev` — `/api/config/message` | PASS |
| 6 | Config Client профиль `prod` — `/api/config/message` | PASS |
| 7 | Config Server `/actuator/health` → UP | PASS |
| 8 | Config Client `/actuator/health` → UP | PASS |
| 9 | Config Client `/actuator/env` содержит configserver | PASS |
| 10 | `mvn test` config-server | PASS |
| 11 | `mvn test` config-client | PASS |

## Соответствие заданию

| Требование | Реализация | Статус |
|------------|------------|--------|
| Spring Boot + `spring-cloud-config-server` | `config-server/pom.xml`, `@EnableConfigServer` | ✅ |
| Репозиторий конфигурации | `config-repo/` (локальный git) | ✅ |
| Конфигурация приложения в репозитории | `config-client.yml`, `-dev.yml`, `-prod.yml` | ✅ |
| Подключение сервера к репозиторию | `application.yml` → `spring.cloud.config.server.git.uri` | ✅ |
| HTTP-проверка конфигурации на сервере | `http://localhost:8888/config-client/{profile}` | ✅ |
| Client + `spring-cloud-starter-config` + `spring-boot-starter-web` | `config-client/pom.xml` | ✅ |
| Подключение клиента к Config Server | `spring.config.import: configserver:http://localhost:8888` | ✅ |
| Контроллер с параметром конфигурации | `ConfigController.getConfigMessage()` → `app.message` | ✅ |
| **Доп.** Профили dev / prod | `@Profile("dev")`, `@Profile("prod")`, YAML в config-repo | ✅ |

## Примеры фактических ответов

**Config Server (dev):**
```json
{
  "name": "config-client",
  "profiles": ["dev"],
  "propertySources": [{
    "source": {
      "app.message": "Конфигурация получена с Config Server (DEV)",
      "app.environment": "development"
    }
  }]
}
```

**Config Client (prod):**
```json
{
  "message": "Конфигурация получена с Config Server (PROD)",
  "environment": "production",
  "activeProfiles": ["prod"]
}
```

## Повторный запуск проверки

```bash
# Config Server должен быть запущен
./spring-cloud-config/verify.sh
```
