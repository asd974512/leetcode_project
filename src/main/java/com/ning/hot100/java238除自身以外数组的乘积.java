package com.ning.hot100;

import java.util.Arrays;

public class java238除自身以外数组的乘积 {
    public static void main(String[] args) {

    }
}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return Arrays.copyOf(nums, nums.length);
        }
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 0;
        left[1] = nums[0];
        right[right.length - 1] = 0;
        right[right.length-2] = nums[right.length-1];
        for(int i=2;i<nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        for(int i = right.length-3;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        result[0] = right[0];
        result[result.length-1] = left[left.length-1];
        for(int i=1;i<result.length-1;i++){
            result[i] = left[i]*right[i];
        }
        return result;
    }
}
