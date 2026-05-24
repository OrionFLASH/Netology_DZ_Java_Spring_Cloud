package ru.netology.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.netology.configclient.config.AppProperties;

/**
 * Точка входа клиентского приложения Spring Cloud Config.
 * <p>
 * При старте приложение подключается к Config Server и загружает
 * внешнюю конфигурацию в соответствии с {@code spring.application.name}
 * и активными профилями.
 * </p>
 */
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ConfigClientApplication {

    /**
     * Запускает клиентское приложение.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
