package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.config.PersistenceConfig;
import by.gorovtsov.alutask.service.DeveloperService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanHolderService {
    /*private static ApplicationContext applicationContext;
    static {
        applicationContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
    }

    public static DeveloperService getDeveloperService() {
        return applicationContext.getBean(DeveloperService.class);
    }*/
}
