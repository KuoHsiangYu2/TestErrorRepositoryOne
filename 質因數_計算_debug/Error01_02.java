package com.test.error1;

import static java.lang.System.out;

import java.util.ArrayList;

public class Error01_02 {
    public static void main(String[] args) {
        // TestError1_02-__start
        // primeList.size() -> 258689
        // 程式 前半部份 part-01 執行共花費：1432910 豪秒 __ 23分52秒
        // TestError1-end
        // 3628801 質因數分解 = 11^1 * 329891^1
        // 後半段 part-02 程式執行共花費：7 豪秒
        // TestError1-end
        // .
        // .

        out.println("TestError1_02-__start");
        long t1 = 0L;
        long t2 = 0L;
        t1 = System.currentTimeMillis();

        /**
         * input
         */
        int input = 3628801;

        int inputBack = input;
        String ans = "";
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        int divisor = 0;
        for (int i = 1; i <= input; i++) {
            divisor = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisor++;
                    if (divisor == 3) {
                        break;
                    }
                }
            }
            if (2 == divisor) {
                primeList.add(i);
            }
        }
        out.println("primeList.size() -> " + primeList.size());
        t2 = System.currentTimeMillis();
        out.print("程式 前半部份 part-01 執行共花費：");
        out.print(t2 - t1);
        out.println(" 豪秒");
        out.println("TestError1-end");
        
        long t3 = 0L;
        long t4 = 0L;
        t3 = System.currentTimeMillis();

        int[] primePow = new int[primeList.size()];
        int index = 0;
        while (true) {
            if ((input % primeList.get(index)) == 0) {
                input = input / primeList.get(index);
                primePow[index]++;
                if (1 == input) {
                    index++;
                    break;
                }
            } else {
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            if (primePow[i] > 0) {
                ans = ans + primeList.get(i) + "^" + primePow[i] + " * ";
            }
        }
        if (ans != null && ans.length() > 0) {
            ans = ans.substring(0, ans.length() - 3);
        }
        out.print(inputBack + " 質因數分解 = ");
        out.println(ans);
        t4 = System.currentTimeMillis();
        out.print("後半段 part-02 程式執行共花費：");
        out.print(t4 - t3);
        out.println(" 豪秒");
        out.println("TestError1-end");
    }
}
