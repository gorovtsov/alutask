package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.service.config.ServiceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanHolderService {
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new AnnotationConfigApplicationContext(ServiceConfig.class);
    }

    public static DeveloperService getDeveloperService() {
        return applicationContext.getBean(DeveloperService.class);
    }
}
