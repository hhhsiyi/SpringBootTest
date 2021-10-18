package com.hewen.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021/10/8
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 多数元素169题 {
    //第一种思路，哈希表！
    public int majorityElement(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num :
                nums) {
            if (map.containsKey(num)) {
//                Integer integer = map.get(num);
//                integer++;
                map.put(num, map.get(num)+1);
            } else
                map.put(num, 0);
        }
        System.out.println(map);
        int maxTrueNum=0;
        int maxIndex=0;

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
//
//        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Integer, Integer> next = iterator.next();
//            if (next.getValue()>maxIndex){
//                maxIndex=next.getValue();
//                maxTrueNum=next.getKey();
//            }
//        }
//        return maxTrueNum;
    }

    @Test
    public void test1() {
        int[] a = {6,6,6,7,7};
        int i = majorityElement(a);
        System.out.println(i);
    }
}
