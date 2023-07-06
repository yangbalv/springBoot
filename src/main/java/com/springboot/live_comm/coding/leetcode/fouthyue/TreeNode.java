package com.springboot.live_comm.coding.leetcode.fouthyue;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TreeNode {

    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        left = new TreeNode();
        right = new TreeNode();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        String lefts = "null";
        String rights = "null";
        if (getLeft() != null) {
            lefts = left.toString();
        } else {
            lefts = "null";
        }
        if (getRight() != null) {
            rights = right.toString();
        } else {
            rights = "null";
        }
        return "TreeNode{" +
                "val=" + val +
                ", left=" + lefts +
                ", right=" + rights +
                '}';
    }
//    public Set<Character> set1 = new HashSet<>();
//    public Set<Character> set2 = new HashSet<>();
//
//
//    //    2假设有人给定一个公式字符串，请你完成公式计算式得出结果，如:2+8/2*(5+5+3)
//    public static void main(String[] args) {
//        Test test = new Test();
//        test.set1.add('+');
//        test.set1.add('-');
//        test.set2.add('*');
//        test.set2.add('/');
//    }
//
//    public int test(String s) {
//        int count1 = 0;
//        int p = -1;
//        int num = 0;
//        int numL = 0;
//        int count = 1;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            switch (c) {
//                case '+': {
//                    if (count1 == 0) {
//                        return test(s.substring(0, i)) + test(s.substring(i + 1, s.length() - 1));
//                    }
//                }
//                case '-':
//                    if (count1 == 0) {
//                        return test(s.substring(0, i)) + test(s.substring(i + 1, s.length() - 1));
//                    }
//                case '*':
//                case '/':
//                case '(':
//                case ')':
//
//            }
//            char c = s.charAt(i);
//            if (set1.contains(c)) {
//                if (count1 == 0) {
//                    return test(s.substring())
//                }
//
//            } else if (set2.contains(c)) {
//
//            } else if (c == '(') {
//
//                count1++;
//                if (p == -1) {
//                    p = i;
//                }
//            } else if (c == ')') {
//                count1--;
//                if (count1 == 0) {
//                    numL = test(s.substring(p, i));
//                }
//
//            } else {
//                int nowNum = c - '0';
//                num = num * count + nowNum;
//                count *= 10;
//            }
//        }
//        return num;
//    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode5.setLeft(treeNode6);
        treeNode4.setLeft(treeNode5);
        treeNode4.setRight(treeNode9);
        treeNode3.setLeft(treeNode4);
        treeNode2.setLeft(treeNode3);
        treeNode2.setRight(treeNode8);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode7);

        treeNode7.setRight(treeNode8);
        treeNode8.setRight(treeNode2);
        treeNode9.setRight(treeNode5);

        System.out.println(treeNode1.toString());


    }

}
