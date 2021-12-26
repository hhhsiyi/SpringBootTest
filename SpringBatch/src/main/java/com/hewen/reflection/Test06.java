package com.hewen.reflection;

/**
 * ClassName Test06
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2021/12/26 18:11
 */
//测试类什么的时候回初始化
public class Test06 {
    static {
        System.out.println("main类被加载");
    }
    //- 当虚拟机启动，先初始化main方法所在的类
    //-

    public static void main(String[] args) throws ClassNotFoundException {
        //1主动引用：
//        Son son = new Son();
        //通过反射也会产生主动引用。反射会极大的消耗资源
//        Class son2 = Class.forName("com.hewen.reflection.Son");
        //不会产生类的引用的方法：
        //通过子类调用父类的静态的方法，会加载父类不会加载子类
//        System.out.println(Son.b);
        //通过数组也不会产生类的引用
//        Son[] array = new Son[5];
        //常量池里的东西并不会引起初始化
        System.out.println(Son.M);
        System.out.println(Son.m);
    }

}
class Father{
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }

}
class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}
