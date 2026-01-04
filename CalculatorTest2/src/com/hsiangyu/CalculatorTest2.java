
// shunting yard algorithm 
package com.hsiangyu;

import java.util.*;

public class CalculatorTest2 {

    public static void main(String[] args) {
        // String infix = "(a+b)*(c+d)";
        String infix = "32 + 103 +   22           +      3";
        infix = infix.trim().replaceAll(" ", "");
        String[] infixArray = infix.split("");
        System.out.println(Infix.toPostfix2(infixArray));
        System.out.println("abcd");
        System.out.println("中文中文");
        Scanner scanner = new Scanner(System.in);
        System.out.print("input: ");
        String aaaa  = scanner.next();
        System.out.println("中_aaaa");
        System.out.println(aaaa);
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

}
