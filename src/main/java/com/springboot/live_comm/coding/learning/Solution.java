package com.springboot.live_comm.coding.learning;


import javax.management.Query;
import java.util.Arrays;
import java.util.Stack;

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

class TreeNode {
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
}

public class Solution {
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(7);
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//
//        ListNode listNode = solution.mergeTwoLists(listNode1, listNode4);
//
//        while (null != listNode) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//    }

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

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode node = null;
        while (p != null) {
            ListNode util = p.next;
            p.next = node;
            node = p;
            p = util;
        }
        return node;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        int count = right - left + 1;
        for (int i = 0; i < left - 2; i++) {
            p = p.next;
        }
        ListNode start = p.next;
        ListNode node = null;
        while (start != null) {
            ListNode util = start.next;
            start.next = node;
            node = start;
            start = util;
        }
        return head;
    }

    public int maxDepth(TreeNode root) {

        return count(root, 1);
    }

    public int count(TreeNode root, int i) {
        if (root == null) {
            return i + 1;
        } else return Math.max(count(root.left, i + 1), count(root.right, i + 1));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricUtil(root, root);

    }

    public boolean isSymmetricUtil(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree3(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int val = preorder[0];
        TreeNode head = new TreeNode(val);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                int left = i - 1;
                int right = i + 1;
                if (left >= 0) {
                    int[] pLefts = new int[left + 1];
                    int[] iLefts = new int[left + 1];
                    System.arraycopy(preorder, 1, pLefts, 0, left + 1);
                    System.arraycopy(inorder, 0, iLefts, 0, left + 1);
                    head.left = buildTree(pLefts, iLefts);
                }

                if (right < preorder.length) {
                    int[] pRights = new int[preorder.length - right];
                    int[] iRights = new int[preorder.length - right];
                    System.arraycopy(preorder, right, pRights, 0, pRights.length);
                    System.arraycopy(inorder, right, iRights, 0, pRights.length);
                    head.right = buildTree(pRights, iRights);
                }
                break;
            }

        }

        return head;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTreeUtil(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    public TreeNode buildTreeUtil(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR) {

        int val = preorder[pL];
        TreeNode head = new TreeNode(val);

        for (int i = iL; i <= iR; i++) {
            if (inorder[i] == val) {
                int left = i - iL;
                int right = iR - i;
                if (left > 0) {
                    head.left = buildTreeUtil(preorder, pL + 1, pL + left, inorder, iL, iL + left - 1);
                }
                if (right > 0) {
                    head.right = buildTreeUtil(preorder, pR - right + 1, pR, inorder, iR - right + 1, iR);
                }
                break;
            }

        }

        return head;
    }

    public TreeNode buildTree3(int[] inorder, int[] postorder) {
        return buildTree3Util(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree3Util(int[] inorder, int iL, int iR, int[] postorder, int pL, int pR) {

        int val = postorder[pR];

        TreeNode head = new TreeNode(val);

        for (int i = iL; i <= iR; i++) {
            if (inorder[i] == val) {
                int left = i - iL;
                int right = iR - i;
                if (left > 0) {
                    head.left = buildTree3Util(inorder, iL, iL + left - 1, postorder, pL, pL + left - 1);
                }
                if (right > 0) {
                    head.right = buildTree3Util(inorder, iR - right + 1, iR, postorder, pR - right, pR - 1);
                }
                break;
            }

        }

        return head;
    }

}