package ru.netology.configclient.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.configclient.config.AppProperties;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * REST-контроллер для демонстрации конфигурации, полученной с Config Server.
 */
@RestController
@RequestMapping("/api/config")
public class ConfigController {

    private final AppProperties appProperties;
    private final Environment environment;

    /**
     * @param appProperties свойства приложения из config-repo
     * @param environment   окружение Spring для чтения активных профилей
     */
    public ConfigController(AppProperties appProperties, Environment environment) {
        this.appProperties = appProperties;
        this.environment = environment;
    }

    /**
     * Возвращает параметр {@code app.message}, загруженный с Config Server.
     *
     * @return JSON с сообщением, окружением и активными профилями
     */
    @GetMapping("/message")
    public Map<String, Object> getConfigMessage() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", appProperties.message());
        response.put("environment", appProperties.environment());
        response.put("activeProfiles", Arrays.asList(environment.getActiveProfiles()));
        return response;
    }
}
