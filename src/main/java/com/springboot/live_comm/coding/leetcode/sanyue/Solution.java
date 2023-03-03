package com.springboot.live_comm.coding.leetcode.sanyue;

import java.util.*;

class Solution {


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        res.add("()");
        if (n == 1) {
            return res;
        }
        for (int i = 1; i < n; i++) {
            res = addParenthesis(res);

        }
        return res;

    }

    public List<String> addParenthesis(List<String> list) {
        Set<String> set = new HashSet<>();

        List<String> res = new ArrayList<>();
        for (String s : list) {


            for (int i = 0; i < s.length(); i++) {
                StringBuffer stringBuffer = new StringBuffer(s);
                String append = stringBuffer.insert(i, "(").toString();
                for (int j = 0; j < append.length(); j++) {
                    StringBuffer stringBuffer1 = new StringBuffer(append);
                    String s1 = stringBuffer1.insert(j, ")").toString();

                    if (check(s1)) {
                        if (!set.contains(s1)) {
                            res.add(stringBuffer1.toString());
                            set.add(s1);
                        }

                    }
                }
            }
        }
        return res;
    }

    public boolean check(String req) {
        int l = 0;
        int r = 0;

        for (int i = 0; i < req.length(); i++) {
            if (req.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (r > l) {

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum2(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int l = 0; l < nums.length; l++) {
            if (l > 0 && nums[l] == nums[l - 1]) {
                continue;
            }
            for (int j = l + 1; j < nums.length; j++) {

            }

        }
        return res;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


}