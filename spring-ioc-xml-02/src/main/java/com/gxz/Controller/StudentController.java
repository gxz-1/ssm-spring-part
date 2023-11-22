package com.gxz.Controller;

import com.gxz.pojo.Student;
import com.gxz.service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll(){
        List<Student> studentList = studentService.findAll();
        System.out.println("控制层Controller拿到了最终数据");
    }
}
