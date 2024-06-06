package com.jobpost.jobpost.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitorAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution (* com.jobpost.jobpost.service.impl.JobpostServiceImpl .findByPostProfile(..))")

    public Object logMethodExecuteTime(ProceedingJoinPoint jp) throws Throwable {

        Long start = System.currentTimeMillis();

        Object object = jp.proceed();

        Long end = System.currentTimeMillis();

        LOGGER.info("Time taken to execute method:"+jp.getSignature().getName()+ " : "+ (end - start)+"ms");

        return object;
    }
}
