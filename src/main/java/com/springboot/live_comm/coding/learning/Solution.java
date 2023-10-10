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
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(7);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = solution.mergeTwoLists(listNode1, listNode4);

        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode p = res;

        int num = 0;

        while (!(null == l1 && null == l2 && num == 0)) {
            int count = num;
            if (l1 != null) {
                count += l1.val;
            }
            if (l2 != null) {
                count += l2.val;
            }

            p.val = count % 10;
            num = count / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if (!(null == l1 && null == l2 && num == 0)) {
                ListNode util = new ListNode();
                p.next = util;
                p = util;
            }
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }

        return head.next;

    }
}