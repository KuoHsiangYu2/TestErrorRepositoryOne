// https://openhome.cc/zh-tw/algorithm/computation/postfix/#google_vignette
package com.hsiangyu;

import java.util.LinkedList;
import java.util.List;

public class Infix {
    private static int priority(String c) {
        if (c.equals("+") || c.equals("-")) {
            return 1;
        } else if (c.equals("*") || c.equals("/")) {
            return 2;
        }
        return 0;
    }

    public static List<String> toPostfix2(String[] infix) {
        LinkedList<String> stack = new LinkedList<String>();
        List<String> output = new LinkedList<String>();
        String toStack = "(";
        String toOutput = ")";
        for (String c : infix) {
            if (c.equals(toStack)) {
                stack.add(c);
            } else if ("+-*/".indexOf(c) != -1) {
                while (!stack.isEmpty() && priority(stack.getLast()) >= priority(c)) {
                    output.add(stack.removeLast());
                }
                stack.add(c);
            } else if (c == toOutput) {
                while (stack.getLast() != toStack) {
                    output.add(stack.removeLast());
                }
                stack.removeLast();
            } else {
                output.add(c);
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.removeLast());
        }

        return output;
    }

}
