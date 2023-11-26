package com.gxz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("com.gxz")
@PropertySource("classpath:jdbc.properties")
//@EnableAspectJAutoProxy//开启aspectj注解支持
@EnableTransactionManagement//0.1开启事务注解的支持
public class IocConfiguration {
    @Value("${gxz.url}")
    private String url;
    @Value("${gxz.driver:com.mysql.cj.jdbc.Driver}")
    private String driver;
    @Value("${gxz.username}")
    private String username;
    @Value("${gxz.password}")
    private String password;

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return  dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource dataSource){
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }

    //0.2将对应的事务管理器加入ioc容器
    @Bean
    public TransactionManager transactionManager(DruidDataSource dataSource){
        //DataSourceTransactionManager事务管理器整合了：JDBC方式、JdbcTemplate方式、Mybatis方式的事务实现
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);//需要连接池对象
        return manager;
    }

}
