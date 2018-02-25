package by.gorovtsov.alutask.service.test;

import by.gorovtsov.alutask.config.PersistenceConfig;
import by.gorovtsov.alutask.config.ServiceConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public abstract class BaseServiceTest {
}
