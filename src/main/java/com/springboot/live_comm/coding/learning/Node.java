package com.springboot.live_comm.coding.learning;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node random;


    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node nodeNew = new Node(head.val);
            map.put(head, nodeNew);
            nodeNew.next = copyRandomList(head.next);
            nodeNew.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        for (Node a = head; a != null; a = a.next.next) {
            Node node = new Node(a.val);
            node.next = a.next;
            a.next = node;
        }

        for (Node a = head; a != null; a = a.next.next) {
            a.next.random = a.random == null ? null : a.random.next;
        }
//        这里思路是将两个链表再度合并
        for (Node a = head; a != null; a = a.next) {
//每次拿到的是源列表的数据
            Node pNode = a.next;
            Node pNext = pNode.next.next;
            a.next = a.next.next;
            pNode.next = pNext;

        }
        return head.next;
    }

}