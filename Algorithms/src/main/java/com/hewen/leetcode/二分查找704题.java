package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 二分查找704题 {
    @Test
    public void test01() {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int tar = 12;
        //largestNumber(a);
        System.out.println(search(a, tar));
        //System.out.println(99 / 100);
    }

    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int mid = nums.length / 2;
        while (leftIndex<=rightIndex) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                rightIndex=mid-1;
                mid=(leftIndex+rightIndex)/2;
            }
            else {
                leftIndex=mid+1;
                mid=(leftIndex+rightIndex)/2;
            }
            //mid=(leftIndex+rightIndex)/2;
        }
        return -1;
    }
}
