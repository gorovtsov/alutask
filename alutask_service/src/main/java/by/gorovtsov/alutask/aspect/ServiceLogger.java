package by.gorovtsov.alutask.aspect;

import by.gorovtsov.alutask.entity.user.User;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ServiceLogger {


    private Logger logger = Logger.getRootLogger();

    @Pointcut("execution(public void by.gorovtsov.alutask.service.UserService.registerNewUser(..))")
    private void registrationService() {}

    @Around("registrationService()")
    public Object logServiceMethod(ProceedingJoinPoint joinPoint) {
        User argument = (User) joinPoint.getArgs()[0];
        System.out.println("User " + argument.getLogin() + " trying to register");
        Object result = null;

        System.out.println("Dao method called!!!");

        logger.debug("Service method called!!!");
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }
}
