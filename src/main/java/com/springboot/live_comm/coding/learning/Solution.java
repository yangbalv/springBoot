package com.springboot.live_comm.coding.learning;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        listNode
        int util = 0;
        while (l1 != null && l2 != null) {
            int count = l1.val + l2.val + util;
            if (count >= 10) {
                util = 1;
            }
            count = count % 10;
            ListNode listNode1 = new ListNode();
            listNode.val = count;



        }

    }
}