# Репозиторий конфигурации Spring Cloud Config

Git-репозиторий с YAML-файлами конфигурации для клиентского приложения `config-client`.

## Файлы

| Файл | Назначение |
|------|------------|
| `config-client.yml` | Базовая конфигурация |
| `config-client-dev.yml` | Профиль `dev` |
| `config-client-prod.yml` | Профиль `prod` |

## Ключевые параметры

- `app.message` — сообщение, возвращаемое контроллером клиента
- `app.environment` — название окружения

Config Server читает эти файлы по шаблону `{application}-{profile}.yml`,
где `application` = `spring.application.name` клиента.
