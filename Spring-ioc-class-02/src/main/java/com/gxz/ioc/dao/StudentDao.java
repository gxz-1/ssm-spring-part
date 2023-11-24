package com.gxz.ioc.dao;

import com.gxz.ioc.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> queryAll();
}
