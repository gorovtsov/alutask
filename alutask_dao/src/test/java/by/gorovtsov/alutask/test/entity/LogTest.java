package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.repository.TestRepository;
import by.gorovtsov.alutask.repository.UserRepository;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class LogTest extends BaseTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void logTest() {
        Logger logger = Logger.getRootLogger();
        logger.warn("ALALALALALA");
    }

    @Test
    public void aspectTest() {
        new TestRepository().testMethod();
    }
}
