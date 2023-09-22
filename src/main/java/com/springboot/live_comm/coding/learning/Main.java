package com.springboot.live_comm.coding.learning;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<String, Integer> strs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < 8; j++) {
                String s = input.next();
                str += s;
            }
            if (i == 0) {
                System.out.println(1);
                strs.put(str, 1);
            } else {
                if (strs.containsKey(str)){
                    strs.put(str, strs.get(str) + 1);
                }else {
                    strs.put(str,1);
                }
                System.out.println(strs.get(str));
            }
        }
    }


}