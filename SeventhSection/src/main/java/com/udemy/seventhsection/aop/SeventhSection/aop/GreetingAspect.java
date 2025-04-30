package com.udemy.seventhsection.aop.SeventhSection.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.udemy.seventhsection.aop.SeventhSection.services.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String metod = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before: " + metod + " with the args " + args);
    }

    @After("execution(* com.udemy.seventhsection.aop.SeventhSection.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String metod = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After: " + metod + " with the args " + args);
    }

    @AfterReturning("execution(* com.udemy.seventhsection.aop.SeventhSection.services.GreetingService.*(..))") // It executes before the @After decorator
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String metod = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After return: " + metod + " with the args " + args);
    }

    @AfterThrowing("execution(* com.udemy.seventhsection.aop.SeventhSection.services.GreetingService.*(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String metod = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After throwing a exception: " + metod + " with the args " + args);
    }

    @Around("execution(* com.udemy.seventhsection.aop.SeventhSection.services.GreetingService.*(..))")
    public Object loggerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().getName();
        String args = Arrays.toString(proceedingJoinPoint.getArgs());
        try {
            logger.info("The method " + method + " " + "() with the args " + args);
            Object result = proceedingJoinPoint.proceed();
            logger.info("The method " + method + "() returns the result " + result);
            return result;
        } catch (Throwable e) {logger.error("Error on the method " + method + "()"); throw e;}
    }
}
