package com.nhnghia.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {

    @AfterReturning("execution(* com.nhnghia.controller.BookController.rentBook(*,*))")
    public void afterRentBook(JoinPoint joinPoint) {
        System.err.println("After finish the method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.nhnghia.controller.BookController.returnBackBook(*,*))")
    public void afterReturnBackBook(JoinPoint joinPoint) {
        System.err.println("After finish the method: " + joinPoint.getSignature().getName());
    }
}
