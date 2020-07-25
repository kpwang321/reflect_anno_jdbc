package cn.itcast.annotation.demo;

/**
 * @author kpwang
 * @create 2020-07-25 20:47
 */
public class Calculator {
    //加法
    @Check
    public void add(){
        String str=null;
        str.toString();
        System.out.println("1+0="+(1+0));
    }
    //减法
    @Check
    public void sub(){
        System.out.println("1-0="+(1-0));
    }
    //乘法
    @Check
    public void mul(){
        System.out.println("1*0="+(1*0));
    }
    //除法
    @Check
    public void div(){
        System.out.println("1/0="+(1/0));
    }
    //加法
    public void show(){
        System.out.println("永无bug");
    }
}
