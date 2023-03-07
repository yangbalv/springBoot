package com.springboot.live_comm.coding.leetcode.treeyue;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        Solution solution = new Solution();
        solution.findNumbers(nums);
        System.out.println(solution.countLargestGroup(13));
        System.out.println(solution.intToRoman(13));
    }

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    public int countLargestGroup(int n) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int count = count(i);
            System.out.println(count);
            Integer value = map.getOrDefault(count, 1);
            value++;
            map.put(count, value);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                res = 1;
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                res++;
            }

        }
        return res;
    }

    public int count(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n = n / 10;
        }


        return res;
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer stringBuffer = new StringBuffer();
        int p = 0;
        while (num > 0) {
            int count = num / values[p];
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    stringBuffer.append(symbols[p]);
                }
            }
            num = num % values[p];

            p++;

        }
        return stringBuffer.toString();
    }

    public List<Integer> inorderTraversal(TreeNode root) {


        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        int val = root.val;
        if (null != root.left) {
            res = inorderTraversal(root.left);
        }
        res.add(val);
        if (null != root.right) {
            List<Integer> list = inorderTraversal(root.right);
            res.addAll(list);
        }
        return res;

    }

//    public List<Integer> aaa(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        int val = root.val;
//        if (null != root.left) {
//            res = aaa(root.left);
//        }
//        res.add(val);
//        if (null != root.right) {
//            List<Integer> list = aaa(root.right);
//            res.addAll(list);
//        }
//        return res;
//    }

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
    }

}