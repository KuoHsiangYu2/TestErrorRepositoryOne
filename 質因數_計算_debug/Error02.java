package com.test.error2;

import static java.lang.System.out;

public class Error02 {
    public static void main(String[] args) {
        // 程式執行共花費：97204 豪秒 __  01分37秒 .
        // .
        // .
        out.println("TestError2-start");
        long t1 = 0L;
        long t2 = 0L;
        t1 = System.currentTimeMillis();
        int input = 0, i = 0, j = 0, x = 0, recognition = 0, sum = 0, count = 0, k = 0;
        int[] a = new int[100];
        int[] b = new int[100];
        for (i = 0; i < 100; i = i + 1) {
            a[i] = 0;
        }
        for (i = 0; i < 100; i = i + 1) {
            b[i] = 0;
        }

        /**
         * input
         */
        input = 3628801;

        int n2 = input;
        recognition = 0;
        if (input < 1) {
            System.exit(0);
        } else if (input == 1) {
            recognition = 1;
        }
        k = 0;
        out.printf("%d 的因式分解%n", input);
        for (i = 2; input != 1; i++) {
            sum = 0;
            count = 0;
            for (j = 1; j <= i; j++) {
                if (((i % j) == 0) && (sum <= 2)) {
                    sum = sum + 1;
                }
            }
            while ((sum == 2) && ((input % i) == 0)) {
                count = count + 1;
                input = input / i;
            }
            if (count != 0) {
                k = k + 1;
                a[k - 1] = i;
                b[k - 1] = count;
            }
        }
        out.print("Answer = ");
        if (recognition == 1) {
            out.print("1^1");
        }
        for (x = (k - 1); x >= 0; x--) {
            if (x == 0) {
                out.printf("%d^%d", a[x], b[x]);
            } else {
                out.printf("%d^%d × ", a[x], b[x]);
            }
        }
        out.printf("%n");
        boolean flag = false;
        out.print(n2 + " = ");
        for (x = 0; x < k; x++) {
            if (flag) {
                out.print(" × ");
            } else {
                flag = true;
            }
            out.printf("%d^%d", a[x], b[x]);
        }
        out.printf("%n");
        t2 = System.currentTimeMillis();
        out.print("程式執行共花費：");
        out.print(t2 - t1);
        out.println(" 豪秒");
        out.println("TestError2-end");
    }
}
