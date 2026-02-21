package com.ning.DP;


public class java123股票利润3 {
    public static void main(String[] args) {
        Solution123 solution123 = new Solution123();
        int[] prices = {3,3,5,0,0,3,1,4};
        int i = solution123.maxProfit(prices);
        System.out.println(i);
    }
}

class Solution123 {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        //五种状态
        //1啥也没干
        //2买了一次
        //3卖了一次
        //4买了二次
        //5卖了两次
        int[][] dp = new int[N][5];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for(int i=1;i<N;i++){
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            //第二次买卖，第二次买是基于第一次卖的钱上，所以是dp[i-1]
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return dp[N-1][4];
    }
}