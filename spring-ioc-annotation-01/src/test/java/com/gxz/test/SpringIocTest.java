package com.gxz.test;

import com.gxz.ioc_01.CommonComponent;
import com.gxz.ioc_01.XxxController;
import com.gxz.ioc_01.XxxDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    void test1(){
        //测试注解的配置方式
        ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("spring01.xml");
        CommonComponent cc = cpac.getBean(CommonComponent.class);
        XxxController cr = cpac.getBean("newController", XxxController.class);//测试通过value起别名
        System.out.println("CommonComponent: "+cc);
        System.out.println("Controller: "+cr);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring01.xml");
        //测试scope配置单例和多例
        XxxDao bean = applicationContext.getBean(XxxDao.class);
        XxxDao bean1 = applicationContext.getBean(XxxDao.class);
        System.out.println(bean == bean1);

        applicationContext.close();
    }

    @Test
    public void test3(){
        //测试引用类型自动装配@Autowired
        ClassPathXmlApplicationContext cpac
                = new ClassPathXmlApplicationContext("spring01.xml");
        XxxController controller = cpac.getBean(XxxController.class);
        controller.show();

        cpac.close();
    }

    @Test
    public void test4(){
        //测试基本数据类型自动装配@Autowired
        ClassPathXmlApplicationContext cpac
                = new ClassPathXmlApplicationContext("spring01.xml");
        XxxDao dao = cpac.getBean(XxxDao.class);
        System.out.println(dao.toString());
        cpac.close();
    }

}
