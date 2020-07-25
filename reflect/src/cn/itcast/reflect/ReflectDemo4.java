package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author kpwang
 * @create 2020-07-25 16:43
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //1.获取Person的Class对象
        Class<Person> personClass = Person.class;
        //2获取方法
        Method eat_method = personClass.getMethod("eat");
        Person person=new Person();
        eat_method.invoke(person);


        Method eat_method2 = personClass.getMethod("eat", String.class);
        eat_method2.invoke(person,"苹果");

        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName());
        }

        String className = personClass.getName();
        System.out.println(className);
    }
}
