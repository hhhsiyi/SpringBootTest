package com.hewen.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 2022/1/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//练习ORM 对象关系映射，反射操作注解
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.hewen.reflection.Student2");

        //通过反射去获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解的value的值
        System.out.println("获得注解的value的值");
        TableHe annotation = (TableHe)c1.getAnnotation(TableHe.class);
        String value = annotation.value();
        System.out.println(value);
        //获得类指定的注解
        System.out.println("获得类指定的注解");
        Field f = c1.getDeclaredField("name");
        FieldHe annotation1 = f.getAnnotation(FieldHe.class);
        System.out.println(annotation1.columnName()+" "+annotation1.type()+" "+annotation1.length());

    }
}

@TableHe("my_db_student")
class Student2 {
    @FieldHe(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FieldHe(columnName = "db_age",type = "int",length = 10)
    private int age;
    @FieldHe(columnName = "db_name",type = "String",length = 10)
    private String name;

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableHe {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldHe {
    String columnName();

    String type();

    int length();
}