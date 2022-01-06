package com.hewen.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 2022/1/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//分析性能问题
public class Test10 {
    //通过普通方式调用
    static long num=1000000000L;
    public static void test01(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法执行这么多次需要"+(endTime-startTime)+"ms");
    }
    //通过反射方式调用
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName",null);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通反射方法执行这么多次需要"+(endTime-startTime)+"ms");
    }
    //通过反射方式加关闭安全监测
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName",null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("关闭检测的反射方法执行这么多次需要"+(endTime-startTime)+"ms");
        System.out.println("关闭检测会更快，！！！但是安全性更低！");
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }
}
