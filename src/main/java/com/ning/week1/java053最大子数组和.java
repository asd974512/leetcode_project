package com.ning.week1;

import java.util.Arrays;

public class java053最大子数组和 {
    public static void main(String[] args) {
        Solution053 solution053 = new Solution053();
        int[] nums = {99,1,-3,4,-1,0,1,-5,4};
        int i = solution053.maxSubArray(nums);
        System.out.println(i);
    }
}

class Solution053 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] array = new int[length];
        array[length-1] = nums[length-1];
        for(int i = length-2;i>=0;i--){
            if(nums[i]>nums[i]+array[i+1]){
                array[i] = nums[i];
            }else {
                array[i] =nums[i]+array[i+1];
            }
        }
        int max = array[0];
        for (int i : array) {
            if(max<=i){
                max = i;
            }
        }
        return max;

    }
}
