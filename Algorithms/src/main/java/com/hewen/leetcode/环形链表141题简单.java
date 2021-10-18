package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/13
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 环形链表141题简单 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @Test
    public void test01(){
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        //listNode4.next=listNode2;
        System.out.println(hasCycle(listNode1));
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while (fast!=null){
            if (fast.next==null){
                fast=fast.next;
                continue;
            }
            slow=slow.next;
            fast=fast.next.next;
            if (fast!=null&&fast.next==slow.next) {
                return true;
            }
        }
        return false;
    }
}
