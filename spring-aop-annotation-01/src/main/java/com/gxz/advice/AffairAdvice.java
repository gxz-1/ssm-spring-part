package com.gxz.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//使用环绕@Around进行事务添加
@Component
@Aspect
//@Order(66)//设置切面的优先级,值越小优先级越高,默认为Integer.MAX_VALUE
public class AffairAdvice {
    //环绕通知需要定义返回值和参数ProceedingJoinPoint
    //返回值:即目标方法的返回值  ProceedingJoinPoint:用来获取目标方法信息并执行
    @Around("com.gxz.pointcut.MyPointCut.myPc()")//0.设置注解
    public Object affairNotify(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();//1.获取方法参数
        Object result;
        try {
            System.out.println("开启事务");
            result = joinPoint.proceed(args);//2. 执行方法
            System.out.println("正常结束事务");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            throw new RuntimeException(e);
        }finally {
            System.out.println("事务结束无论是否正常");
        }
        return result;//3.返回目标方法值
    }
}
