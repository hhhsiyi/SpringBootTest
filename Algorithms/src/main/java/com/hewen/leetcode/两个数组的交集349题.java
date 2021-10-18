package com.hewen.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 2021/10/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 两个数组的交集349题 {
    @Test
    public void test1() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,8,9,4,4};
        int[] i = intersection2(nums1, nums2);
        for (int num :
                i) {
            System.out.println(num);
        }
    }
    //效率高点？
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num :
                nums1) {
            set1.add(num);
        }
        for (int num :
                nums2) {
            set2.add(num);
        }
        int size1 = set1.size();
        int size2 = set2.size();
        if (size1>size2){
            return getIntersection(set1,set2);
        }
        else {
            return getIntersection(set2,set1);
        }
    }
    public int[] getIntersection(Set<Integer> big, Set<Integer> small){
        //遍历小的，在大的里面找小的
        ArrayList<Integer> ints1 = new ArrayList<>();
        Integer[] ints = new Integer[small.size()];
        int i=0;
        for (int num :
                small) {
            if (big.contains(num)){
                ints1.add(num);
//                ints[i]=num;
//                i++;
            }
        }
        //Integer转int类型
        int[] arr1 = ints1.stream().mapToInt(Integer::valueOf).toArray();
        //int[] arr2 = Arrays.stream(ints).mapToInt(Integer::valueOf).toArray();
        return arr1;
    }
//第一次
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] ints;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num :
                nums1) {
            if (map.containsKey(num)) {
                continue;
            } else {
                map.put(num, 0);
            }
        }
        for (int num :
                nums2) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                continue;
            }
        }
        HashSet<Integer> integers = new HashSet<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            if (value>0){
                integers.add(key);
            }
        }
        System.out.println(map);
        System.out.println(integers);
        int[] ints1 = new int[integers.size()];
        int i = 0;
        for (int num :
                integers) {
            ints1[i]=num;
            i++;
        }
        return ints1;
    }
}
