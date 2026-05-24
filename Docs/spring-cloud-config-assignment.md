# Задание: Spring Cloud Config

## Описание

Необходимо настроить Spring Cloud Config Server для получения конфигурации из репозитория. Для этого необходимо создать отдельное приложение с зависимостью `spring-cloud-config-server`. Проверить возвращаемые конфигурации с помощью HTTP-запросов.

После этого создать Spring Boot приложение с `spring-boot-starter-web` и `spring-cloud-starter-config`. Добавить метод контроллера, который будет возвращать параметр конфигурации, полученный с сервера конфигурации.

## Дополнительное задание

Настроить получение конфигурации в соответствии с `@ActiveProfiles` для **dev** и **prod** окружения.

## Инструкция к выполнению

1. Создать Spring Boot приложение со стартером `spring-cloud-config-server`.
2. Создать репозиторий для хранения конфигурации.
3. Добавить в репозиторий конфигурацию Spring Boot приложения.
4. Подключить сервер конфигурации к репозиторию конфигурации.
5. Проверить получение конфигурации запросом из браузера на сервер конфигурации.
6. Создать Spring Boot приложение со стартерами `spring-cloud-starter-config` и `spring-boot-starter-web`.
7. Добавить в настройках созданного приложения подключение к серверу конфигурации.
8. Добавить контроллер с одним методом, который возвращает параметр, полученный с сервера конфигурации.

## Полезные ссылки

- [Spring Cloud Config — Reference Documentation](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/)
- [Spring Cloud Configuration — Baeldung](https://www.baeldung.com/spring-cloud-configuration)

## Исходные материалы

- `spring-cloud-config-reference.md` — фрагмент официальной документации Spring Cloud Config.
