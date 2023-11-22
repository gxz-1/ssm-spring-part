package com.gxz.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.gxz.Controller.StudentController;
import com.gxz.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//学习JdbcTemplate的使用(在spring01.xml中用注解的方法添加这个到ioc容器中管理)
public class JdbcTemplateTest {

    //JdbcTemplate仅仅用来操作数据库，不提供连接池
    //DruidDataSource 负责连接的创建和数据库驱动的注册等
    public DruidDataSource createDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/studb");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("admin");
        dataSource.setPassword("password");
//        System.out.println(dataSource.getClass().getName());
        return dataSource;
    }

    public void jdbcTest1(){
        //0.创建jdbc对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //1.获取数据库连接
        DruidDataSource dataSource = createDataSource();
        jdbcTemplate.setDataSource(dataSource);
        //进行增删改查
//        jdbcTemplate.update();//更新
//        jdbcTemplate.queryForObject();//查询单个对象
//        jdbcTemplate.query();//查询集合
    }
    //通过ioc容器读取sql数据库
    @Test
    public void jdbcTest2(){
        //获取连接
        ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("spring01.xml");
        JdbcTemplate jdbcTemplate = cpac.getBean("jdbcTemplate", JdbcTemplate.class);
        //插入数据
        String sql="insert into students (id,name,gender,age,class) values (?,?,?,?,?)";
        int rows=jdbcTemplate.update(sql,10,"张三","女",19,"依灵儿班");
        System.out.println("rows="+rows);
        //查询单个
        sql="select * from students where id=?;";
        Student stu = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setClasses(rs.getString("class"));
                return student;
            }
        }, 1);
        //查询集合
        //BeanPropertyRowMapper就是封装好RowMapper的实现,要求属性名和列名相同即可
        sql="select id , name , age , gender , class as classes from students;";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("studentList = " + studentList);
    }

    //测试完整三层架构
    @Test
    public void testAll(){
        ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("spring02.xml");
        StudentController controller = cpac.getBean(StudentController.class);
        controller.findAll();
        cpac.close();
    }
}
