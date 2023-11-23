package com.gxz.ioc_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller(value = "newController") //默认注解名为类名首字母小写：xxxController，可通过value指定
public class XxxController {

    @Autowired //直接对属性进行依赖注入（DI）：相当于对xxxService的set方法设置<property name="xxxService" ref="xxxService"/>
    private XxxService xxxService;

    public void show(){
        System.out.println(xxxService.show());//调用业务层的show方法，测试是否完成了装配
    }
//    @Autowired //也可以添加到构造函数或者set方法上（不推荐）
//    public XxxController(XxxService xxxService) {
//        this.xxxService = xxxService;
//    }
//    @Autowired(required = false) //required = false佛系装配，找不到xxxService也不报错（不推荐）
//    public void setXxxService(XxxService xxxService) {
//        this.xxxService = xxxService;
//    }

    //当@Autowired有多个可以匹配的bean组件时也会报错（例如@Autowired指定接口，而实现类有多个）
    //解决方法：  1.根据成员变量名称区别 2.配合@Qualifier(value = "userServiceImpl") 要求名称为类名首字母小写
}
