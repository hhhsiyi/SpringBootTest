package com.hewen.reflection;

/**
 * ClassName Test05
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2021/12/26 17:42
 */
//
public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.m);
        /*
        1.加载到内存。会产生一个类对应的Class对象
        2.链接：链接结束后m=0；
        3.初始化：
        <clinit>(){
                System.out.println("a类 的静态代码块初始化");
                m = 300;
                m = 100;
        }
         */
    }
}
class A{
    static {
        System.out.println("a类 的静态代码块初始化");
        m = 300;
    }
    static  int m = 100;
    //先等于300，再等于100
    //已经测试过了，静态代码块和静态变量，哪个在前，就哪个先赋值，如果这里把静态代码块和静态变量的位置对调，则输出的是300
    public A(){
        System.out.println("a类的无参构造初始化");
    }
}
