package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.config.PersistenceConfig;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.entity.user.QDeveloper;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import by.gorovtsov.alutask.service.DeveloperService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.querydsl.core.types.Predicate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ContextConfiguration(classes = PersistenceConfig.class)
public class TestClass {
    @Autowired
    DeveloperService developerService;

    public static void main(String[] args) {
        QDeveloper developer = QDeveloper.developer;

        List<Developer> developers = new TestClass().developerService.findAll(1, 5, ProgrammingLanguage.JAVA, DeveloperLevel.ALEXANDERGOROVTSOV);
        developers.forEach(System.out::println);
    }
}
