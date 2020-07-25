package cn.itcast.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author kpwang
 * @create 2020-07-25 18:14
 */

public @interface MyAnno {
    int value();//如果只有一个属性需要赋值，并且是value，可以省略
    /*String name() default "zhaoliying";*/
    Person per();
    MyAnno2 anno2();
    String[] strs();
}
