package com.springboot.live_comm.coding.learning;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Stream;

public class Learning {
//    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
//        int[] nums2 = new int[]{2, 5, 6};
//        int[] nums3 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        int[] nums4 = new int[]{1, 1, 2};
//        int[] nums5 = new int[]{-1, -100, 3, 99};
//        int[] nums6 = new int[]{2, 0, 2, 4, 6, 0, 0, 3};
//        int[] nums7 = new int[]{100};
//
//        System.out.println(hIndex(nums7));
//    }


    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                max++;
            }
        }

        return max;
    }

    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public static int canJump2(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = length - 2; i >= 0; i--) {


            if (nums[i] + i >= length - 1) {
                dp[i] = 1;

            } else {
                int min = Integer.MAX_VALUE;
                for (int j = i + nums[i]; j > i; j--) {
                    if (dp[j] != 0) {
                        min = Math.min(min, 1 + dp[j]);
                        dp[i] = min;

                    }

                }
            }

        }
        return dp[0];
    }

    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex < i) {
                return false;
            } else {
                maxIndex = Math.max(maxIndex, nums[i] + i);
            }
        }
        return true;
    }

    public int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int value = prices[i] - prices[i - 1];
            if (value > 0) {
                res += value;
            }
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxValue = 0;
        for (int i = 1; i < prices.length; i++) {
            maxValue = Math.max(maxValue, prices[i] - minPrice);
            minPrice = Math.min(prices[i], minPrice);

        }
        return maxValue;
    }

    public static void aa(int b, boolean a, int... nums) {
        System.out.println(nums.length);

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int removeDuplicates2(int[] nums) {
        int index = 0;
        for (int i = 2; i < nums.length; i++) {

            if (nums[i] == nums[i - 1 - index] && nums[i] == nums[i - 2 - index]) {
                index++;
            } else {
                nums[i - index] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - index;
    }

    public static int removeDuplicatesx(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                index++;
            } else {
                nums[i - index] = nums[i];
            }
        }
        return nums.length - index;
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                index++;
            } else {
                nums[i - index] = nums[i];
            }
        }
        return nums.length - index;
    }

    public static int removeElement(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val) {
                index++;
            } else {
                nums[i - index] = nums[i];
            }
            if (index > 0) {
                nums[i] = 0;
            }
        }

        return nums.length - index;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = nums1.length - 1;
        int mp = m - 1;
        int np = n - 1;
        while (true) {
            if (mp < 0) {
                if (np >= 0) {
                    while (np >= 0) {
                        nums1[p] = nums2[np];
                        p--;
                        np--;
                    }
                }
                break;
            }


            if (np < 0) {
                if (mp >= 0) {
                    while (mp >= 0) {
                        nums1[p] = nums1[mp];
                        p--;
                        mp--;
                    }
                }
                break;
            }


            if (nums1[mp] >= nums2[np]) {
                nums1[p] = nums1[mp];
                p--;
                mp--;

            } else {
                nums1[p] = nums2[np];
                p--;
                np--;
            }

        }


    }


    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int p = 0;
        int mp = 0;
        int np = 0;
        while (true) {
            if (mp == m) {
                if (np < n) {
                    while (np < n) {
                        res[p] = nums2[np];
                        p++;
                        np++;
                    }
                }
                break;
            }
            if (np == n) {
                if (mp < m) {

                    while (mp < m) {
                        res[p] = nums1[mp];
                        p++;
                        mp++;
                    }
                }
                break;
            }
            if (nums1[mp] <= nums2[np]) {
                res[p] = nums1[mp];
                p++;
                mp++;

            } else {
                res[p] = nums2[np];
                p++;
                np++;
            }

        }
        nums1 = res;

    }

//    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4};
//        System.out.println(Arrays.toString(productExceptSelf(nums)));
//    }

    public static int[] productExceptSelf(int[] nums) {
        int[] resNums = new int[nums.length];
        int r = 1;
        resNums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            resNums[i] = nums[i - 1] * resNums[i - 1];
        }
        for (int i = nums.length - 1; i > 0; i--) {
            resNums[i] = resNums[i] * r;
            r = r * nums[i];
        }
        resNums[0] = r;
        return resNums;
    }

//    public static void main(String[] args) {
//        int[] gas = new int[]{1, 2, 3, 4, 5};
//        int[] cost = new int[]{3, 4, 5, 1, 2};
//        Learning learning = new Learning();
//        System.out.println(learning.canCompleteCircuit(gas, cost));
//    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int p = 0;
        int len = gas.length;
        if (len == 1) {
            if (gas[0] >= cost[0]) {
                return 0;
            } else {
                return -1;
            }
        }
        while (p < len) {
            if (gas[p] > cost[p]) {
                int residue = 0;
                int p1 = p;
                while (true) {
                    if (p1 >= p + len) {
                        return p;
                    }
                    int index = p1 % len;
                    if (gas[index] + residue >= cost[index]) {
                        residue += (gas[index] - cost[index]);
                        p1++;
                    } else {
                        break;
                    }
                }
            }
            p++;
        }
        return -1;
    }

//    public static void main(String[] args) {
//        int[] ratings = new int[]{1, 3, 2, 2, 1};
//        Learning learning = new Learning();
//        System.out.println(learning.candy2(ratings));
//    }

    public int candy(int[] ratings) {
        int count = ratings[0];
        int minLevel = 0;
        int res = 0;
        ratings[0] = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > count) {
                count = ratings[i];
                ratings[i] = ratings[i - 1] + 1;
            } else if (ratings[i] == count) {
                count = ratings[i];
                ratings[i] = ratings[i - 1];
            } else {
                count = ratings[i];
                ratings[i] = ratings[i - 1] - 1;
                minLevel = Math.min(minLevel, ratings[i]);
            }
        }
        for (int rating : ratings) {
            res = res + rating - minLevel + 1;
        }
        return res;
    }


    public int candy2(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc++;
            } else {
                dec++;
                if (inc == dec) {
                    dec++;
                }
                pre = 1;
                ret += dec;
            }
        }
        return ret;
    }


//    public static void main(String[] args) {
//        int[] ratings = new int[]{4, 2, 0, 3, 2, 5};
//        Learning learning = new Learning();
//        System.out.println(learning.trap(ratings));
//    }

    public int trap(int[] height) {
        int[] beforeLargest = new int[height.length];
        beforeLargest[0] = 0;
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            max = Math.max(max, height[i - 1]);
            beforeLargest[i] = max;
        }
        int right = height[height.length - 1];
        int res = 0;
        for (int i = height.length - 2; i >= 1; i--) {
            right = Math.max(right, height[i + 1]);
            int min = Math.min(beforeLargest[i], right);

            res = res + (min > height[i] ? min - height[i] : 0);

        }
        return res;
    }

//    public static void main(String[] args) {
//
//        int num = 6;
//        int i = 0;
//        int j = 0;
//        for (int i1 = 0; i1 < num; i1++) {
//            System.out.println(i++ + "  " + ++j);
//        }
//    }

    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        Set<String> set = new HashSet<>(

        );
        Iterator<String> iterator = set.iterator();
        List<String> wordList = Arrays.asList(s.split("\\s+"));

        Collections.reverse(wordList);

        String join = String.join(" ", wordList);
        return join;
    }
//
//    public static void main(String[] args) {
//
//        String s = "PAYPALISHIRING";
////        PAYP ALIS HIRI NG
//        Learning l = new Learning();
//        System.out.println(l.convert(s, 4));
//
//    }

    public String convert(String s, int numRows) {
        int group = (numRows * 2) - 2;
        int count;
        int length;
        if (s.length() % group == 0) {
            count = s.length() / group;
            length = s.length();
        } else {
            count = (s.length() / group) + 1;
            length = count * group;
        }


        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i < length; i++) {
            int deep = i % count;
            int breadth = i / count;
            if (breadth == 0 || breadth == length / count) {
            }
            int index = (deep * group) + breadth;
            if (index < s.length()) {
                char c = s.charAt(index);
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

//    public static void main(String[] args) {
//
//        String s = "vaaabbab";
////        PAYP ALIS HIRI NG
//        Learning l = new Learning();
//        System.out.println(l.strStr(s, "aaabbab"));
//
//    }

    // KMP 算法
    // ss: 原串(string)  pp: 匹配串(pattern)
    public int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }

        return -1;
    }
//
//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.climbStairs(new
//                 int{1,2,3,1}));
//
//    }

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.rob(new
//                int[]{2, 1, 1, 2}));
//    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {

                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }

        }
        return dp[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
//
//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.coinChange2(new int[]{1, 2, 5}, 11));
//    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int coin : coins) {
            set.add(coin);
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);


        for (int i = 1; i <= amount; i++) {
            if (set.contains(i)) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j < i / 2; j++) {
                if (dp[j] != -1 && dp[i - j] != -1) {
                    int b = dp[j] + dp[i - j];
                    if (dp[i] != -1) {
                        dp[i] = Math.min(dp[i], b);
                    } else {
                        dp[i] = b;
                    }
                }
            }
        }
        return dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];


        Arrays.fill(dp, amount + 1);

        for (int coin : coins) {
            if (coin < dp.length) {
                dp[coin] = 1;
            }
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin < i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }
//
//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
//    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (num > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }

        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];

        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }


//    public static void main(String[] args) {
//        Learning l = new Learning();
//        List<List<Integer>> triangle = new ArrayList<>();
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(2);
//        triangle.add(list1);
//
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(3);
//        list2.add(4);
//        triangle.add(list2);
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(6);
//        list3.add(5);
//        list3.add(7);
//        triangle.add(list3);
//        List<Integer> list4 = new ArrayList<>();
//        list4.add(4);
//        list4.add(1);
//        list4.add(8);
//        list4.add(3);
//        triangle.add(list4);
//        System.out.println(l.minimumTotal(triangle));
//    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int[] nums = new int[triangle.size()];
        nums[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            int util = nums[0];
            nums[0] = triangle.get(i).get(0) + nums[0];
            int i1 = 1;
            for (; i1 < triangle.get(i).size() - 1; i1++) {
                int count = Math.min(util, nums[i1]);
                util = nums[i1];
                nums[i1] = count + triangle.get(i).get(i1);
            }
            nums[i1] = util + triangle.get(i).get(i1);

        }
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
        }
        return min;
    }


//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.minPathSum(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}}));
//    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.uniquePathsWithObstacles(new int[][]{new int[]{0, 1}, new int[]{0, 0}}));
//    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1 && dp[i - 1][0] != 0) {
                dp[i][0] = 1;
            }
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
//
//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.longestPalindrome3("babad"));
//    }

    public String longestPalindrome(String s) {
        int max = 0;
        int p = 0;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(s.length() - 1 - j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] >= max) {
                        max = dp[i + 1][j + 1];
                        p = i;
                    }
                }
            }
        }

        return s.substring(p - max + 1, p + 1);
    }


    public String longestPalindrome2(String s) {
        int max = 0;
        int p = 0;
        if (s.length() >= 1) {
            max = 1;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (((right - left) + 1) > max) {
                        max = (right - left) + 1;
                        p = right;
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (s.charAt(i) == s.charAt(i + 1)) {
                left = i;
                right = i + 1;

                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        if (((right - left) + 1) > max) {
                            max = (right - left) + 1;
                            p = right;
                        }
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            }
        }
        return s.substring(p - max + 1, p + 1);
    }

//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.longestPalindrome3("cbbd"));
//    }

    public String longestPalindrome3(String s) {
        int max = 0;
        int p = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];
        if (s.length() < 2) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(1) == s.charAt(0)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            if (max < 1) {
                max = 1;
                p = i;
            }
        }


        for (int L = 2; L <= dp.length; L++) {
            for (int l = 0; l < dp[0].length; l++) {
                int r = l + L - 1;
                if (r >= dp.length) {
                    break;
                }


                if (s.charAt(l) == s.charAt(r)) {

                    if (L < 3) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }

                } else {
                    dp[l][r] = false;
                }
                if (dp[l][r] && L > max) {
                    max = L;
                    p = r;
                }

            }
        }
        return s.substring(p - max + 1, p + 1);
    }
//
//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len = Math.max(s1.length(), s2.length());
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[len + 1][len + 1];
        dp[0][0] = true;

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }

            }
        }

        return dp[s1.length()][s2.length()];
    }


    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }

    //    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.maxProfit4(new int[]{7, 6, 4, 3, 1}));
//    }
//
//    public int maxProfit4(int[] prices) {
//
//    }
//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.maximalSquare(new char[][]{new char[]{'1', '0', '1', '0', '0'}, new char[]{'1', '0', '1', '1', '1'}, new char[]{'1', '1', '1', '1', '1'}, new char[]{'1', '0', '0', '1', '0'}}));
//    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = Math.max(max, dp[i][0]);
            }
            for (int j = 1; j < dp[i].length; j++) {
                if (matrix[i][j] == '1') {
                    if (dp[i - 1][j] > 0 && dp[i][j - 1] > 0) {

                        if (dp[i - 1][j] == dp[i][j - 1]) {
                            if (matrix[i - dp[i - 1][j]][j - dp[i - 1][j]] == '1') {
                                dp[i][j] = dp[i - 1][j] + 1;
                            } else {
                                dp[i][j] = dp[i - 1][j];
                            }

                        } else {
                            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                        }
                    } else {
                        dp[i][j] = 1;
                    }

                }
                max = Math.max(max, dp[i][j]);

            }

        }
        return max * max;
    }

//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.isPalindrome("ab2a"));
//    }


    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        if (s.length() < 2) {
            return true;
        }
        while (l <= r) {
            if (!(Character.isLetter(s.charAt(l)) || Character.isDigit(s.charAt(l)))) {
                l++;
            } else if (!(Character.isLetter(s.charAt(r)) || Character.isDigit(s.charAt(r)))) {
                r--;
            } else {
                char left = Character.toLowerCase(s.charAt(l));
                char right = Character.toLowerCase(s.charAt(r));
                if (left != right) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;

    }

//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.isSubsequence("axc", "ahbgdc"));
//    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0;
        int p = 0;
        while (i < s.length()) {
            while (p <= t.length()) {
                if (p == t.length()) {
                    return false;
                } else {
                    if (s.charAt(i) == t.charAt(p++)) {
                        break;
                    }

                }
            }
            i++;
        }
        return true;
    }

//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(Arrays.toString(l.twoSum(new int[]{2, 7, 11, 15}, 9)));
//    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            }

        }
        return res;
    }

//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));
//    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            max = Math.max((r - l) * Math.min(height[l], height[r]), max);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.threeSum(new int[]{0, 0, 0, 0}));
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> list = new ArrayList<>();
        for (int l = 0; l < nums.length - 2; ) {

            for (int r = nums.length - 1; r >= l + 2; ) {
                int left = l + 1;
                int right = r - 1;
                int p = (left + right + 1) / 2;
                while (left <= right) {
                    if (left == right) {
                        if (nums[l] + nums[r] + nums[p] == 0) {
                            List<Integer> num = new ArrayList<>();
                            num.add(nums[l]);
                            num.add(nums[p]);
                            num.add(nums[r]);
                            list.add(num);
                        }
                        break;
                    }
                    if (nums[l] + nums[r] + nums[p] == 0) {
                        List<Integer> num = new ArrayList<>();
                        num.add(nums[l]);
                        num.add(nums[p]);
                        num.add(nums[r]);
                        list.add(num);
                        break;
                    } else if (nums[l] + nums[r] + nums[p] > 0) {
                        right = p - 1;
                    } else {
                        left = p;
                    }
                    p = (left + right + 1) / 2;
                }


                while (nums[r] == nums[r - 1] && r > l + 2) {
                    r--;
                }
                r--;
            }
            while (nums[l] == nums[l + 1] && l < nums.length - 2) {
                l++;
            }
            l++;
        }
        return list;
    }

//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
//    }

    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int res = length + 1;
        if (nums.length < 1) {
            return 0;
        }
        int num = 0;
        int l = 0;
        int r = 0;
        while (r < length) {
            num += nums[r];
            while (num >= target) {
                res = Math.min(res, r - l + 1);
                num -= nums[l];
                l++;
            }
            r++;
        }
        return res == length + 1 ? 0 : res;
    }

//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.lengthOfLongestSubstring("tmmzuxt"));
//    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int start = 0;
        int end = 0;

        while (end < chars.length) {
            if (map.containsKey(chars[end]) && map.get(chars[end]) >= start) {
                start = map.get(chars[end]) + 1;
                map.put(chars[end], end);
            } else {
                res = Math.max(res, end - start + 1);
                map.put(chars[end], end);
            }
            end++;
        }
        return res;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();

        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }
//
//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.minWindow("ADOBECODEBANC", "ABC"));
////        BANC
//    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            set.add(t.charAt(i));
        }
        int min = s.length() + 1;
        int p = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }


            if (map.isEmpty()) {
                min = Math.min(min, r - l + 1);
                p = r;
                boolean haveOne = false;
                while (l < r) {
                    if (set.contains(s.charAt(l))) {
                        if (haveOne) {
                            break;
                        } else {
                            min = Math.min(min, r - l + 1);
                            haveOne = true;
                            map.put(s.charAt(l), 1);
                        }
                    }
                    l++;
                }
            }

            r++;
        }

        return min == s.length() + 1 ? "" : s.substring(p - min + 1, p + 1);
    }

//
//    public static void main(String[] args) {
//        Learning l = new Learning();
//        System.out.println(l.isValidSudoku(
//                new char[][]{
//                        new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
//                        new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                        new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                        new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                        new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                        new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                        new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                        new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                        new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
//                }
//        ));
//
//    }

    public boolean isValidSudoku(char[][] board) {
//        判断每一行
        int[][] set3 = new int[9][9];
        for (int i = 0; i < 9; i++) {
            int[] set1 = new int[9];
            int[] set2 = new int[9];

            for (int j = 0; j < 9; j++) {
//        判断每一列
                char c = board[i][j];
                if (c != '.') {
                    int c1 = c - '1';
                    if (set1[c1] == 1) {
                        return false;
                    } else {
                        set1[c1] = 1;
                    }

//                    每一个九宫格
                    int num = (i / 3) * 3 + (j / 3);
                    if (set3[num][c1] == 1) {
                        return false;
                    } else {
                        set3[num][c1] = 1;
                    }


                }
//        判断每一行
                char c2 = board[j][i];
                if (c2 != '.') {
                    int c3 = c2 - '1';
                    if (set2[c3] == 1) {
                        return false;
                    } else {
                        set2[c3] = 1;
                    }
                }


            }

        }


        return true;
    }

    public static void main(String[] args) {
        Learning l = new Learning();
        System.out.println(l.spiralOrder(
                new int[][]{
                        new int[]{1, 2, 3, 4},
                        new int[]{5, 6, 7, 8},
                        new int[]{9, 10, 11, 12},
                        new int[]{13, 14, 15, 16}
                }));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}
