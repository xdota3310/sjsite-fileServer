package com.lr.fileserver.aop;

import com.lr.common.base.ResultResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 负责日志记录
 *
 * @author shijie.xu
 * @since 2019年08月02日
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
    ServletRequestAttributes sa;
    HttpServletRequest request;
    /**
     * 任意参数、任何名字的方法都打日志
     */
    @Pointcut("execution(public * com.lr.fileserver.web.controller..*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        sa = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        request = sa == null ? null : sa.getRequest();
        if(request != null){
            LOGGER.warn("Request:"+"[URI:"+request.getRequestURI()+"，IP:"+request.getRemoteAddr()+"]");
        }else {
            LOGGER.error("request信息为空！");
        }
    }


    @AfterReturning(returning = "res",pointcut = "log()")
    public void doAfter(Object res){
    }
}
