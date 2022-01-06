package com.hewen.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName Test099
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2021/12/29 0:56
 */
//动态的创建对象：通过反射
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.hewen.reflection.User");

        User user = (User) c1.newInstance();
        System.out.println(user);
        //直接调用的话输出是User{name='null', id=0, age=0}
        //本质是调用了类的无参构造器。
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User hewen = (User)constructor.newInstance("何文", 1, 1);
        System.out.println(hewen);
        //通过反射调用普通构造方法
        User user3 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke  :激活，{传入一个对象，和要给那个对象设置的值}
        //测试了一下，可以用这种方式访问static修饰的，private的不能访问
        setName.invoke(user3,"hewen");//执行
        //要给user3的setName方法传入一个hewen的值
        System.out.println(user3.getName());
        //高级一点：通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //with modifiers "private"报错，是权限问题，不能直接操作私有属性，我们需要关闭程序的安全监测
        name.setAccessible(true);//这个就会放开权限！暴力反射，但是与此同时，也会降低我们代码的安全性和性能
        name.set(user4,"hewen2");
        System.out.println(user4.getName());
    }
}
