package com.gxz.ioc_02;

public class UserService {
    //1.单个参数的构造函数
    private UserDao ud;
    public UserService(UserDao ud){
        this.ud=ud;
    }
    //2.多个参数的构造函数
    private  int age;
    private String name;

    public UserService(UserDao ud, int age, String name) {
        this.ud = ud;
        this.age = age;
        this.name = name;
    }
    //3.set方法
    public UserService(){}//必须要有无参构造
    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
