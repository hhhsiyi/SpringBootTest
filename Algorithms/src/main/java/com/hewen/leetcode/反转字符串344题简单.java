package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/13
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 反转字符串344题简单 {
    @Test
    public void test01() {
        char[]s = {'h','e','l','l','o'};
        System.out.println(1);
        System.out.println(s);
        reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        for (int l=0,r=s.length-1; l<r; ) {
            swap(s,l,r);
            l++;r--;
        }
    }
    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
