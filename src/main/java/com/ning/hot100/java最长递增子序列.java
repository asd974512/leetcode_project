package com.ning.hot100;

import java.lang.reflect.Array;
import java.util.Arrays;

public class java最长递增子序列 {
    public static void main(String[] args) {

    }
}

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if(length==1){
            return 1;
        }else if(length==0){
            return 0;
        }
        int[] dp = new int[length];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i=1;i<length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
