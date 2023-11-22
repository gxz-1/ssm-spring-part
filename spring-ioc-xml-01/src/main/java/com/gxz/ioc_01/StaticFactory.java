package com.gxz.ioc_01;

//工厂模式的功能是将对象的创建与使用分离，提供统一的接口来创建不同类型的对象
//静态工厂：这里用单例模式模拟工厂创建静态对象的过程
public class StaticFactory {
    private static StaticFactory sf=new StaticFactory();

    public StaticFactory() {
    }

    public static StaticFactory createInstance() {
        //在这里编写工厂方法的实例化逻辑
        return sf;//返回实例化对象供ioc容器管理
    }
}
