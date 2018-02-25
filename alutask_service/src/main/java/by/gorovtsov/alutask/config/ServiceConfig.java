package by.gorovtsov.alutask.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "by.gorovtsov.alutask.service")
@Import(PersistenceConfig.class)
public class ServiceConfig {

}
