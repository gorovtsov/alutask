package by.gorovtsov.alutask.config;

import by.gorovtsov.alutask.aspect.DaoLoggerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "by.gorovtsov.alutask")
public class AspectConfig {

    @Bean
    public DaoLoggerAspect daoLoggerAspect() {
        return new DaoLoggerAspect();
    }
}
