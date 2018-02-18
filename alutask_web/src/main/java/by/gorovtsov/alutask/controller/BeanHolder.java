package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.config.PersistenceConfig;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.service.DeveloperService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class BeanHolder {
    private static ApplicationContext applicationContext;

    static {
        applicationContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
    }

    public static DeveloperService getDeveloperServiceBean() {
        return applicationContext.getBean(DeveloperService.class);
    }

    public static void main(String[] args) {
        List<Developer> developers = getDeveloperServiceBean().findAll();
        developers.forEach(System.out::println);
    }
}
