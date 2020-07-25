package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author kpwang
 * @create 2020-07-25 16:43
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //1.获取Person的Class对象
        Class<Person> personClass = Person.class;
        //2获取构造方法
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Person person = constructor.newInstance("李沁", 28);
        System.out.println(person);
        System.out.println("-----------");
        Constructor<Person> constructor1 = personClass.getConstructor();
        Person person1 = constructor1.newInstance();
        System.out.println(person1);


        Person person2 = personClass.newInstance();
        System.out.println(person2);

        //constructor1.setAccessible(true);//暴力反射


    }
}
