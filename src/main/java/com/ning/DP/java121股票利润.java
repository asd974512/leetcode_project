package com.ning.DP;

public class java121股票利润 {
    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int[] prices ={7,1,5,3,6,4};
        System.out.println(solution121.maxProfit(prices));
    }
}

class Solution121 {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if(N<=1){
            return 0;
        }
        //dp[i]表示第i天买股票，他的利润最大是多少（可能为负）
        int[] dp = new int[N+1];
        dp[N] = 0;//最后一天买
        int max = 0;
        for(int i=N-1;i>=1;i--){
            dp[i] = prices[i] - prices[i-1];
            if(dp[i+1]>0){
                dp[i]+=dp[i+1];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
