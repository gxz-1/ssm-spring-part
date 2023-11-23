package com.gxz.ioc_01;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component //等价于<bean id="commonComponent"  class="CommonComponent"/>
public class CommonComponent {

    //周期方法要求：0.public 1.void 2.无形参
    @PostConstruct
    public void init(){
        System.out.println("CommonComponent初始化了。。。");
    }
    @PreDestroy
    public void end(){
        System.out.println("CommonComponent销毁了。。。");
    }

}
