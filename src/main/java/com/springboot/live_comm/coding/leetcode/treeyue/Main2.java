package com.springboot.live_comm.coding.leetcode.treeyue;

import java.util.Arrays;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {

        int res = 0;
        Scanner in = new Scanner(System.in);
        String require = in.nextLine();

        String stem = in.nextLine();

        String[] s = require.split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);

        String[] power = stem.split(" ");
        int[] powerx = new int[power.length];
        for (int ix = 0; ix < power.length; ix++) {
            powerx[ix] = Integer.parseInt(power[ix]);
        }
        Arrays.sort(powerx);

        boolean have = false;
        for (int i = 0; i < powerx.length - 1; i++) {
            if (powerx[i + 1] - powerx[i] < d) {
                have = true;
                res += powerx[i + 1] - powerx[i];
                i++;
            }
        }
        if (have) {
            System.out.printf("%d", res);
        } else {
            res = -1;
            System.out.printf("%d", res);
        }

    }
}