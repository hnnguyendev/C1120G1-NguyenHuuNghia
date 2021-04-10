package com.nhnghia.aop;

import com.nhnghia.entity.Counter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class Logger {

    @Autowired
    Counter counter;

    @AfterReturning("execution(* com.nhnghia.controller.BookController.getBookList(..))")
    public void afterVisit(JoinPoint joinPoint) {
        System.err.println("After finish the method: " + joinPoint.getSignature().getName() + " - " + counter.getCount() + " visits");
    }

    @AfterReturning("execution(* com.nhnghia.controller.BookController.rentBook(..))")
    public void afterRentBook(JoinPoint joinPoint) {
        System.err.println("After finish the method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.nhnghia.controller.BookController.returnBackBook(..))")
    public void afterReturnBackBook(JoinPoint joinPoint) {
        System.err.println("After finish the method: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.nhnghia.controller.BookController.rentBook(..))")
    public void afterThrowingOutOfStock(JoinPoint joinPoint) {
        System.err.println("After finish the method: " + joinPoint.getSignature().getName() + " - out of stock");
    }

    @AfterThrowing("execution(* com.nhnghia.controller.BookController.returnBackBook(..))")
    public void afterIncorrectCode(JoinPoint joinPoint) {
        System.err.println("After finish the method: " + joinPoint.getSignature().getName() + " - incorrect code");
    }
}
