package by.gorovtsov.alutask.test.config;

import by.gorovtsov.alutask.config.PersistenceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistenceConfig.class)
public class TestDatabaseConfig {
}
