package com.gxz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

//用这个类代替annotation方式中的xml文件，其他不变
@Configuration
@ComponentScan("com.gxz.ioc")
@PropertySource("classpath:jdbc.properties")
public class StudentConfiguration {
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
}
