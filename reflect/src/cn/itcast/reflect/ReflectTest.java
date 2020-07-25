package cn.itcast.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author kpwang
 * @create 2020-07-25 16:43
 */
public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //可以创建任意类的对象，可以执行任意方法
        //1.加载配置文件
        Properties pro=new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");

        pro.load(is);
        //2获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
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
