package com.gxz.ioc.dao.impl;

import com.gxz.ioc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Transactional(propagation = Propagation.REQUIRED)//4. 设置事务传播行为
    // REQUIRED：默认值，如果父方法有事务，就加入，如果没有就新建自己独立（推荐）
    // REQUIRES_NEW:不管父方法是否有事务，我都新建事务，都是独立的
    public void updateNameById(String name,Integer id){
        String sql = "update students set name = ? where id = ? ;";
        int rows = jdbcTemplate.update(sql, name, id);
    }

    public void updateAgeById(Integer age,Integer id){
        String sql = "update students set age = ? where id = ? ;";
        jdbcTemplate.update(sql,age,id);
    }


}
