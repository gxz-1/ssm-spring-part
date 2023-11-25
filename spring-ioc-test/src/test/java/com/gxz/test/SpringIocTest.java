package com.gxz.test;

import com.gxz.components.A;
import com.gxz.components.B;
import com.gxz.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//使用spring测试注解，代替new ClassPathXmlApplicationContext/AnnotationConfigApplicationContext
@SpringJUnitConfig(value = JavaConfig.class)//二选一：location指定配置文件/value指定配置类
public class SpringIocTest {
    //使用spring注解的方式后，可以通过Autowired自动装配代替getBean()方法
    @Autowired
    private A a;
    @Autowired
    private B b;
    @Test
    public void test(){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}
