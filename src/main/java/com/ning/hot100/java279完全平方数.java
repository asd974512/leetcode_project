package com.ning.hot100;

public class java279完全平方数 {
    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        int i = solution279.numSquares(12);
        System.out.println(i);
    }
}

class Solution279 {
    public int numSquares(int n) {
        //dp[i]表示第i个数由几个完全平方数构成
        int[] dp = new int[n + 1];
        //初始化，至少每个数可以由i个1构成
        for(int i=0;i<dp.length;i++){
            dp[i] = i;
        }
        for(int i=2;i<=n;i++){
            int sqrt = (int) Math.sqrt(i);
            for(int j=1;j<=sqrt;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]);
            }
            dp[i]++;
        }
        return dp[n];
    }
}
