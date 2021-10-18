package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/14
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 链表的中间结点876题简单 {
    @Test
    public void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n3.next = n4;
        n4.next = n5;
        //n5.next = n6;
        System.out.println(n1);
        ListNode listNode = middleNode(n1);
        System.out.println(listNode);
        //ListNode listNode = sortList(n1);
        //System.out.println(listNode);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast!=null&&fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return slow;
            }
        }
    }
}
