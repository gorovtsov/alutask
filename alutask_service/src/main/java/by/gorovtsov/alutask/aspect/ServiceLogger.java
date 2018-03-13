package by.gorovtsov.alutask.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ServiceLogger {

    @After("execution(public void by.gorovtsov.alutask.service.*.*(..))")
    public void logServiceMethod() {

    }
}
