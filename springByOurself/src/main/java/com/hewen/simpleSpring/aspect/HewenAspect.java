package com.hewen.simpleSpring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * ClassName HewenAspect
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/31 15:54
 */
@Aspect
@Component
public class HewenAspect {
    @Before("execution(* com.hewen.simpleSpring.service..*.*(..))")
    public void hewenBefore(JoinPoint joinPoint){
        System.out.println("废物");
    }
}
