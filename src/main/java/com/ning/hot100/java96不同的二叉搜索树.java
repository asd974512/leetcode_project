package com.ning.hot100;

public class java96不同的二叉搜索树 {
    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        int i = solution96.numTrees(4);
        System.out.println(i);
    }
}


class Solution96 {
    public int numTrees(int n) {

        //表示有i个节点能够构成多少个二叉搜索树
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i =2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] +=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}