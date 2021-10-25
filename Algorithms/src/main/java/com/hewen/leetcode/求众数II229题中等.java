package com.hewen.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 2021/10/22
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 求众数II229题中等 {
    @Test
    public void test01() {
        int[] a = {1,1,1,3,3,2,2,2};
        List<Integer> integers = majorityElement(a);
        System.out.println(integers);
    }

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i :
                nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int t= n/3;
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
//        while (it.hasNext()){
//            Integer value = it.next().getValue();
//            Integer key = it.next().getKey();
//            if (value>t){
//                res.add(key);
//            }
//        }
        for (Map.Entry<Integer, Integer> entry:
        map.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value>t){
                res.add(key);
            }
        }
        System.out.println(t);
        System.out.println(map);
        return res;
    }
}
