package spring.test;

import com.gxz.config.JavaConfig;
import com.gxz.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {
    @Autowired
    private Calculator calculator;
    //1.当实现类实现了接口时，不能用实现类接值,只能使用父接口,
    //因为Aop底层默认使用jdk动态代理生成:采用代理对象和目标对象实现同一个接口的方式
    //2.当实现类没有实现接口时,使用cglib动态代理生成:采用代理对象是目标对象子类的方式
    @Test
    public void test(){
        int add= calculator.add(3,4);
        System.out.println("add = " + add);
        int div=calculator.div(9,0);
        System.out.println("div = " + div);
    }
}
