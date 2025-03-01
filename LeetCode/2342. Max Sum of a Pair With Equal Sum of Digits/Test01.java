// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
package com.test1;

public class Test01 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] case1 = new int[]{18, 43, 36, 13, 7};
        System.out.println(solution.maximumSum(case1));

        int[] case2 = new int[]{10, 12, 19, 14};
        System.out.println(solution.maximumSum(case2));

    }
}
