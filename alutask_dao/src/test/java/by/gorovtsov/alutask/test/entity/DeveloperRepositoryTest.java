package by.gorovtsov.alutask.test.entity;


import by.gorovtsov.alutask.repository.DeveloperRepository;
import by.gorovtsov.alutask.test.config.TestDatabaseConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDatabaseConfig.class)
@Transactional
public class DeveloperRepositoryTest {

    @Autowired
    DeveloperRepository repository;

    @Test
    public void findAllDevelopersTest() {
        repository.findAll().forEach(System.out::println);
    }
}
