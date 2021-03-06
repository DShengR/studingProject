package com.dsr.testspring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 切面类
 */
/*@Aspect
@Component
@Order(1)*/
public class LogUtil {
    @Pointcut("execution(public * com.dsr.testspring.dao.impl.PersonDaoImpl.*(..))")
    public void myPointCut(){ }
    @Before("myPointCut()")
    public static void start(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String name= signature.getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("log--前置通知--"+name+"--start---"+Arrays.asList(args));
    }

    @AfterReturning(value = "myPointCut()",returning = "result")
    public static void stop(JoinPoint joinPoint,Object result) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("log--后置返回通知--"+name+"--return---"+Arrays.asList(args)+"---return:"+result);
    }

    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public static void exception(Exception e){
        System.out.println("log--异常通知--"+"--exception---"+e);
    }

    @After("myPointCut()")
    public static void finall(){
        System.out.println("log--后置通知--"+"--finall---");
    }
    @Around("myPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("log--环绕前置通知--"+name+"----start-"+Arrays.asList(args));
        Object result=null;
        try {
            result= joinPoint.proceed(args);
            System.out.println("log--环绕后置返回通知--"+name+"---result-"+result);
        } catch (Throwable throwable) {
            System.out.println("log--环绕后置异常通知--"+name+"---exception-"+throwable.getMessage());
            //throwable.printStackTrace();
            throw throwable;
        }finally {
            System.out.println("log--环绕后置通知--"+"---finally-"+Arrays.asList(args));
        }
        return result;
    }
}
