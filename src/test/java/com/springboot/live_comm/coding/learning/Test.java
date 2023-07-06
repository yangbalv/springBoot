package com.springboot.live_comm.coding.learning;

public class Test {
    //    问题描述： 求两个字符串 str1 和 str2 的"最长的"、"公共的"子字符串。
//
//    String str1 = "abc@12345%abcd";
//    String str2 = "abc%12345@abcd";
//
//    预期结果： 输出12345 （因为长度是最长的5， 比abcd 长）。
//            ============================================================

    public static void main(String[] args) {
        // 不需要从控台获取输入，直接写死：
        String str1 = "aaaabccc";
        String str2 = "aabcccc";

        String result = getMaxSubstring(str1, str2);

        // 打印出result 结果
        System.out.println("result = " + result);
    }

    //
//
    public static String getMaxSubstring(String str1, String str2) {

        String s1 = util(str1, str2);
        String s2 = util(str2, str1);
        if (s1.length() > s2.length()) {
            return s1;
        } else {
            return s2;
        }
    }

    public static String util(String str1, String str2) {
        String result = new String();
        int l1 = 0;
        int l2 = 0;
        int max = 0;

        int start = 0;
        int end = 0;
        while (l2 < str2.length()) {
            int aa = l1;
            while (l2 < str2.length()) {
                char c1 = str1.charAt(l1);
                System.out.println(c1);
                char c2 = str2.charAt(l2);
                System.out.println(c2);
                System.out.println();
                if (c1 == c2) {

                    l1++;
                    if (max > l1 - aa) {
                        start = aa;
                        max = l1 - aa;
                        end = l1 - 1;
                    }
                } else {
                        l1++;
                        break;
                }
                l2++;
            }

        }
        result = str1.substring(start, end);

        return result;
    }



}
