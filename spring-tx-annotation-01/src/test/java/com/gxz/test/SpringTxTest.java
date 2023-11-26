package com.gxz.test;

import com.gxz.config.IocConfiguration;
import com.gxz.ioc.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(IocConfiguration.class)
public class SpringTxTest {
    @Autowired
    private StudentService studentService;
    @Test
    public void test1(){
//        studentService.changeInfo();
        try {
            studentService.writeFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
