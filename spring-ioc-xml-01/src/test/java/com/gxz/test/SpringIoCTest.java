package com.gxz.test;

import com.gxz.ioc_03.Happy;
import com.gxz.ioc_03.HappyImp;
import com.gxz.ioc_04.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
    //创建和读取ioc容器并读取配置文件
    @Test
    public void createIoC(){
        //
        /**
         * 创建容器 选择合适的容器实现即可!
         * 接口：BeanFactory
         *    ApplicationContext
         * 实现类
         *    可以直接通过构造函数实例化!
         *    ClassPathXmlApplicationContext  读取类路径下的xml配置方式  classes
         *    FileSystemXmlApplicationContext 读取指定文件位置的xml配置方式
         *    AnnotationConfigApplicationContext 读取配置类方式的ioc容器
         *    WebApplicationContext           web项目专属的配置的ioc容器
         */
        //方式1：(推荐)
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring01.xml","spring02.xml","spring03.xml");
        //方式2：先创建ioc容器对象,再指定配置文件,再刷新!（源码中的创建方式）
        ClassPathXmlApplicationContext applicationContext1=new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring03.xml");
        applicationContext1.refresh();

    }

    //从Ioc中获取组件
    @Test
    public void getBeanFromIoC(){
        //0.创建ioc容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring03.xml");
        //1.获取容器
        //1.1需要强转 (不推荐)
        Happy h1 =(Happy) applicationContext.getBean("happyPart");
        //1.2根据beanId，同时指定类型
        Happy h2=applicationContext.getBean("happyPart", Happy.class);
        //1.3根据类型直接获取(当xml中存在一个类的多个bean时有问题)
        Happy h3=applicationContext.getBean(Happy.class);
        //ioc的xml配置一定是实现类,但是可以根据接口类型获取值!
        //原因：在getBean方法中 用的是 “Happy instanceof  HappyImp” 判断为true
        HappyImp h4=applicationContext.getBean(HappyImp.class);

        //测试
        h1.doWork();h2.doWork();h3.doWork();
        h4.doWork();
    }

    //周期方法以及作用域的测试
    @Test
    void test4(){
        //ioc加载时自动调用init方法
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring04.xml");

        //测试prototype多例
        JavaBean bean1 = classPathXmlApplicationContext.getBean("javaBean2", JavaBean.class);
        JavaBean bean2 = classPathXmlApplicationContext.getBean("javaBean2",JavaBean.class);
        System.out.print("bean1==bean2:");
        System.out.println(bean1==bean2);

        //标准化工厂factoryBean类的创建测试
        JavaBean bean3=classPathXmlApplicationContext.getBean("javaBean3",JavaBean.class);
        //factoryBean工厂也会加入ioc容器，名字叫“&id”
        Object beanfactory = classPathXmlApplicationContext.getBean("&javaBean3");
        System.out.println("beanfactory的类型是："+beanfactory);

        //ioc容器正常结束时自动调用destory方法(如果立即释放程序来不及调用destory)
        classPathXmlApplicationContext.close();
    }





}
