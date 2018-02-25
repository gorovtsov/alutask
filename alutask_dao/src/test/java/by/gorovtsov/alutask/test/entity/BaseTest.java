package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.config.PersistenceConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = PersistenceConfig.class)
public class BaseTest {
}
