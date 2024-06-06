package com.jobpost.jobpost.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    public static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution (* com.jobpost.jobpost.service.impl.JobpostServiceImpl .findByPostProfile(..))")
        public void logMethodcall(JoinPoint jp){
        LOGGER.info("method get called:"+jp.getSignature().getName());

    }

    @After("execution (* com.jobpost.jobpost.service.impl.JobpostServiceImpl .findByPostProfile(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("method execution finished:"+jp.getSignature().getName());

    }

}
