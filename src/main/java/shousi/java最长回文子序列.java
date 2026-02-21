package shousi;

public class java最长回文子序列 {
}

class Solution最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //dp[i][j]表示在[i,j]这个范围内，dp的最长回文长度;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                //左右两边相等
                if(c1==c2){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}