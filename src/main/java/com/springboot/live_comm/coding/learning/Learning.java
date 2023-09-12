package com.springboot.live_comm.coding.learning;

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

    public static void main(String[] args) {
        Learning l = new Learning();
        System.out.println(l.coinChange(new int[]{1, 2, 5}, 11));
    }

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
            for (int j = 1; j < i/2; j++) {
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
            for (int i1 = 0; i1 < coins.length; i1++) {

            }
            for (int j = 1; j < i/2; j++) {
                
                
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

//武汉农村商业银行信用卡用户积分奖励计划
//
//为提高武汉农村商业银行（以下简称“本行”）信用卡用户体验，方便信用卡用户更好地累计和使用积分本行特推出信用卡用户积分奖励计划（以下简称“本计划”），具体规则及条款如下(因微信银行、手机银行等渠道正在改造中，本积分奖励计划将于上述渠道延期更新公示，最新版本以官方网站公示为准)：
//
//一、积分参与资格
//本行发行的标准信用卡均可参加本计划，专项车位卡、专项装修卡、学生信用卡、美团联名卡、随用金卡等特殊卡种除外，具体以卡产品规定内容为准。
//
//二、积分规则
//（一）本行信用卡积分包括交易奖励积分和活动奖励积分：
//1.交易奖励积分为持卡人使用信用卡消费累计的积分，交易奖励积分按单笔消费入账金额计算，每消费人民币1元积1分，不满1元不计分。
//2.活动奖励积分是本行为鼓励持卡人特定消费、用卡或使用有关产品并符合奖励条件而额外奖励的积分，具体以活动说明为准。
//（二）持卡人持有多张本行信用卡时，信用卡积分账户依据客户信用卡账户数量为基础建立并进行管理。
//（三）每自然月交易奖励积分累计不超过账户固定额度的10倍。
//（四）积分计算日期为该笔消费的银行记账日。
//（五）积分不可转至其余的流通卡上或转赠其他持卡人。
//（六）如持卡人卡片存在挂失换卡、到期续卡等情况，原卡积分不变，积分使用需将新卡在本行网上商城或本行其他指定渠道绑定后，方可进行。
//（七）持卡人因任何原因将持卡交易购买的商品或服务退还、或因签账单争议、或其他原因退还原该笔消费款项的，本行将依照退还款项的金额扣除原先赠送的相应积分。
//（八）持卡人如有下述任一情形,本行有权取消其参加积分奖励计划的资格。
//1．所持信用卡账务存在逾期情况的；
//2．所持信用卡被停用、管制或其他卡片状态不正常的；
//3．信用卡账户已注销的；
//4．不偿还本行其他债务的；
//5．涉嫌利用非真实交易或其他不正当手段恶意套取积分的；
//6．违反《武汉农村商业银行信用卡章程（修订版）》、《武汉农村商业银行信用卡领用合约（修订版）》或其他相关规定的。
//7．如上述情形得到有效处理且信用卡恢复正常状态，经本行同意后方可继续参加本积分奖励计划，并恢复已累积的积分。
//
//三、积分有效期
//信用卡积分有效期固定为3年（奖励积分除外），过期日为每笔积分自积分产生日起，3年后的同月月底失效。积分逾期不兑换，将被取消。若信用卡账户关闭或注销，剩余积分将被清零，且无法恢复。
//
//四、积分累计范围
//（一）持卡人使用本行信用卡在餐饮、娱乐、宾馆、酒店、百货公司、其他零售商店等用于个人及家庭的日常刷卡消费，或通过参加本行相关营销活动获得的可累积的积分。但下列项目不予计算积分：
//1．信用卡章程或领用合约规定的各项利息和手续费用，包括但不限于年费、预借现金手续费、透支利息、分期手续费、违约金等；
//2．信用卡取现及溢缴款领回、存（还）款、转账、分期业务等;
//3．网络支付交易（指定渠道除外）；
//4．特定类别消费，包括但不限于房地产、汽车销售、批发类交易、医院、学校、各类公共事业费缴费或代扣代缴业务以及慈善和社会服务等非盈利性行业的商户消费以及金融和政府类支持交易（如保险、投资、纳税、罚款）；
//（二）不参与本行信用卡积分累计的详细商户类别代码及商户类别名称，依据商户管理机构下发的标准，本行进行认定及调整，具体以我行官方渠道《不累积积分的商户列表》公示为准。如因收单行或商户错误使用商户类别而影响积分累计的，本行不承担相关责任。
//
//五、积分查询
//（一）信用卡账单。账单中显示持卡人账户截至账单日的信用卡积分；
//（二）客服中心。持卡人可致电本行客户服务电话95367查询积分；
//（三）信用卡微信银行。持卡人通过本行信用卡官方微信公众号，点击“微银行”进入“业务办理大厅”中的“积分查询”，可查询绑定的信用卡所对应卡号的积分；
//（四）手机银行。持卡人登录本行手机银行，绑定信用卡，可通过“我的积分”模块查询；
//（五）信用卡网上商城。持卡人通过本行信用卡网上商城查询绑定的信用卡所对应卡号的积分。
//（六）本行将根据业务发展，对积分查询渠道进行调整、补充或完善，具体以本行官方渠道公示为准。
//
//六、积分兑换
//（一）持卡人可在本行网上商城或本行其他指定渠道进行积分兑换。
//（二）持卡人成功兑换积分礼品后，本行将从持卡人的积分账户中扣减相应积分分值，且不可取消及更改。如持卡人账户积分不足，则不予兑换。
//（三）申请兑换是否成功将视持卡人积分是否足够扣减、礼品库存情况确定。
//（四）兑换公告或目录中载有有效期的积分礼品到期后不得继续兑换。
//（五）本行有权要求持卡人提供消费交易发票、购买凭证等材料，以查实交易真实性；如持卡人无法提交相关材料，本行有权不予兑换；一旦查实持卡人为虚假交易获取积分兑换套利的，本行有权采取冻结积分、积分清零、冻结卡片使用、销卡等措施，并保留进一步追索的权利；如前述行为可能构成犯罪的，本行有权向公安机关报案并向司法机关提供相关资料和信息。
//
//七、其他
//（一）信用卡积分为本行对持卡人消费的回馈项目，在兑换取得积分礼品前并不构成持卡人资产。积分不可转让给其他持卡人或任何第三人，任何转让对本行均不产生效力。未经本行同意，积分不能折算现金或给予其它非积分礼品的给付。
//（二）本行与积分礼品运营商间并无合伙、经销、代理关系或共同出卖人、广告媒体或保证人关系。持卡人所兑换礼品由各供应商提供，其质量、数量、款式、颜色售后服务等问题均由运营商负责。如持卡人对运营商提供的礼品和售后服务有争议时，本行负责协助持卡人与运营商取得联系。本行保证有其选择或指定的运营商具有法律、法规规定的相关资质。
//（三）本行保留对计积分项及兑换比例的调整权，并在法律许可的范围内保留解释权。
//（四）本行有权根据需要取消或修改相关规则（包括但不限于参加资格、计分规则、礼品及兑换标准等），并经相关途径(如本行网站、对账单、短信、微信、报刊或各分支网点等)公告后生效，不再另行通知持卡人。
//（五）本计划于公式之日起正式生效，如有疑问，请致电95367咨询，感谢您长期以来对武汉农村商业银行的信任与支持！
//
//
//不累积积分的商户列表
//序号	类别	商户类别代码	商户类别名称
//1 	出租和租赁服务	4468	船舶、海运服务提供商
//2 	房地产业	1520	一般承包商－住宅与商业楼
//3 		6542	房产租赁代理、经纪
//4 		7013	不动产代理－房地产经纪
//5 	纺织、服装及日用品专门零售店	5971	艺术商和画廊
//6 	家用电器及电子产品专门零售	4812	通讯设备和电话销售
//7 		5722	家电
//8 	交通运输、物流和仓储服务	4011	铁路运输
//9 		4111	本地和市郊通勤旅客运输（包括轮渡）
//10 		4112	铁路客运
//11 		4121	出租车服务
//12 		4131	公路客运
//13 		4214	货物搬运和托运—当地和长途，移动和存储公司，以及当地递送服务
//14 		4215	快递服务（空运、地面运输或海运）
//15 		4784	路桥通行费
//16 		4789	未列入其他代码的运输服务
//17 		9402	国家邮政服务
//18 		4511	航空公司、航空客票销售
//19 		3998	国家铁路总公司
//20 	教育	8211	中小学校（公立）
//21 		8220	普通高校（公立）
//22 		8241	函授学校（成人教育）
//23 		8244	商业和文秘学校（中等专业学校）
//24 		8249	贸易和职业学校（职业技能培训）
//25 		8299	其他学校和教育服务
//26 		8351	儿童保育服务（含学前教育）
//27 	金融业	5933	当铺
//28 		6010	金融机构－人工现金支付
//29 		6011	金融机构－自动现金支付
//30 		6051	非金融机构－外币兑换、非电子转帐的汇票、临时支付凭证和旅行支票
//31 		6211	证券公司－经纪人和经销商
//32 		6300	保险销售、保险业和保险金
//33 		6761	立码付
//34 		6541	融资租赁
//35 		9498	信用卡还款业务
//36 	居民服务	4900	公共事业（电力、煤气、自来水、清洁服务）
//37 		7221	照相馆
//38 		7230	理发店
//39 		7295	家政服务
//40 		7299	未列入其他代码的个人服务（其他房地产服务）
//41 		7523	停车场
//42 	批发商户	4458	烟草配送
//43 		5013	机动车供应及零配件（批发商）
//44 		5021	办公及商务家具（批发商）
//45 		5039	未列入其他代码的建材批发（批发商）
//46 		5044	办公、影印及微缩摄影器材（批发商）
//47 		5045	计算机、计算机外围设备（批发商）
//48 		5046	未列入其他代码的商用器材（批发商）
//49 		5047	牙科/实验室/医疗/眼科医院器材和用品（批发商）
//50 		5051	金属产品服务商和公司（批发商）
//51 		5065	电器零件和设备（批发商）
//52 		5072	五金器材及用品（批发商）
//53 		5074	管道和供暖设备（批发商）
//54 		5111	文具、办公用品、复印纸和书写纸（批发商）
//55 		5122	药品、药品经营者（批发商）
//56 		5131	布料、缝纫用品和其他纺织品（批发商）
//57 		5137	男女及儿童制服和服装（批发商）
//58 		5139	鞋类（批发商）
//59 		5172	石油及石油产品（批发商）
//60 		5192	书、期刊和报纸（批发商）
//61 		5193	花木栽种用品、苗木和花卉（批发商）
//62 		5198	油漆、清漆用品（批发商）
//63 		5398	大型企业批发
//64 		5998	其他批发商
//65 	汽车、摩托车、燃料及零配件专门零售	5271	活动房车经销商
//66 		5511	汽车货车经销商－新旧车的销售、服
//67 		5521	汽车货车经销商－专门从事旧车的销售、服务、维修、零件及出租
//68 		5532	汽车轮胎经销商
//69 		5533	汽车零配件商店
//70 		5541	加油站、服务站
//71 		5542	自助加油站
//72 		5551	船只经销商
//73 		5561	旅行拖车、娱乐用车销售商
//74 		5571	摩托车商店和经销商
//75 		5592	露营、房车销售商
//76 		5598	雪车商
//77 		5599	汽车、飞行器、农用机车综合经营商
//78 		5983	燃料经销商－燃油、木材、煤炭和液化石油
//79 	商业服务	763	农业合作
//80 		5935	海上船只遇难救助
//81 		7276	税收准备服务
//82 		7277	咨询服务—债务、婚姻和个人私事
//83 		7278	购物服务及会所（贸易、经纪服务）
//84 		7311	广告服务
//85 		7321	消费者信用报告机构
//86 		7333	商业摄影服务
//87 		7392	管理、咨询和公共关系服务
//88 		7399	未列入其他代码的商业服务
//89 		8675	汽车协会
//90 		8911	建筑、工程和测量服务
//91 		8912	装修、装潢、园艺
//92 		8931	会计、审计、财务服务
//93 	社会组织	8641	市民、社会及友爱组织
//94 		8651	政治组织（政府机构）
//95 		8661	宗教组织
//96 		8699	其他会员组织
//97 	维修及其他专业服务	6513	不动产管理－物业管理
//98 		7531	车体维修店
//99 		7538	汽车服务商店
//100 		8999	未列入其它代码的其他专业服务
//101 	卫生	8011	其他医疗卫生活动
//102 		8021	牙科医生
//103 		8031	正骨医生
//104 		8041	按摩医生
//105 		8042	眼科医生
//106 		8049	手足病医生
//107 		8050	护理和照料服务
//108 		8062	公立医院
//109 		8071	医学及牙科实验室
//110 		8099	其他医疗保健服务
//111 	文化、体育用品及器材专门零售	5994	报亭、报摊
//112 	五金、家具及室内装修材料专门零售	5211	木材和各类建材卖场
//113 		5231	玻璃、油漆、壁纸商店
//114 		5251	五金商店
//115 		5712	家具、家用设备零售商
//116 		5713	地板商店
//117 		5714	帏帐、窗帘、室内装潢商店
//118 		5719	各种家庭装饰专营店
//119 	信息与计算机服务	4814	电信服务，包括本地和长途电话、信用卡电话、磁卡电话和传真
//120 		4816	计算机网络/信息服务
//121 		4899	有线和其他付费电视服务
//122 		7372	计算机编程、数据处理和系统集成设计服务
//123 	医药和医疗器材专门零售	5912	药房、药店
//124 	政府服务与公用事业	8398	慈善和社会公益服务组织
//125 		9211	法庭费用，包括赡养费和子女抚养费
//126 		9222	罚款
//127 		9223	保释金
//128 		9311	纳税
//129 		9399	未列入其他代码的政府服务（社会保障服务，国家强制）
//130 		9312	房地产交易相关税
//131 		9400	使领馆收费
//132 	直销商户	5960	保险直销
//133 		5963	门对门销售
//134 		5969	其他直销商户
//135 	住宿、餐饮和休闲娱乐业	4733	大型景区售票
//136 		7012	分时度假房地产
//137 		7995	彩票销售
//138 	其他	4829	邮政服务（电报、汇款）
//139 		6013	金融机构－商品和服务
//140 		6016	网上保费代缴
//141 		8399	非盈利事业
//142 		9411	政府贷款
//143 		9704	县乡优惠—房产汽车类
//144 		9705	县乡优惠—批发类
//145 		9706	县乡优惠—超市加油类
//146 		9707	县乡优惠—一般商户类
//147 		9708	县乡优惠—三农商户类
//148 	境外其他商户	743	葡萄酒制造商
//149 		744	香槟酒制造商
//150 		1799	合同商
//151 		5085	工业用品
//152 		5099	耐用品
//153 		5169	化学及合成物
//154 		5199	非耐用品
//155 		5531	汽车商店、家庭用品商店
//156 		5715	酒精饮料批发商
//157 		7280	私人医院
//158 		9405	各国政府内部购买
//159 		9950	公司内部购买
}
