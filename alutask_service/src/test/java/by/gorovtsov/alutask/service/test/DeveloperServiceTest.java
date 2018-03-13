package by.gorovtsov.alutask.service.test;

import by.gorovtsov.alutask.config.ServiceConfig;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.service.DeveloperService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class DeveloperServiceTest extends BaseServiceTest {

    @Autowired
    DeveloperService service;

    @Test
    public void findAllDevelopersTest() {
        service.findAll().forEach(System.out::println);
    }

    @Test
    public void findPagedAndFilteredDevelopersTest() {
        List<Developer> developers = service.findPageByLanguageAndLevel(ProgrammingLanguage.JAVA, DeveloperLevel.ALEXANDERGOROVTSOV, 0, 5);
    }

    @Test
    public void getPageNumsTest() {
        List<Long> pageNums = service.getPageNums(ProgrammingLanguage.JAVA, DeveloperLevel.ALEXANDERGOROVTSOV, 5);
    }

}
