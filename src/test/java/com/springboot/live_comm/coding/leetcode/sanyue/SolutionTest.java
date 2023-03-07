package com.springboot.live_comm.coding.leetcode.sanyue;

import freemarker.template.utility.StringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SolutionTest {
    @Test
    public void aa() {
        wei(100);
    }

    public void wei(int n) {

//        1100100
        for (int i = 0; i < n; i++) {
            System.out.println("n is: 00" + Integer.toBinaryString(n));
            System.out.println("i is: 00" + Integer.toBinaryString(i));
            System.out.println("& is: 00" + Integer.toBinaryString(n & i) );
            System.out.println("& is: " + (n & i));
            System.out.println("| is: 00" + Integer.toBinaryString(n | i) );
            System.out.println("| is: " + (n | i));

        }
//        1100011

    }
}