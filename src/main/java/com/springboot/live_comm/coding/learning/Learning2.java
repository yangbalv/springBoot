package com.springboot.live_comm.coding.learning;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Learning2 {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {

                if (stack.empty() || stack.pop() != map.get(s.charAt(i))) {
                    return false;
                }
            } else {
                stack.add(s.charAt(i));
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }

    }

//    public static void main(String[] args) {
//        Learning2 l2 = new Learning2();
//        System.out.println(l2.simplifyPath("/a/./b/../../c/"));
//
//    }

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : split) {
            if (s == null || s.length() == 0) {
            } else if (s.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }

            } else if (s.equals(".")) {

            } else {
                stack.push(s);
            }
        }
        if (stack.empty()) {
            return "/";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : stack) {
            stringBuffer.append("/");
            stringBuffer.append(s);

        }
        return stringBuffer.toString();

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        Learning2 l2 = new Learning2();
        System.out.println(l2.calculate("-(-1+3+(-2+4))"));

    }


    public int calculate(String s) {
        int p = 0;
        int len = s.length();
        int sign = 1;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(sign);
        while (p < len) {
            char c = s.charAt(p);
            if (c == ' ') {
                p++;
            } else if (c == '+') {
                sign = stack.peek();
                p++;
            } else if (c == '-') {
                sign = -stack.peek();
                p++;
            } else if (c == '(') {
                stack.add(sign);
                p++;
            } else if (c == ')') {
                stack.pop();
                p++;
            } else {
                int num = 0;
                while (p < len && Character.isDigit(s.charAt(p))) {
                    num = (num * 10) + (s.charAt(p) - '0');
                    p++;
                }
                res = res + (num * sign);
            }

        }
        return res;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow == fast;
    }




}
