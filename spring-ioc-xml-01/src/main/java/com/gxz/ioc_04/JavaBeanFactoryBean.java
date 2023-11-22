package com.gxz.ioc_04;

import org.springframework.beans.factory.FactoryBean;

//FactoryBean:由ioc容器提供的构建工厂类的模板
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

    //模板提供的工厂方法：用于实例化对象
    @Override
    public JavaBean getObject() throws Exception {
        JavaBean javaBean = new JavaBean();
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }

}
