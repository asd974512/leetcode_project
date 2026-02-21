package shousi;

public class java最长公共子序列 {
    public static void main(String[] args) {
        Solution最长公共子序列 solution = new Solution最长公共子序列();
        int i = solution.longestCommonSubsequence("hofubmnylkra","pqhgxgdofcvmr");
        System.out.println(i);
    }
}

class Solution最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        if(n==0 || m==0){
            return 0;
        }
        //注意初始化，此时text2只有第一个字符
        for(int i=0;i<n;i++){
            char c1 = text1.charAt(i);
            if(c1==text2.charAt(0)){
                dp[i][0] = 1;
            }
            if(i>0 && dp[i-1][0]==1){
                dp[i][0] = 1;
            }
        }

        for(int i=0;i<m;i++){
            char c2 = text2.charAt(i);
            if(c2 == text1.charAt(0)){
                dp[0][i] = 1;
            }
            if(i>0 && dp[0][i-1]==1){
                dp[0][i] = 1;
            }
        }

        //已经初始化完第一行和第一列了
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if(c1==c2){
                    //text1的第i个字符和text2的第j个字符相等
                    dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i][j]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[n-1][m-1];
    }
}