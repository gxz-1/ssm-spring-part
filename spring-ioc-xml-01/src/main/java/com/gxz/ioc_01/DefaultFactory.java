package com.gxz.ioc_01;

//工厂模式的功能是将对象的创建与使用分离，提供统一的接口来创建不同类型的对象
//非静态工厂：这里用单例模式模拟非静态工厂创建对象的过程
public class DefaultFactory {
    private static DefaultFactory df=new DefaultFactory();
    public DefaultFactory createInstance(){
        return  df;
    }
}
