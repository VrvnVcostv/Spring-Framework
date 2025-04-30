package com.udemy.seventhsection.aop.SeventhSection.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class GreetingFooAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.udemy.seventhsection.aop.SeventhSection.services.GreetingService.*(..))")
    private void greetingFooLoggerPointCut(){};
    
    @Before("greetingFooLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String metod = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before First: " + metod + " with the parameters " + args);
    }

    @After("greetingFooLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String metod = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before First: " + metod + " with the parameters " + args);
    }
}
