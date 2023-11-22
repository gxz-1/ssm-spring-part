package com.gxz.service;

import com.gxz.dao.StudentDao;
import com.gxz.pojo.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao;
    //提供给ioc容器注入StudentDao
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("服务层拿到业务层的数据并输出：");
        for (Student s:studentList){
            System.out.println(s);
        }
        return studentList;
    }
}
