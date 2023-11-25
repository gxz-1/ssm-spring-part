package com.gxz.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan({"com.gxz.service","com.gxz.advice","com.gxz.pointcut"})
@Configuration
@EnableAspectJAutoProxy//开启AspectJ代理的注解
public class JavaConfig {
}
