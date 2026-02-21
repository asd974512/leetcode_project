package again;

public class java交错字符串 {
    public static void main(String[] args) {

    }
}

class Solution交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int N = s1.length();
        int M = s2.length();
        boolean[][] dp = new boolean[N + 1][M = 1];
        dp[0][0] = true;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
        }
        for (int i = 1; i <= M; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                dp[i][j] = (dp[i-1][j] && s3.charAt(i+j-1) ==s1.charAt(i-1))
                || (dp[i][j-1] && s3.charAt(i+j-1) == s1.charAt(j-1));
            }
        }
        return dp[N][M];
    }
}
