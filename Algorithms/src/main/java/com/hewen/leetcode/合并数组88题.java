package com.hewen.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2021/10/8
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 合并数组88题 {
    @Test
    public void test2(){
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        merge3(nums1,m,nums2,n);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[n + m];
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
        int flag=0;
        for (int i=nums1.length-m;i<nums1.length;i++){
            temp[flag]=nums1[i];
            flag++;
        }
        for (int i=nums2.length-n;i<nums2.length;i++){
            temp[flag]=nums2[i];
            flag++;
        }
        Arrays.sort(temp);
        nums1=temp;
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        for (int i=0;i<n;i++){
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    @Test
    public void test() {
        int[] n1 = {1,2,3,0,0,0};
        int n = 3;
        int[] n2 = new int[]{4, 1, 3};
        int m = 3;
        int[] temp = new int[n + m];
        Arrays.sort(n1);
        Arrays.sort(n2);
        int flag=0;
        for (int i=n1.length-n;i<n1.length;i++){
            temp[flag]=n1[i];
            flag++;
        }
        for (int i=n2.length-m;i<n2.length;i++){
            temp[flag]=n2[i];
            flag++;
        }
        Arrays.sort(temp);
//        int length1 = n1.length;
//        for (int i=0;i!=m;i++){
//            n1[length1+i]=n2[i];
//        }
//        for (int i = 0; i < temp.length; i++) {
//            for (int j = n; j < n1.length; j++) {
//                temp[i] = n1[j];
//            }
//        }
//        for (int i=0;i<n2.length;i++){
//            temp[n+i]=n2[i];
//        }
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
//        for (int i = 0; i < n1.length; i++) {
//            System.out.print(n1[i] + " ");
//        }
//        System.out.println();
//        ArrayList<int[]> ints = new ArrayList<>(Arrays.asList(n1));
//        for (int i = 0; i < ints.size(); i++) {
//            ints.get(i);
//        }
//        System.out.println();
//        ints.addAll(Arrays.asList(n2));
//        for (int i = 0; i < ints.size(); i++) {
//            ints.get(i);
//        }
//        System.out.println();


    }
}
