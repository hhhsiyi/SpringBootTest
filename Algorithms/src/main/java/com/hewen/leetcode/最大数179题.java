package com.hewen.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2021/10/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 最大数179题 {
    @Test
    public void test01() {
        int[]a = {10,2};
        largestNumber(a);
        System.out.println(99/100);
    }

    public String largestNumber(int[] nums) {
        Arrays.sort(nums);
        int max = Arrays.stream(nums).max().getAsInt();
        System.out.println(max);
        int digt = 1;
        String ret = "";
        while (max/digt>0){

            digt*=10;
        }
        return "max";
    }
}
