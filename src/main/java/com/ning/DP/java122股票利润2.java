package com.ning.DP;

public class java122股票利润2 {

}

class Solution122 {
    public int maxProfit1(int[] prices) {
        int profiles = 0;
        for(int i=0;i<prices.length-1;i++){
            profiles+= prices[i+1]>prices[i]?(prices[i+1]-prices[i]):0;
        }
        return profiles;
    }

    public int maxProfit(int[] prices){
        int N = prices.length;
        //dp[i][0]表示在i天手里没股票时手上的钱
        //dp[i][1]表示在i天手里有股票时手上的钱
        int[][] dp = new int[N+1][2];
        //默认手上没有一毛钱，所以是0，没钱第一天买股票，就是负数
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for(int i=2;i<=prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i-1]);
        }
        return dp[N][0];
    }
}