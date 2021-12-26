package com.hewen.reflection;

import java.lang.annotation.ElementType;

/**
 * ClassName Test04
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2021/12/26 17:12
 */
//测试所有类型的Class
public class Test04 {
    public static void main(String[] args) {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = Override.class;
        Class c6 = ElementType.class;
        Class c7 = Integer.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        //按序号：对象、接口、一维数组、二维数组、注解、枚举、基本数据类型、void、Class
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        //只要元素类型和维度一样，那么就是同一个Class
        int[] a = new int[10];
        int[] b = new int[20];
        System.out.println("一个类只有Class对象"+a.getClass().hashCode()+" "+b.getClass().hashCode());
    }
}
