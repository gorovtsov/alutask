package by.gorovtsov.alutask.service.config;

import by.gorovtsov.alutask.config.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"by.gorovtsov.alutask.service"})
@Import(PersistenceConfig.class)
public class ServiceConfig {
}
