package com.hewen.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2021/10/13
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 反转字符串中的单词III557题简单 {
    @Test
    public void test01() {
        String s = "Let's take LeetCode contest";

        //System.out.println(s);
//        reverseString(s);
        String s1 = reverseWords(s);
        System.out.println("========");
        System.out.println(s1);
        //System.out.println(s);
    }

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        Queue<String> objects = new LinkedList<>();
        for (int i = 0; i < s1.length; i++) {
            objects.add(s1[i]);
        }
        String res="";
        while (!objects.isEmpty()) {
            String pop = objects.poll();
            char[] chars1 = pop.toCharArray();
            reverseString(chars1);
            res=res+" "+String.valueOf(chars1);
            //System.out.println(pop);
        }
        return res.trim();
    }

    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void reverseString(char[] s) {
        for (int l = 0, r = s.length - 1; l < r; ) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

}
