package com.gxz.dao;

import com.gxz.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private JdbcTemplate jdbcTemplate;
    //提供给ioc容器注入JdbcTemplate
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryAll() {
        String sql="select id , name , age , gender , class as classes from students;";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("连接层从数据库中拿到了数据");
        return studentList;
    }
}
