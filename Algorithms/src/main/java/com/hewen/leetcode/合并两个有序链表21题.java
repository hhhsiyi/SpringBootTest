package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 合并两个有序链表21题 {
    @Test
    public void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(4);
        n2.next = n3;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        m1.next = m2;
        ListNode m3 = new ListNode(4);
        m2.next = m3;
        System.out.println(n1);
        System.out.println(m1);
        System.out.println(mergeTwoLists(n1, m1));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode();
        ListNode prev = resultList;
//        if (l1==null){
//            return l2;
//        }
//        else if (l2==null){
//            return l1;
//        }
//        else if (l1.val<l2.val){
//            l1.next=mergeTwoLists(l1.next,l2);
//            return l1;
//        }else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
//                resultList.val = l2.val;
//                l2 = l2.next;
//                resultList = resultList.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
//                resultList.val = l1.val;
//                l1 = l1.next;
//                resultList = resultList.next;
            }
            prev=prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return resultList.next;
    }
}
