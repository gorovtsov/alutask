package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import by.gorovtsov.alutask.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeveloperRepositoryTest extends BaseTest {

    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void findDeveloperByLogin() {
        Developer developer = developerRepository.findByLogin("garavek");
        System.out.println(developer.getName());
    }

    @Test
    public void findAllDeveloperTest() {
        List<Developer> developers = developerRepository.findAll();
        developers.forEach(System.out::println);
    }

    @Test
    public void saveUserAsDeveloper() {

        Developer developer = developerRepository.findOne(220L);
        System.out.println(developer.getName());


        developerRepository.findOne(220L);
    }
}
