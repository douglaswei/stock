package com.douglas.stock.proxyservice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Author:  wgz
 * Date:    16/3/3
 * Time:    下午8:33
 * Desc:    need annotation EnableAspectJAutoProxy for spring-boot application
 */
@Aspect
@Configuration
public class AopConfig {

    private final static Logger LOG = LoggerFactory.getLogger(AopConfig.class);

    @Pointcut("@annotation(com.douglas.stock.proxyservice.aop.TimeInfo)")
    public void timeInfo(){
    }

    @Around("timeInfo()")
    public void around(ProceedingJoinPoint joinPoint) {
        DateTime begin = new DateTime();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            LOG.warn("exception :", throwable);
        } finally {
            DateTime end = new DateTime();
            LOG.info("process [{}], begin [{}], end [{}], span [{}]",
                    joinPoint.getSignature().getName(),
                    begin.toString("yyyy-MM-dd HH:mm:ss"),
                    end.toString("yyyy-MM-dd HH:mm:ss"),
                    new Interval(begin, end).toPeriod());
        }
    }

}
