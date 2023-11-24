package com.gxz.test;

import com.gxz.config.StudentConfiguration;
import com.gxz.ioc.Controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIocTest {
    @Test
    public void test(){//测试配置类的方式完成三层架构
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfiguration.class);
        StudentController controller = context.getBean(StudentController.class);
        controller.findAll();
        context.close();
    }

}
