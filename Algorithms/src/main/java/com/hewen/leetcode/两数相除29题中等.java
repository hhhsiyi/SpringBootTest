package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/12
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 两数相除29题中等 {
    @Test
    public void test01(){
        System.out.println(divide(10,3));
        System.out.println(3<<3);
    }
    public int divide(int dividend, int divisor) {
        if (dividend==Integer.MIN_VALUE){
            if (divisor==1)
                return Integer.MIN_VALUE;
            if (divisor==-1)
                return Integer.MAX_VALUE;
        }

        return -1;
    }
}
