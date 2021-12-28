package com.hewen.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ClassName Test099
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2021/12/29 0:56
 */
//动态的创建对象：通过反射
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("com.hewen.reflection.User");

        User user = (User) c1.newInstance();
        System.out.println(user);
        //直接调用的话输出是User{name='null', id=0, age=0}
        //本质是调用了类的无参构造器。
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User hewen = (User)constructor.newInstance("何文", 1, 1);
        System.out.println(hewen);
    }
}
