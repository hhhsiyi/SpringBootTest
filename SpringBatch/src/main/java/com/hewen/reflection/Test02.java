package com.hewen.reflection;

//什么叫反射
public class Test02 {
    //通过反射去获取类的class对象
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.hewen.reflection.User");
        Class c2 = Class.forName("com.hewen.reflection.User");
        Class c3 = Class.forName("com.hewen.reflection.User");
        Class c4 = Class.forName("com.hewen.reflection.User");

        System.out.println(c1);
        //一个类在内存中，只有一个class对象
        //一个类在被加载后，类的整个结构都会被封装在Class对象中
        System.out.println(c2.hashCode()+" "+c3.hashCode()+" "+c4.hashCode());
    }
}
//pojo entity
class User{
    private String name;
    private int id;
    private int age;

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
