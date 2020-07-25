package cn.itcast.annotation;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author kpwang
 * @create 2020-07-25 16:43
 */
@Pro(className = "cn.itcast.annotation.Demo1",methodName = "show1")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
       //1.解析注解
        //获取该类的字节码文件
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2.获取上边的注解对象
        Pro an = reflectTestClass.getAnnotation(Pro.class);//其实就是在内存中去生产了一个该注解接口的子类实现对象
        //3调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);

        //3加载该类进内存
        Class<?> cls = Class.forName(className);
        //4创建对象
        Object obj = cls.newInstance();
        //5获取方法
        Method method = cls.getMethod(methodName);
        //6执行方法
        method.invoke(obj);
    }
}
