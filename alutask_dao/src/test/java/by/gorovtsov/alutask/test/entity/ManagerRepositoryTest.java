package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.entity.user.Manager;
import by.gorovtsov.alutask.repository.ManagerRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class ManagerRepositoryTest extends BaseTest {

    @Autowired
    ManagerRepository managerRepository;

    @Test
    public void findByLoginTest() {
        Manager aluman = managerRepository.findByLogin("aluman");

        assertNotNull(aluman);
    }
}
