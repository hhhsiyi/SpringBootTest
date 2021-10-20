package com.hewen.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2021/10/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 最小操作次数使数组元素相等453题简单 {
    @Test
    public void test01() {
        int[]a = {1,2,3};
        System.out.println(minMoves(a));
    }

    public int minMoves(int[] nums) {
        //1个数减1
        int min = Arrays.stream(nums).min().getAsInt();
        int a=0;
        for (int i :
                nums) {
            a+=i-min;
        }
        return a;
    }
}
