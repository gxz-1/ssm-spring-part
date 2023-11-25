package com.gxz.pointcut;


import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * TODO: 切点表达式的提取和复用
 *    1. 当前类中提取(不推荐)
 *       定义一个空方法
 *       注解 @Pointcut()
 *       增强注解中引用切点表达式的方法即可  直接调用方法
 *    2. 创建一个存储切点的类
 *       单独维护切点表达式
 *       其他类的切点方法 类的全限定符号.方法名()
 */

@Component //需要添加到ioc容器!!!
public class MyPointCut {
    @Pointcut("execution(* com.gxz.service.impl.*.*(..))")
    public void pc(){}

    @Pointcut("execution(* com..impl.*.*(..))")
    public void myPc(){}
}
/**
 * TODO: 切点表达式
 *    固定语法 execution(1 2 3.4.5(6))
 *    1. 访问修饰符
 *       public  / private
 *    2. 方法的返回参数类型
 *       String int void
 *    如果不考虑访问修饰符和返回值! 这两位整合成一起写 *
 *    如果要是不考虑,必须两个都不考虑! 不能出现  * String
 *    3. 包的位置
 *       具体包: com.atguigu.service.impl
 *       单层模糊: com.atguigu.service.*   * 单层模糊
 *       多层模糊: com..impl    ..任意层的模糊
 *       细节: ..不能开头
 *       找所有impl包:  com..impl  不能写..impl 写成: *..impl
 *    4. 类的名称
 *       具体: CalculatorPureImpl
 *       模糊: *
 *       部分模糊: *Impl
 *    5. 方法名 语法和类名一致
 *    6. (6)形参数列表
 *       没有参数: ()
 *       有具体参数: (String)  (String,int)
 *       模糊参数: (..) 有没有参数都可以,有多个也可以!
 *       不分模糊: (String..) String 后面有没有无所谓
 *                 (..int)  最后一个参数是int
 *                 (String..int)
 *
 *   TODO: 实战
 *     1.查询某包某类下，访问修饰符是公有，返回值是int的全部方法
 *       public int xx.xx.jj.*(..)
 *     2.查询某包下类中第一个参数是String的方法
 *       * xx.xx.jj.*(String..)
 *     3.查询全部包下，无参数的方法！
 *        * *..*.*()
 *     4.查询com包下，以int参数类型结尾的方法
 *        * com..*.*(..int)
 *     5.查询指定包下，Service开头类的私有返回值int的无参数方法
 *        private int xx.xx.Service*.*()
 *
 */