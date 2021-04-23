package com.nhnghia.concern;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {

    @AfterThrowing(pointcut = "execution(public * com.nhnghia.service.ICustomerService.findAll(..))")
    public void log() {
    }
    public void error() {
        System.out.println("[CMS] ERROR!");
    }
}
