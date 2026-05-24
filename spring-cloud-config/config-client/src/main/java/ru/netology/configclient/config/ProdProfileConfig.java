package ru.netology.configclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Конфигурация для профиля {@code prod}.
 * <p>
 * Класс помечен {@link Profile} для демонстрации разделения настроек
 * по окружениям. Сами значения свойств загружаются из config-client-prod.yml.
 * </p>
 */
@Configuration
@Profile("prod")
public class ProdProfileConfig {
}
