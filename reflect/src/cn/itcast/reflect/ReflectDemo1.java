package cn.itcast.reflect;

import cn.itcast.domain.Person;
import cn.itcast.domain.Student;

/**
 * @author kpwang
 * @create 2020-07-25 16:43
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName("全路径");  多用于配置文件，将类名定义在配置文件中。读取文件，加载类
        Class<?> cls1 = Class.forName("cn.itcast.domain.Person");
        System.out.println(cls1);
        //2.类名.class   多用于参数的传递
        Class<Person> cls2 = Person.class;
        System.out.println(cls2);
        //3.对象.getClass   多用于对象的获取字节码的方式
        Person p=new Person();
        Class<? extends Person> cls3 = p.getClass();
        System.out.println(cls3);


        //==比较三个对象
        System.out.println(cls1==cls2);//true
        System.out.println(cls1==cls3);//true
        System.out.println(cls2==cls3);//true


        Class<Student> c = Student.class;
        System.out.println(c==cls1);

    }
}
