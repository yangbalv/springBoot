package com.springboot.live_comm.coding.leetcode.fouthyue;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lengthOfLongestSubstringTest() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int p = 0;

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) + 1 > p) {
                    p = map.get(s.charAt(i)) + 1;
                }
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, (i + 1) - p);
        }
        return max;
    }

    @Test
    public void findMedianSortedArraysTest() {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        boolean b1 = false;
        boolean b2 = false;
        int count = (nums1.length + nums2.length + 1) / 2;
        if (nums1[nums1.length - 1] <= nums2[0]) {
            b1 = true;
        } else if (nums2[nums2.length - 1] <= nums1[0]) {
            b2 = true;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            if (b1) {
                if (nums1.length >= count) {
                    return nums1[(count) - 1];
                } else {
                    return nums2[(count) - nums1.length - 1];
                }
            } else if (b2) {
                if (nums2.length >= count) {
                    return nums2[(count) - 1];
                } else {
                    return nums1[(count) - nums2.length - 1];
                }
            } else {
                while ((p1 + 1 + p2 + 1) <= count) {
                    if (nums1[p1] <= nums2[p2] && p1 < count) {
                        p1++;
                        if ((p1 + 1 + p2 + 1) == count) {
                            return nums1[p1];
                        }
                    } else {
                        p2++;
                        if ((p1 + 1 + p2 + 1) == count) {
                            return nums1[p2];
                        }
                    }

                }

            }
        } else {
            double num1 = 0d;
            double num2 = 0d;
            if (b1) {
                if (nums1.length >= count) {
                    num1 = nums1[(count) - 1];
                } else {
                    num1 = nums2[(count) - nums1.length - 1];
                }
                if (nums1.length >= count + 1) {
                    num2 = nums1[(count)];
                } else {
                    num2 = nums2[(count) - nums1.length];
                }

            } else if (b2) {
                if (nums2.length >= count) {
                    num1 = nums2[(count) - 1];
                } else {
                    num1 = nums1[(count) - nums2.length - 1];
                }
                if (nums2.length >= count + 1) {
                    num2 = nums2[(count)];
                } else {
                    num2 = nums1[(count) - nums2.length];
                }

            } else {
            }
            return (num1 + num2) / 2D;
        }
        return 0;
    }
}