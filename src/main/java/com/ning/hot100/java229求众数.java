package com.ning.hot100;

import java.util.ArrayList;
import java.util.List;

public class java229求众数 {
    public static void main(String[] args) {

    }
}

class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }
        int numberA = nums[0];
        int numberB = nums[1];
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == numberA) {
                countA++;
            } else if (nums[i] == numberB) {
                countB++;
            } else if (countA == 0) {
                numberA = nums[i];
                countA++;
            }
            //这里加else，是怕CountA和CountB重复了
            else if (countB == 0) {
                numberB = nums[i];
                countB++;
            } else {
                //这个必须放到最后面，不然会出现countA或者countB为负数的情况
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == numberA) {
                countA++;
            }
            else if (num == numberB) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {
            list.add(numberA);
        }
        if (countB > nums.length / 3) {
            list.add(numberB);
        }
        return list;

    }
}
