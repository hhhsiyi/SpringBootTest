package com.hewen.thread;

/**
 * 2021/12/21
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Hewen {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Hewen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Hewen(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
