package com.ning.DP;

public class java198打家劫舍 {
    public static void main(String[] args) {

    }
}

class Solution打家劫舍 {
    public int rob(int[] nums) {
        int N = nums.length;
        if(N==0){
            return 0;
        }else if(N ==1){
            return nums[0];
        }else if(N==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[N + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0],nums[1]);
        for(int i=3;i<=N;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[N];
    }
}
