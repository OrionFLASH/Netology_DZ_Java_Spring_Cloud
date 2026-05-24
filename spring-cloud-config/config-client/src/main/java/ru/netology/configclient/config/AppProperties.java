package ru.netology.configclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Свойства приложения, загружаемые с Config Server.
 * <p>
 * Префикс {@code app} соответствует ключам в YAML-файлах config-repo.
 * </p>
 *
 * @param message     текстовое сообщение для REST-эндпоинта
 * @param environment название текущего окружения (default, development, production)
 */
@ConfigurationProperties(prefix = "app")
public record AppProperties(
        String message,
        String environment
) {
}
