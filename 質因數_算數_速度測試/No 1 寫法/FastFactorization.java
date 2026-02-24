// package com.test1;

import java.math.BigInteger;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* Number 1 寫法. */
// 計算速度最快。 2 ~ 4 毫秒。.
// ✅ 高效版本（Pollard Rho + Miller Rabin）.
// ChatGPT 給的答案.
// 【5 毫秒】.
// 3628801 = 11 * 329891
public class FastFactorization {

    private static final Random random = new Random();

    public static void main(String[] args) {
        long l01 = System.currentTimeMillis();
        long input = 0L;
        input = 3628801L;

        Map<Long, Integer> factors = factor(input);

        printFactorization(input, factors);
        long l02 = System.currentTimeMillis();
        System.out.println("D-07 currentTimeMillis_ " + (l02 - l01));
        System.out.print("A1 程式執行共花費：");
        System.out.print((l02 - l01));
        System.out.println(" 豪秒");
    }

    // ===========================
    // 主分解流程
    // ===========================
    public static Map<Long, Integer> factor(long n) {
        Map<Long, Integer> map = new TreeMap<>();
        factorRec(n, map);
        return map;
    }

    private static void factorRec(long n, Map<Long, Integer> map) {

        if (n == 1) {
            return;
        }

        if (isPrime(n)) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            return;
        }

        long divisor = pollardsRho(n);
        factorRec(divisor, map);
        factorRec((n / divisor), map);
    }

    // ===========================
    // Miller-Rabin Primality Test
    // ===========================
    private static boolean isPrime(long n) {
        return BigInteger.valueOf(n).isProbablePrime(20);
    }

    // ===========================
    // Pollard's Rho
    // ===========================
    private static long pollardsRho(long n) {

        if ((n % 2) == 0) {
            return 2;
        }

        long x = (random.nextInt(1000000) + 2);
        long y = x;
        long c = (random.nextInt(1000000) + 1);
        long d = 1;

        while (d == 1) {
            x = f(x, c, n);
            y = f(f(y, c, n), c, n);
            d = gcd(Math.abs(x - y), n);

            if (d == n) {
                return pollardsRho(n);
            }

        }

        return d;
    }

    private static long f(long x, long c, long mod) {
        return (mulMod(x, x, mod) + c) % mod;
    }

    private static long mulMod(long a, long b, long mod) {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
    }

    // 計算最大公因數.
    private static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    // ===========================
    // 輸出格式
    // ===========================
    private static void printFactorization(long input, Map<Long, Integer> map) {

        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.append(" = ");

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            long prime = entry.getKey();
            int exp = entry.getValue();

            sb.append(prime);
            if (exp > 1) {
                sb.append("^").append(exp);
            }
            sb.append(" * ");
        }

        sb.setLength(sb.length() - 3);

        System.out.println(sb);
    }
}