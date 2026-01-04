// 150. Evaluate Reverse Polish Notation
// https://leetcode.com/problems/evaluate-reverse-polish-notation/
package com.hsiangyu;

import java.util.LinkedList;

public class Solution {
    public static int evalRPN(String[] tokens) {
        LinkedList<Integer> operands = new LinkedList<>();
        for (int i = 0; i < tokens.length; ++i) {
            if (tokens[i].equals("+")) {
                int b = operands.pollLast();
                int a = operands.pollLast();
                operands.add(a + b);
            } else if (tokens[i].equals("-")) {
                int b = operands.pollLast();
                int a = operands.pollLast();
                operands.add(a - b);
            } else if (tokens[i].equals("*")) {
                int b = operands.pollLast();
                int a = operands.pollLast();
                operands.add(a * b);
            } else if (tokens[i].equals("/")) {
                int b = operands.pollLast();
                int a = operands.pollLast();
                operands.add(a / b);
            } else {
                operands.add(Integer.parseInt(tokens[i]));
            }
        }
        return operands.pollLast();
    }
}