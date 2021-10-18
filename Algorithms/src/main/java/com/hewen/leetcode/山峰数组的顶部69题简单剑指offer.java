package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/14
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 山峰数组的顶部69题简单剑指offer {
    @Test
    public void test01() {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(getMax(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i+1]<arr[i]){
                return i;
            }
        }
        return -1;
    }
    public int getMax(int[] arr){
        int l = 0 ;
        int r = arr.length-1;
        //找到第一个i>i+1就行
        int ans=-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (arr[mid]>arr[mid+1]){
                ans=mid;
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        return ans;
    }
}
