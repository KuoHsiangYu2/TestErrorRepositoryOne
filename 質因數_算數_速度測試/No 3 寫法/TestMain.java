package com.test.error01;

import static java.lang.System.out;

/* Number 3 寫法. */
// 計算速度最慢的寫法。最差的寫法.
// 【110854 毫秒】.
// 3628801 = 11^1 × 329891^1
public class TestMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long t1 = 0L;
        long t2 = 0L;
        t1 = System.currentTimeMillis();
        out.println("MainClass-start");
        int n = 0, i = 0, j = 0, x = 0, recognition = 0, sum = 0, count = 0, k = 0;
        int[] a = new int[100]; // 質因數.
        int[] b = new int[100]; // 次方.

        for (i = 0; i < 100; i = i + 1) {
            a[i] = 0;
        }
        for (i = 0; i < 100; i = i + 1) {
            b[i] = 0;
        }

        n = 3628801;

        int n2 = n;
        recognition = 0;
        if (n < 1) {
            return;
        } else if (n == 1) {
            recognition = 1;
        }
        k = 0;
        System.out.printf("%d 的因式分解\n", n);
        for (i = 2; n != 1; i = i + 1) {
            sum = 0;
            count = 0;
            for (j = 1; j <= i; j = j + 1) {
                if (((i % j) == 0) && (sum <= 2)) {
                    sum = sum + 1;
                }
            }
            while ((sum == 2) && ((n % i) == 0)) {
                count = count + 1;
                n = n / i;
            }
            if (count != 0) {
                k = k + 1;
                a[k - 1] = i;
                b[k - 1] = count;
            }
        }
        System.out.print("Answer -> ");
        if (recognition == 1) {
            System.out.print("1^1");
        }
        for (x = (k - 1); x >= 0; x--) {
            if (x == 0) {
                System.out.printf("%d^%d", a[x], b[x]);
            } else {
                System.out.printf("%d^%d × ", a[x], b[x]);
            }
        }
        System.out.printf("\n");
        boolean flag = false;
        System.out.print(n2 + " = ");
        for (x = 0; x < k; x++) {
            if (true == flag) {
                System.out.print(" × ");
            } else {
                flag = true;
            }
            System.out.printf("%d^%d", a[x], b[x]);
        }
        System.out.printf("\n");
        t2 = System.currentTimeMillis();
        out.print("O網友 程式執行共花費：");
        out.print((t2 - t1));
        out.println(" 豪秒");
        out.println("MainClass-end");
    }
}
