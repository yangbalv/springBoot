package com.springboot.live_comm.coding.learning;

public class CompleteKnapsack {
    public static void main(String[] args) {  
        int[] weights = {2, 3, 4, 5};  
        int[] values = {3, 4, 5, 6};  
        int capacity = 8;  
        System.out.println(maxValue(weights, values, capacity));  
    }  
  
    public static int maxValue(int[] weights, int[] values, int capacity) {  
        int n = weights.length;  
        int[][] dp = new int[n + 1][capacity + 1];  
        for (int i = 0; i <= n; i++) {  
            for (int j = 0; j <= capacity; j++) {  
                dp[i][j] = 0;  
            }  
        }  
        for (int i = 1; i <= n; i++) {  
            for (int j = weights[i - 1]; j <= capacity; j++) {  
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weights[i - 1]] + values[i - 1]);  
            }  
        }  
        return dp[n][capacity];  
    }  
}