package com.hewen.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//枚举本身就是一个类，class
public enum EnumSingle {
    INSTANCE;
    public EnumSingle getInstance(){
        return INSTANCE;
    }
}
class Test{
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        EnumSingle instance1 = EnumSingle.INSTANCE;
//        EnumSingle instance2 = EnumSingle.INSTANCE;
//        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
//        最真实的反编译下来之后发现其实里面只有有参构造，没有无参构造的！
//        Exception in thread "main" java.lang.NoSuchMethodException: com.hewen.single.EnumSingle.<init>()
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle enumSingle = declaredConstructor.newInstance();

        System.out.println(instance1);

//        System.out.println(instance2);
        System.out.println(enumSingle);
    }
}
