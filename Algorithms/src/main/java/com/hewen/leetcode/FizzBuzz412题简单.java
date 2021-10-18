package com.hewen.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021/10/13
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class FizzBuzz412题简单 {
    @Test
    public void test01() {
        System.out.println(fizzBuzz(3));
    }

    public List<String> fizzBuzz(int n) {
        ArrayList<String> strings = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0) {
                strings.add("FizzBuzz");
            } else if (i % 3 == 0) {
                strings.add("Fizz");
            } else if ((i % 5 == 0)) {
                strings.add("Buzz");
            } else {
                strings.add(String.valueOf(i));
            }
            i++;
        }
        return strings;
    }
}
