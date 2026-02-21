package com.ning.DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class java045跳跃游戏2 {
    public static void main(String[] args) {
        Solution045 solution045 = new Solution045();
        int[] nums = {2, 3, 1, 1, 4};
        int jump = solution045.jump(nums);
        System.out.println(jump);

    }

}

class Solution045{

    public int jump(int[] nums) {
        int time = process(nums, 0);
        return time;
    }

    public int process(int[] nums, int index) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp,Integer.MAX_VALUE-1000);
        dp[N - 1] = 0;
        for (int i = N - 2; i >= 0; i--) {
            if(nums[i] + i >=N){  //直接一步到达终点
                dp[i] = 1;
            }else{
                for(int j =1;j<=nums[i];j++){
                    dp[i] = Math.min(dp[i],1+dp[i+j]);
                }
            }
        }
        return dp[0];
    }
}
