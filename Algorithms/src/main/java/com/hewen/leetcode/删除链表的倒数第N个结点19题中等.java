package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/14
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 删除链表的倒数第N个结点19题中等 {

    @Test
    public void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        System.out.println(n1);
        ListNode listNode = removeNthFromEnd(n1, 2);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode head1 = head;
        ListNode head2 = head;
        while (head1 != null) {
            head1 = head1.next;
            i++;
        }
        if (i==1&&n==1){
            return null;
        }
        int t = i - n;
        i = 1;
        ListNode res = new ListNode(0, head);
        while (head2 != null) {
            if (i >= t) {
                if (head2.next!=null&&head2.next.next != null) {
                    head2.next = head2.next.next;
                    break;
                } else {
                    head2.next = null;
                    break;
                }
            }
            head2 = head2.next;
            i++;
        }
        System.out.println(i + "个节点");
        return head;
    }
}
