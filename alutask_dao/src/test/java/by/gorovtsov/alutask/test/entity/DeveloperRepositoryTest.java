package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeveloperRepositoryTest extends BaseTest {

    @Autowired
    DeveloperRepository repository;

    @Test
    public void findDeveloperByLogin() {
        Developer developer = repository.findByLogin("garavek");
        System.out.println(developer.getName());
    }

    @Test
    public void findAllDeveloperTest() {
        List<Developer> developers = repository.findAll();
        developers.forEach(System.out::println);
    }
}
