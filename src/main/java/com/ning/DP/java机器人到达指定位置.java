package com.ning.DP;

import java.util.Scanner;

public class java机器人到达指定位置 {

    public static int mod = (int)1e9+7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int P = scanner.nextInt();
        Solution solution = new Solution();
        int process = solution.process(N, M, K, P);
        System.out.println(process);


    }

    static class Solution {
        public int process(int n, int m, int k, int p) {
            if (n < 0 || m > n || k < 0 || p < 0) {
                return 0;
            }
            return walk2(n, m, k, p);
        }

        public int walk1(int n, int m, int k, int p) {
            if (k == 0) {
                return m == p ? 1 : 0;
            }
            if (m == 1) {
                return walk1(n, 2, k - 1, p);
            }
            if (m == n) {
                return walk1(n, n - 1, k - 1, p);
            }
            return walk1(n, m - 1, k - 1, p) + walk1(n, m + 1, k - 1, p);
        }

        public int walk2(int n,int m,int k,int p){
            int[][] dp = new int[k+1][n+1];
            dp[0][p] = 1;
            for(int i=1;i<=k;i++){
                for(int j=1;j<=n;j++){
                    if(j==1){
                        dp[i][j] = dp[i-1][2]%mod;
                    }else if(j==n){
                        dp[i][j] = dp[i-1][n-1]%mod;
                    }else{
                        dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%mod;
                    }
                }
            }
            return dp[k][m]%mod;
        }
    }
}


