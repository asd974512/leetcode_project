package com.ning.DP;

public class java063不同路径2 {
    public static void main(String[] args) {
        Solution063 solution063 = new Solution063();
        int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
        int i = solution063.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }
}

class Solution063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
        if (N == 0 || M == 0 || obstacleGrid[N-1][M-1]==1 ||obstacleGrid[0][0]==1) {
            return 0;
        }
        int[][] dp = new int[N][M];
        boolean flag = false; //是否存在障碍物
        for (int i = 0; i < N; i++) {  //第一列，往下走
            if (obstacleGrid[i][0] == 1) {
                flag = true;  //如果有障碍物，后面的都是0【过不去了】
            }
            if (!flag) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        flag = false; //是否存在障碍物
        for (int i = 0; i < M; i++) {   //第一行，往右走
            if (obstacleGrid[0][i] == 1) {
                flag = true;
            }
            if (!flag) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else if(obstacleGrid[i - 1][j] == 0){ //左边堵住了
                    dp[i][j] = dp[i - 1][j];
                }else if(obstacleGrid[i][j - 1] == 0){  //上边堵住了
                    dp[i][j] = dp[i][j - 1];
                }else{  //左边上面都堵住了
                    dp[i][j] = 0;
                }
            }
        }
        return dp[N-1][M-1];
    }
}
