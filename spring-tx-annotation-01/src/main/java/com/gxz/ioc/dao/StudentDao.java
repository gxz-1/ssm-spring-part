package com.gxz.ioc.dao;


public interface StudentDao {
    void updateNameById(String name,Integer id);
    void updateAgeById(Integer age,Integer id);
}
