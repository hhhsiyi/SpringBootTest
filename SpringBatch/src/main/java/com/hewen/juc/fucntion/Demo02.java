package com.hewen.juc.fucntion;

import java.util.function.Predicate;

/**
 * 2022/1/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Demo02 {
    public static void main(String[] args) {
        //判断字符串是否为空
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s==null||s.isEmpty())
                    return true;
                return false;
            }
        };
        Predicate<String> predicate1 = (str)->{return str.isEmpty();};
        System.out.println(predicate1.test(""));
    }
}
