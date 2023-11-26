package com.gxz.ioc.service.impl;

import com.gxz.ioc.dao.StudentDao;
import com.gxz.ioc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//0. 0.1需要在ioc配置类中开启事务注解的支持 并 0.2添加数据库相应的事务管理器到ioc容器
// (事务注解是对Aop的再次封装，用aop机制来做事务管理：前置增强中开启事务、返回增强中提交事务、异常增强中回滚事务)
//1.添加事务@Transactional：加到类上表示类下的所有方法都有、加到方法上表示该方法有事务(注意：方法上的注解会覆盖类上的注解)
@Transactional(isolation = Isolation.READ_COMMITTED)//2.isolation设置隔离级别
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Transactional(timeout = 2)//3.设置超时时间，超时即回滚操作和释放异常TransactionTimedOutException
    public void changeInfo(){
        studentDao.updateNameById("test2",1);//4.可以在子方法中设置的事务传播行为
        //事务传播要求子方法必须在不同的类中：因为事务机制的底层实现是代理模式，在同一个类中的方法调用不经过代理
        System.out.println("-----------");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        studentDao.updateAgeById(10,1);
    }

    @Transactional(readOnly = true)//4.单独设置查询方法为只读模式，能提高读取效率
    public void getStudentInfo(){
    }

    @Transactional(rollbackFor = Exception.class)
    //5.Throwable有Error和Exception两个子类，而Exception有RuntimeException和IOException两种
    //事务默认只针对运行时异常回滚，rollbackFor指定事务回滚针对的异常,noRollbackFor排除事务回滚针对的异常
    public void writeFile() throws FileNotFoundException {
        studentDao.updateNameById("test4",1);
        new FileInputStream("???");
    }
}
