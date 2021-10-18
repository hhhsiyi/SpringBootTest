package com.hewen.leetcode;

import org.junit.Test;

import java.util.HashSet;

/**
 * 2021/10/8
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 存在重复元素217题 {
    @Test
    public void test1(){
        int[]a={1,2,3,2};
        boolean b = containsDuplicate(a);
        System.out.println(b);
    }
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        HashSet<Integer> integers = new HashSet<>();
        for (int num :
                nums) {
            integers.add(num);
        }
        int size = integers.size();
        return length==size?false:true;
    }
}
