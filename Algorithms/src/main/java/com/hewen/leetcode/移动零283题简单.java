package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/12
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 移动零283题简单 {

    @Test
    public void test01(){
        int []a =  {0,1,0,3,12};
        for (int i :
                a) {
            System.out.print(i+" ");
        }
        System.out.println();
        moveZeroes(a);
        for (int i :
                a) {
            System.out.print(i+" ");
        }
    }

    public void moveZeroes(int[] nums) {
        // 既然是双指针
        int l=0,r=0,n=nums.length;
        // 右指针指向待处理序列的头部
        while (r<n){
            if (nums[r]!=0){
                swap(nums,l,r);
                l++;
            }
            r++;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
