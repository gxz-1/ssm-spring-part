package com.gxz.test;

import com.gxz.Controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("spring01.xml");
        StudentController controller = cpac.getBean(StudentController.class);
        controller.findAll();
        cpac.close();
    }
}
