package com.springboot.live_comm.coding.leetcode.treeyue;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        int res = 0;
//
//        Scanner in = new Scanner(System.in);
//
//        String require = in.nextLine();
//        String[] s = require.split(" ");
//        int width = Integer.parseInt(s[0]);
//        int len = Integer.parseInt(s[1]);
//        String[][] all = new String[width][len];
//        for (int i = 0; i < width; i++) {
//            String read = in.nextLine();
//            String[] status = read.split(" ");
//            all[i] = status;
//        }
//
//        for (int i = 0; i < all.length; i++) {
//            String[] strings = all[i];
//            for (int j = 0; j < strings.length; j++) {
//                if (all[i][j].equals("1")) {
//                    clean(all, i, j);
//                    res++;
//                }
//
//            }
//
//        }
//        System.out.printf("%d", res);
//    }
//
//    public static void clean(String[][] all, int x, int y) {
//
//        if ((0 <= x && x < all.length) && (0 <= y && y < all[0].length)) {
//            if (all[x][y].equals("1")) {
//                all[x][y] = "0";
//                clean(all, x + 1, y);
//                clean(all, x + 1, y + 1);
//                clean(all, x + 1, y - 1);
//                clean(all, x, y + 1);
//                clean(all, x, y - 1);
//                clean(all, x - 1, y);
//                clean(all, x - 1, y + 1);
//                clean(all, x - 1, y - 1);
//            }
//
//        }
//    }
//
//}
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//
//        int res = 0;
//        Scanner in = new Scanner(System.in);
//        String require = in.nextLine();
//
//        String stem = in.nextLine();
//
//        String[] s = require.split(" ");
//        int n = Integer.parseInt(s[0]);
//        int d = Integer.parseInt(s[1]);
//
//        String[] power = stem.split(" ");
//        int[] powerx = new int[power.length];
//        for (int ix = 0; ix < power.length; ix++) {
//            powerx[ix] = Integer.parseInt(power[ix]);
//        }
//        Arrays.sort(powerx);
//
//        boolean have = false;
//        for (int i = 0; i < powerx.length - 1; i++) {
//            if (powerx[i + 1] - powerx[i] < d) {
//                have = true;
//                res += powerx[i + 1] - powerx[i];
//                i++;
//            }
//        }
//        if (have) {
//            System.out.printf("%d", res);
//        } else {
//            res = -1;
//            System.out.printf("%d", res);
//        }
//
//    }
//}


import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        int res = 0;
        Scanner in = new Scanner(System.in);
        String require = in.nextLine();

        String stem = in.nextLine();

        String[] s = require.split(" ");
        int d = Integer.parseInt(s[1]);

        String[] power = stem.split(" ");
        int[] powerx = new int[power.length];
        for (int ix = 0; ix < power.length; ix++) {
            powerx[ix] = Integer.parseInt(power[ix]);
        }
        Arrays.sort(powerx);
//        System.out.println(Arrays.toString(powerx));

        boolean have = false;
        for (int i = 0; i < powerx.length - 1; i++) {
            if (powerx[i + 1] - powerx[i] <= d) {
                have = true;
                if (i + 2 < powerx.length) {
                    if (i + 3 < powerx.length) {

                        if (powerx[i + 1] - powerx[i] > powerx[i + 2] - powerx[i + 1] && powerx[i + 3] - powerx[i + 2] > d) {
                            res += (powerx[i + 2] - powerx[i + 1]);
                            i = i + 2;
                        } else {
                            res += (powerx[i + 1] - powerx[i]);
                            i = i + 1;
                        }

                    } else {
                        if (powerx[i + 1] - powerx[i] > powerx[i + 2] - powerx[i + 1]) {
                            res += (powerx[i + 2] - powerx[i + 1]);
                            i = i + 2;
                        } else {
                            res += (powerx[i + 1] - powerx[i]);
                            i = i + 1;
                        }

                    }
                } else {
                    res += (powerx[i + 1] - powerx[i]);
                    i = i + 1;
                }

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



//
//import java.util.Arrays;
//        import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//
//        int res = 0;
//        Scanner in = new Scanner(System.in);
//        String require = in.nextLine();
//
//        String stem = in.nextLine();
//
//        String[] s = require.split(" ");
//        int d = Integer.parseInt(s[1]);
//
//        String[] power = stem.split(" ");
//        int[] powerx = new int[power.length];
//        for (int ix = 0; ix < power.length; ix++) {
//            powerx[ix] = Integer.parseInt(power[ix]);
//        }
//        Arrays.sort(powerx);
//
//        boolean have = false;
//        for (int i = 0; i < powerx.length - 1; i++) {
//            if (powerx[i + 1] - powerx[i] <= d) {
//                have = true;
//                res += powerx[i + 1] - powerx[i];
//                i++;
//            }
//        }
//        if (have) {
//            System.out.printf("%d", res);
//        } else {
//            res = -1;
//            System.out.printf("%d", res);
//        }
//
//    }
//}