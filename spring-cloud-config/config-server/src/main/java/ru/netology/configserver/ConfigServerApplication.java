package ru.netology.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Точка входа Spring Cloud Config Server.
 * <p>
 * Сервер предоставляет HTTP API для получения конфигурации клиентскими
 * приложениями из подключённого git-репозитория {@code config-repo}.
 * </p>
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    /**
     * Запускает приложение Config Server.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
