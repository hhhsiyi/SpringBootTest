package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2022/2/16
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 位1的个数191题简单 {
    @Test
    public void test01(){
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String s = n+"";
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1')
                sum++;
        }
        return sum;
    }
}
