package com.gxz.ioc.service.impl;

import com.gxz.ioc.dao.StudentDao;
import com.gxz.ioc.pojo.Student;
import com.gxz.ioc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        List<Student> all = studentDao.queryAll();
        return all;
    }
}
