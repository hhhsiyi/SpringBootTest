package com.hewen.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ClassName Test08
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2021/12/26 18:39
 */
//获得类的信息
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.hewen.reflection.User");
        User user = new User();
        c1 = user.getClass();

        //获得类的名字
        System.out.println(c1.getName());//获得包名+类名(全限定类名)
        System.out.println(c1.getSimpleName());//获得类名

        //获得类的属性
        Field[] fields = c1.getFields();//只能找到public属性
        for (Field field : fields) {
            System.out.println(field);
        }
        Field[] declaredFields = c1.getDeclaredFields();//找到全部的属性
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //获得指定属性的值
        //NoSuchFieldException需要用getDeclaredField
        //私有一定要getDeclared
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("正常的" + method);
        }
        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("getDeclaredMethods" + declaredMethod);
        }
        //因为怕重载
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);
        //获得指定的构造器
        System.out.println("==============");
        Constructor[] constructors = c1.getConstructors();
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("正常" + constructor);
        }
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("全部" + declaredConstructor);
        }
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println();

    }
}
