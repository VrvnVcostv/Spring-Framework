package com.udemy.seventhsection.aop.SeventhSection.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(* com.udemy.seventhsection.aop.SeventhSection.services.GreetingService.*(..))")
    public void greetingLoggerPointCut(){};

    @Pointcut("execution(* com.udemy.seventhsection.aop.SeventhSection.services.GreetingService.*(..))")
    public void greetingFooLoggerPointCut(){};
}
