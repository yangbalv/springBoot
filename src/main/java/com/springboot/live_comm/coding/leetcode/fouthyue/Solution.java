package com.springboot.live_comm.coding.leetcode.fouthyue;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }

            }
        }
        return res;
    }


    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else map.put(nums[i], i);

        }
        return null;
    }


    public class ListNode {
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

    public ListNode makeList(int[] nums) {
        ListNode res = new ListNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            ListNode n = new ListNode(nums[i]);
            n.next = res;
            res = n;
        }
        return res;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        addTwoNumbersUtil(l1, l2, 0);
        return l1;
    }

    public void addTwoNumbersUtil(ListNode l1, ListNode l2, int num) {
        if (l1 == null && l2 == null) {
        } else if (l1 == null && l2 != null) {
            l1 = l2;
            int util = l1.val;
            l1.val = (util + num) % 10;
            num = (util + num) / 10;
            if (l1.next == null) {
                if (num > 0) {
                    ListNode listNode = new ListNode(num);
                    l1.next = listNode;
                }
            } else {
                addTwoNumbersUtil(l1.next, null, num);
            }
        } else if (l1 != null && l2 == null) {
            int util = l1.val;
            l1.val = (util + num) % 10;
            num = (util + num) / 10;
            if (l1.next == null) {
                if (num > 0) {
                    ListNode listNode = new ListNode(num);
                    l1.next = listNode;
                }
            } else {
                addTwoNumbersUtil(l1.next, null, num);
            }
        } else {
            int util = l1.val;
            l1.val = (util + l2.val + num) % 10;
            num = (util + num + l2.val) / 10;
            if (l1.next == null && l2.next == null) {
                if (num > 0) {
                    ListNode listNode = new ListNode(num);
                    l1.next = listNode;
                }
            } else if (l1.next == null && l2.next != null) {
                l1.next = l2.next;
                addTwoNumbersUtil(l1.next, null, num);
            } else {
                addTwoNumbersUtil(l1.next, l2.next, num);
            }
        }

    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p;

        p = new ListNode(0);
        ListNode p1 = new ListNode(1);
        if (l1.val + l2.val > 10) {
            p.next = p1;
        }

        p = addTwoNumbersUtil2(p, l1, l2);
        return p.next;
    }

    public ListNode addTwoNumbersUtil2(ListNode p, ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return p;
        }
        if (l1.next != null && l2.next != null) {
            p.val = (l1.val + l2.val) % 10;
            if (l1.next != null && l2.next != null) {
                p.val = p.val + ((l1.next.val + l2.next.val) / 10);
            }
            l1 = l1.next;
            l2 = l2.next;

            ListNode listNode = new ListNode(0);
            listNode.next = p;
            p = listNode;
        } else if (l1.next != null && l2.next == null) {
            p = l1;
            return p;
        } else if (l1.next == null && l2.next != null) {
            p = l2;
            return p;
        } else {
            return p;
        }

        return addTwoNumbersUtil2(p, l1, l2);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int p = 0;

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                p = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, (i + 1) - p);
        }
        return max;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public String getString() {
            String lefts = new String();
            String rights = new String();

            if (left == null) {
                lefts = "null";
            } else {
                lefts = right.getString();
            }

            if (right == null) {
                rights = "null";
            } else {
                rights = right.getString();
            }

            return "TreeNode{" +
                    "val=" + val +
                    ", left= " + lefts +
                    ", right= " + rights +
                    '}';

        }

        @Override
        public String toString() {
            return getString();
        }
    }


    public TreeNode getModel() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode5.left = (treeNode6);
        treeNode4.left = (treeNode5);
        treeNode4.right = (treeNode9);
        treeNode3.left = (treeNode4);
        treeNode2.left = (treeNode3);
        treeNode2.right = (treeNode8);
        treeNode1.left = (treeNode2);
        treeNode1.right = (treeNode7);

        treeNode7.right = (treeNode8);
        treeNode8.right = (treeNode2);
        treeNode9.right = (treeNode5);
        return treeNode1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        ListNode l1 = solution.makeList(new int[]{2, 4, 9});
//        ListNode l2 = solution.makeList(new int[]{5, 6, 4, 9});
//        ListNode listNode = solution.addTwoNumbers(l1, l2);
        TreeNode treeNode = solution.getModel();
        System.out.println(treeNode.getString());
    }

}