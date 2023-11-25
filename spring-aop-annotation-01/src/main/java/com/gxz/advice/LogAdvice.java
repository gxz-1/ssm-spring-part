package com.gxz.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component//0.加入ioc容器
@Aspect//1.配置切面
public class LogAdvice {
    //2.使用注解配置指定插入目标方法的位置
    // 前置@Before\后置@AfterReturning\异常@AfterThrowing\最后@After\环绕@Around
    @Before("execution(* com.gxz.service.impl.*.*(..))")
    public void startCal(){
        System.out.println("计算开始了");
    }
    @AfterReturning("execution(* com.gxz.service.impl.*.*(..))")
    public void afterCal(){
        System.out.println("计算结束了");
    }
    @AfterThrowing("execution(* com.gxz.service.impl.*.*(..))")
    public void errorCal(){
        System.out.println("计算错误了");
    }
    //3. 在配置类或配置文件中:开启aspecj的注解
}
