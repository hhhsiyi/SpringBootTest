package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2022/2/14
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 有序数组中的单一元素540题中等 {
    @Test
    public void test01(){
        int[]num ={3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(num));
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int len = nums.length;
        if (nums[len-2]!=nums[len-1]){
            return nums[len-1];
        }
        int index=0;
        for (int i = 0; i < len; i+=2) {
            if (nums[i]!=nums[i+1]){
                index=i;
                break;
            }
        }
        return nums[index];
    }
}
