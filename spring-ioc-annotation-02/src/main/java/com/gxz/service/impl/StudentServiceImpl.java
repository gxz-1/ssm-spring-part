package com.gxz.service.impl;

import com.gxz.dao.StudentDao;
import com.gxz.pojo.Student;
import com.gxz.service.StudentService;
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
