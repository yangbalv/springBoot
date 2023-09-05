package com.springboot.live_comm.coding.learning;

import java.util.Arrays;

public class KnapsackProblem {

    //解决0-1背包问题  
    public static int knapsack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        //构建K[][]表格  
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {


                int[] now = K[i];

                if (i == 0 || w == 0)
                    now[w] = 0;
                else {
                    int[] before = K[i - 1];
                    int nowVal = val[i - 1];
                    if (wt[i - 1] <= w) {

                        now[w] = Math.max(nowVal + before[w - wt[i - 1]], before[w]);
                    } else
                        now[w] = before[w];
                }
            }
        }
        for (int i1 = 0; i1 < K.length; i1++) {
            System.out.println(Arrays.toString(K[i1]));
        }

        return K[n][W];
    }
//    这个程序使用动态规划来解决0-1背包问题。其中，val[]是物品的价值数组，wt[]是物品的重量数组，W是背包的总重量，n是物品的数量。程序使用二维数组K[][]来保存状态，最终返回K[n][W]即可得到最大价值。

    public static void main(String args[]) {
        int val[] = new int[]{100, 20, 50, 25, 36, 44, 45, 62, 67, 88, 93};
        int wt[] = new int[]{10, 1, 100, 2, 3, 4, 5, 6, 7, 8, 9};
        int W = 30;
        int n = val.length;
        System.out.println(knapsack(W, wt, val, n)); //输出220  
    }
}