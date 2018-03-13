package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.config.WebConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@Transactional
public class BaseControllerTest {
}
