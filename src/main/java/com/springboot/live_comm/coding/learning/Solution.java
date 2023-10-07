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
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = solution.addTwoNumbers(listNode1, listNode4);

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
        ListNode head = new ListNode();
        ListNode p = head;

        if (null != list1 && null != list2) {
            if (list1.val >= list2.val) {
                p = list1;
                list1 = list1.next;
            } else {
                p = list2;
                list2 = list2.next;
            }
            head = p;
        }

        while (list1 != null && list2 != null) {
            list1.next

        }
        if (list1 != null) {

        }


    }
}