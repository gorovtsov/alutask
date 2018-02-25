package by.gorovtsov.alutask.service.test;

import by.gorovtsov.alutask.config.ServiceConfig;
import by.gorovtsov.alutask.service.DeveloperService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DeveloperServiceTest extends BaseServiceTest {

    @Autowired
    DeveloperService service;

    @Test
    public void findAllDevelopersTest() {
        service.findAll().forEach(System.out::println);
    }

}
