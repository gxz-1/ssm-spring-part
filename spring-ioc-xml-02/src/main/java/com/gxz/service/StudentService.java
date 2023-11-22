package com.gxz.service;

import com.gxz.pojo.Student;

import java.util.List;

public interface StudentService {
    //查询所有学生的业务
    List<Student> findAll();
}
