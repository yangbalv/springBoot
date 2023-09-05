package com.springboot.live_comm.coding.learning;

import java.util.Arrays;

public class Learning {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int[] nums3 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums4 = new int[]{1, 1, 2};
        int[] nums5 = new int[]{-1, -100, 3, 99};
        int[] nums6 = new int[]{2, 0, 2, 4, 6, 0, 0, 3};
        int[] nums7 = new int[]{100};

        System.out.println(hIndex(nums7));
    }


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


}
