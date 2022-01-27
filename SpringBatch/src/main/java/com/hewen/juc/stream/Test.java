package com.hewen.juc.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * 2022/1/27
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1, "hewen1", 18);
        User u2 = new User(2, "hewen2", 24);
        User u3 = new User(3, "hewen3", 25);
        User u4 = new User(4, "hewen4", 38);
        User u5= new User(5, "hewen5", 4);
        //用一行代码完成对这五个用户的筛选
        /*
        1.id是偶数
        2.年龄大于23
        3.用户名变大写
        4.用户名字倒序
        5.只输出一个用户
         */
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        //集合就是存储
        //链式编程！！lambda表达式
        list.stream()
                .filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>23;})
                .map(u->{return u.getName().toUpperCase(Locale.ROOT);})
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);})//compareTo是正序排序
                .limit(1)
                .forEach(System.out::println);
    }
}
