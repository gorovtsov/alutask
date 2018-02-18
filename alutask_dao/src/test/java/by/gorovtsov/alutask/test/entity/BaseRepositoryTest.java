package by.gorovtsov.alutask.test.entity;


import by.gorovtsov.alutask.config.PersistenceConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
@Transactional
public class BaseRepositoryTest {
}
