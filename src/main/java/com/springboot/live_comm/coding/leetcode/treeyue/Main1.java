package com.springboot.live_comm.coding.leetcode.treeyue;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String require = in.nextLine();

        String hotel = in.nextLine();

        String[] s = require.split(" ");
        int k = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);


        String[] cost = hotel.split(" ");
        int[] costx = new int[cost.length];
        for (int ix = 0; ix < cost.length; ix++) {
            costx[ix] = Integer.parseInt(cost[ix]);
        }
        Arrays.sort(costx);
        int[] res = new int[k];
        int i = 0;
        for (; i < costx.length; i++) {
            int num = costx[i];
            if (num > x) {
                break;
            }
        }
        if (i == costx.length) {
            for (int j = 0; j < k; j++) {
//                res.add(cost[cost.length - j]);
                res[j] = costx[costx.length - j - 1];
            }
        } else {

            int l = i - 1;
            int r = i;
            for (int i1 = 0; i1 < k; i1++) {
                if (l >= 0 && r < costx.length) {
                    if (x - costx[l] <= costx[r] - x) {
                        res[i1] = costx[l];
                        l--;
                    } else {
                        res[i1] = costx[r];
                        r++;
                    }

                } else if (r == costx.length) {
                    res[i1] = costx[l];
                    l--;
                } else {
                    res[i1] = costx[r];
                    r++;
                }
            }

        }
        Arrays.sort(res);
        for (int i2 = 0; i2 < res.length; i2++) {
            System.out.printf("%d ", res[i2]);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
