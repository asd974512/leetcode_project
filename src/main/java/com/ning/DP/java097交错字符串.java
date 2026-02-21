package com.ning.DP;

public class java097交错字符串 {
    public static void main(String[] args) {
        Solution097 solution097 = new Solution097();
        String str1= new String("aabcc");
        String str2 = "dbbca";
        String str3 = "aadbbcbcac";
        boolean interleave = solution097.isInterleave(str1, str2, str3);
        System.out.println(interleave);
    }
}

class Solution097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int N = s1.length();
        int M = s2.length();
        if (N + M != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[ N + 1][M + 1];
        dp[0][0] = true;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= M; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[N][M];
    }
}
