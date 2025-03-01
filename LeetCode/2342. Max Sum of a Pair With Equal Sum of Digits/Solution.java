// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
package com.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {

    // 計算位數加總.
    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + (num % 10);
            num = (num / 10);
        }
        return sum;
    }

    // 找出二個相同重複數字的 index值 .
    private List<int[]> findDuplicateIndices(int[] inputArr) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<int[]> result = new ArrayList<int[]>();

        for (int i = 0; i < inputArr.length; i++) {
            if (!map.containsKey(inputArr[i])) {
                map.put(inputArr[i], new ArrayList<Integer>());
            }
            map.get(inputArr[i]).add(i);
        }

        for (List<Integer> indices : map.values()) {
            if (indices.size() > 1) {
                for (int i = 0; i < (indices.size() - 1); i++) {
                    for (int j = (i + 1); j < indices.size(); j++) {
                        int[] pair = new int[2];
                        pair[0] = indices.get(i);
                        pair[1] = indices.get(j);
                        result.add(pair);
                    }
                }
            }
        }

        return result;
    }

    public int maximumSum(int[] nums) {
        int[] sdArray = new int[nums.length];
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 = sumDigits(nums[i]);
            sdArray[i] = sum1;
        }

        List<int[]> duplicateIndicesResult = findDuplicateIndices(sdArray);

        if (duplicateIndicesResult.size() == 0) {
            return -1;
        }

        List<Integer> dcSumList = new ArrayList<Integer>();
        int sum2 = 0;
        for (int[] pair : duplicateIndicesResult) {
            sum2 = (nums[pair[0]] + nums[pair[1]]);
            dcSumList.add(sum2);
        }

        Collections.sort(dcSumList, (Integer i1, Integer i2) -> {
            return (-1) * (i1 - i2);
        });

        return dcSumList.get(0);
    }
}
