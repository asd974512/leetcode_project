package com.ning.hot100;

public class java072编辑距离 {
    public static void main(String[] args) {

    }
}

class Solution072 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //极端的特殊情况
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        //dp[i][j]表示word1[i]变成word2[j]至少需要多少步
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        //第一行，表示"" -> word2,不断增加字符
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    //分别是替换，删除，增加
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[n][m];
    }
}
