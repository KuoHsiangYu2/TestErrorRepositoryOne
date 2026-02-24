package com.test.error02;

import static java.lang.System.out;

/* Number 2 寫法. */
// Google搜尋查到的 試除法 計算速度普。.
// 【50 毫秒】.
// 3628801 = 11^1 × 329891^1
public class MainFinal {

    public static void main(String[] args) {
        long t1 = 0L;
        long t2 = 0L;
        t1 = System.currentTimeMillis();
        int input = 0;
        int primeNumber = 2; // 定義一個最小的質因數.
        int exponent = 0; // 定義次方.
        System.out.println("_質因數分解問題");
        input = 3628801; // 數字很大計算也也很久，在爛的算法裡面.

        if (input == 1) {
            System.out.println(input + " = 1^1");
            System.out.println("finish");
            return;
        } else if (input < 1) {
            System.out.println("error number");
            System.out.println("finish");
            return;
        }

        System.out.print(input + " = ");
        for (;;) {
            if (input == 1) {
                System.out.printf("%d^%d", primeNumber, exponent);
                break;
            } else if ((input % primeNumber) == 0) {
                input = input / primeNumber;
                exponent++;
            } else if (exponent != 0) {
                System.out.printf("%d^%d * ", primeNumber, exponent);
                primeNumber++;
                exponent = 0;
            } else {
                primeNumber++;
                exponent = 0;
            }
        }

        out.printf("\n");
        t2 = System.currentTimeMillis();
        out.print("最佳 程式執行共花費：");
        out.print((t2 - t1));
        out.println(" 豪秒");
        System.out.println();
        System.out.println("finish");
    } // end of main method.
}