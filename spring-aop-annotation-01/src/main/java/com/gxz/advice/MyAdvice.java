package com.gxz.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

//如何获取目标方法的签名信息,返回值,异常对象?
// 1.签名信息:形参中添加JoinPoint
// 2.返回值:在@AfterReturning下配置注解并添加形参Object result
// 3.异常对象:在@AfterThrowing下配置注解并添加形参Throwable throwable
@Aspect
@Component
public class MyAdvice {
    @Before("com.gxz.pointcut.MyPointCut.myPc()")
    public void startCal(JoinPoint joinPoint){
        //1.获取方法所属类信息
        String classname = joinPoint.getTarget().getClass().getSimpleName();
        //2.获取方法名
        String funcname = joinPoint.getSignature().getName();
        //3.获取返回值类型
        int modifiers = joinPoint.getSignature().getModifiers();
        String strmodifiers = Modifier.toString(modifiers);
        //4.获取参数列表
        Object[] args = joinPoint.getArgs();
    }
    @AfterReturning(value = "com.gxz.pointcut.MyPointCut.myPc()",returning = "result")
    public void afterCal(Object result){}
    @AfterThrowing(value = "com.gxz.pointcut.MyPointCut.myPc()",throwing = "throwable")
    public void errorCal(Throwable throwable){}
    @After("com.gxz.pointcut.MyPointCut.myPc()")
    public void endCal(){}

}


