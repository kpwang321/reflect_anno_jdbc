package cn.itcast.reflect;

import cn.itcast.domain.Person;
import cn.itcast.domain.Student;

import java.lang.reflect.Field;

/**
 * @author kpwang
 * @create 2020-07-25 16:43
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //1.获取Person的Class对象
        Class<Person> personClass = Person.class;
        //2.获取成员变量
        Field[] fields = personClass.getFields();//获取所有public修饰的成员变量
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-------");
        Field a = personClass.getField("a");
        Person p=new Person();
        Object value = a.get(p);
        System.out.println(value);

        a.set(p,"张三");
        System.out.println(p);
        System.out.println("-----------");

        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);



    }
}
