package com.ning.DP;

public class java174地下城游戏 {
    public static void main(String[] args) {
        Solution174 solution174 = new Solution174();
        int[][] dungeon = {{-2,-3,3},{-5,10,1},{10,30,-5}};
        int i = solution174.calculateMinimumHP(dungeon);
        System.out.println(i);
    }
}

class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int N = dungeon.length;
        int M = dungeon[0].length;
        //dp[i][j]表示在ij的位置上，至少需要多少的血量
        int[][] dp = new int[N][M];
        dp[N-1][M-1] = dungeon[N-1][M-1]>=0?1:(1-dungeon[N-1][M-1]);
        for(int i=N-2;i>=0;i--){
            dp[i][M-1] = Math.max(dp[i+1][M-1]-dungeon[i][M-1],1);
        }
        for(int i=M-2;i>=0;i--){
            dp[N-1][i] = Math.max(dp[N-1][i+1]-dungeon[N-1][i],1);
        }
        for(int i=N-2;i>=0;i++){
            for(int j =M-2;j>=0;j++){
                dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}
