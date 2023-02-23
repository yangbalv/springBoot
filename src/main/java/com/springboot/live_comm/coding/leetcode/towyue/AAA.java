package com.springboot.live_comm.coding.leetcode.towyue;

import java.util.ArrayList;
import java.util.List;

public class AAA {
    public static void main(String[] args) {
        AAA aaa = new AAA();
        System.out.println(aaa.generate(6));
    }

    //    爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
//    爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。
//    在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
//    游戏一直持续到所有石子都被拿走。
//    假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。
//    输入：piles = [2,7,9,4,4]
//    输出：10
//    解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
//
    public int stoneGameII(int[] piles) {
        return 0;

    }

    //        给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//        在「杨辉三角」中，每个数是它左上方和右上方的数的和。
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> util = new ArrayList<>();
        util.add(1);
        res.add(util);
        if (numRows == 1) {
            return res;
        }
        List<Integer> util1 = new ArrayList<>();
        util1.add(1);
        util1.add(1);
        res.add(util1);
        if (numRows == 2) {
            return res;
        }
        int right;
        for (int i = 2; i < numRows; i++) {
            int left = 0;
            List<Integer> nextList = new ArrayList<>();
            for (Integer integer : res.get(i - 1)) {
                right = integer;
                int num = left + right;
                nextList.add(num);
                left = integer;
            }

            nextList.add(1);
            res.add(nextList);

        }
        return res;
    }
//    给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//    匹配任意单个字符
//    匹配零个或多个前面的那一个元素
//    所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
    public boolean isMatch(String s, String p) {
        return s.matches(p);

    }
}
