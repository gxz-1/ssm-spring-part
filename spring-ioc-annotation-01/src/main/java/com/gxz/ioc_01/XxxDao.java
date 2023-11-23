package com.gxz.ioc_01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)//单例默认值
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)//多例默认值
@Repository
public class XxxDao {

    //基本数据类型进行依赖注入
    String name="李四";//1.直接赋值即可

    @Value("37")//2.使用value注解（不推荐，通常用于读取外部配置信息）
    int age;

    @Value("${jdbc.link}") //读取外部配置信息jdbc.peoperties
    String link;
    @Value("${jdbc.id:1234}")//冒号：后面为默认值
    int id;

    @Override
    public String toString() {
        return "XxxDao{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", link='" + link + '\'' +
                ", id=" + id +
                '}';
    }
}
