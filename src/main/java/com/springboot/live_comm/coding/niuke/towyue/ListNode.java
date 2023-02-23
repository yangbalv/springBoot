package com.springboot.live_comm.coding.niuke.towyue;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    ListNode() {

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);

        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(listNode1);
        System.out.println(ListNode.ReverseList(listNode1));
    }

    public static ListNode ReverseList(ListNode head) {


        if (head != null) {
            ListNode util = new ListNode(head.val);
            head = head.next;
            while (head != null) {
                ListNode util1 = new ListNode(head.val);
                util1.next = util;
                util = util1;
                head = head.next;
            }
            return util;
        } else {
            return head;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}