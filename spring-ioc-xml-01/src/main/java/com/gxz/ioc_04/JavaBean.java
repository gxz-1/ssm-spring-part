package com.gxz.ioc_04;

public class JavaBean {

    //声明周期方法
    //要求：0.public 1.void 2.无参数
    public void init(){
        System.out.println("组件初始化了！");
    }

    public void clear(){
        System.out.println("组件销毁了！");
    }
}
