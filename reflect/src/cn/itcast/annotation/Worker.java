package cn.itcast.annotation;

/**
 * @author kpwang
 * @create 2020-07-25 18:25
 */
@MyAnno(value = 21,per=Person.P1,anno2 = @MyAnno2,strs = {"abc","ddd"})
@MyAnno3
public class Worker {
    @MyAnno3
    public String name;

    @MyAnno3
    public void show(){

    }
}
