package com.gxz.test;

import com.gxz.config.JavaConfiguration;
import com.gxz.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void test1(){
        //测试配置类的方式代替xml文件
        //1.通过AnnotationConfigApplicationContext创建ioc容器
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfiguration.class);
        //2.获取bean
        StudentController controller = applicationContext.getBean(StudentController.class);
        System.out.println("controller:"+controller);
    }
}
