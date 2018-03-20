package by.gorovtsov.alutask.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DaoLoggerAspect {

    private Logger logger = Logger.getRootLogger();

    @Pointcut("@within(by.gorovtsov.alutask.annotation.Loggable)")
    public void testPointcut() {}

    @Before("testPointcut()")
    public void testAspect() {
        System.out.println("Aspect Works for repository");
    }

    /*@Around("repositoryDebug()")
    public Object dataAccessDebug(ProceedingJoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        logger.info("ASPECT WORKS! User " + userName + " called method " + methodName);

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.info(methodName + " method execution failed by user " + userName);
            throwable.printStackTrace();
        }

        logger.info("Success!!! ASPECT WORKS!");
        System.out.println("ASPECT WORKS!");

        return result;
    }*/
}
