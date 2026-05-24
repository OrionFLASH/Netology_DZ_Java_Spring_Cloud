package ru.netology.configclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Конфигурация для профиля {@code dev}.
 * <p>
 * Класс помечен {@link Profile} для демонстрации разделения настроек
 * по окружениям. Сами значения свойств загружаются из config-client-dev.yml.
 * </p>
 */
@Configuration
@Profile("dev")
public class DevProfileConfig {
}
