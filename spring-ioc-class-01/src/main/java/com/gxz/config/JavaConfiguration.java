package com.gxz.config;


//用java配置类代替xml配置

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration //0.添加配置类标签
@ComponentScan(value = "com.gxz.ioc_01") //1.指定扫描的包
//@ComponentScan({"com.gxz.ioc_01","com.gxz.ioc_01"}) value关键字可省略且可以添加多个包
@PropertySource(value = "classpath:jdbc.properties") //2.引用外部配置类
public class JavaConfiguration {

    //4.引入基本数据类型
    @Value("${gxz.url}")
    private String url;
    @Value("${gxz.driver:com.mysql.cj.jdbc.Driver}")//冒号：后面为默认值
    private String driver;
    @Value("${gxz.username}")
    private String username;
    @Value("${gxz.password}")
    private String password;

    @Bean//5.引入第三方的java类
    public DruidDataSource dataSource(){
        //id值对应方法名 class值对应返回值类型 set标签的配置对应方法的具体实现
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    //@bean注解细节
    @Bean(name = "jdbcTemplate",initMethod = "",destroyMethod = "")
    //name或value指定id名（默认为方法名），initMethod、destroyMethod指定周期方法
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)//指定单例或多例
    public JdbcTemplate jdbcfunction(DataSource dataSource){
        JdbcTemplate template = new JdbcTemplate();
        //如何实现依赖注入？
        //方案一：直接调用@Bean方法（不推荐）
//        template.setDataSource(dataSource());
        //方案二：由形参的类型指定（等价于@AutoWired方式），同样不能有多个或0个
        //当有多个时可以匹配时，由形参的名称指定
        template.setDataSource(dataSource);
        return template;
    }

    //@Import用于将其他配置类引入当前配置类，从而将多个配置类整合到一起便于AnnotationConfigApplicationContext导入
    //然而，原本是允许传入多个配置类的:new AnnotationConfigApplicationContext(A.class,B.class)
//    @Configuration
//    @Import(ConfigA.class)
//    public class ConfigB {}
}
