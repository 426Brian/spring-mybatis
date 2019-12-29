package com.springAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Brian in 23:57 2018/11/3
 */
@Order(1)
@Aspect
@Component
public class ValidateAspect {

    @Before("execution(public int com.springAOP.service.impl.ComputerImpl2.*(..))")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate "+ Arrays.asList(joinPoint.getArgs()));
    }
}
