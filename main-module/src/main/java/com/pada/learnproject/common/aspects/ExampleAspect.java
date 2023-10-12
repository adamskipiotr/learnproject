package com.pada.learnproject.common.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {

    @Before("execution(* com.pada.learnproject.example.service.ExampleService.getExamples(..))")
    public void logBeforeServiceMethod() {
        System.out.println("Example aspect call - service");
    }

    @After("getExamplesControllerMethod()")
    public void logAfterControllerMethod(){
        System.out.println("Example aspect call - controller");
    }

    @Pointcut("execution(* com.pada.learnproject.example.web.ExamplesController.getExamples(..))")
    public void getExamplesControllerMethod(){}
}
