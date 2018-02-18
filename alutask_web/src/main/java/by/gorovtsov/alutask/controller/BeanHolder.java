package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.config.PersistenceConfig;
import by.gorovtsov.alutask.service.DeveloperService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanHolder {
    private static ApplicationContext applicationContext;

    static {
        applicationContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
    }

    public static DeveloperService getDeveloperServiceBean() {
        return applicationContext.getBean(DeveloperService.class);
    }
}
