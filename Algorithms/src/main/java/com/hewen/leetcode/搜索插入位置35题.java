package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 搜索插入位置35题 {
    @Test
    public void test01() {
        int[] a = {1,3};
        int tar = 2;
        //largestNumber(a);
        //System.out.println(search(a, tar));
        //System.out.println(99 / 100);
        System.out.println(searchInsert(a,tar));
    }
    public int searchInsert(int[] nums, int target) {
        int leftIndex=0;
        int rightIndex = nums.length-1;
//        int mid = (leftIndex+rightIndex)/2;
        int flg=0;
        int mid=-1;
        while (leftIndex<=rightIndex){
            mid=(rightIndex-leftIndex)/2+leftIndex;
            if (target==nums[mid]){
                return mid;
            }
            else if (target>nums[mid]){
                leftIndex=mid+1;
                flg=1;
            }
            else {
                rightIndex=mid-1;
                flg=2;
            }
        }
        return leftIndex;
    }
}
