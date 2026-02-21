package com.ning.hot100;

public class java221最大正方形 {
    public static void main(String[] args) {
        Solution221 solution221 = new Solution221();
        char[][] matrix = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int i = solution221.maximalSquare(matrix);
        System.out.println(i);
    }
}

class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            if ((i >= 1 && dp[i - 1][0] == 1) || matrix[i][0] == '1') {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < M; i++) {
            if ((i >= 1 && dp[0][i - 1] == 1) || matrix[0][i] == '1') {
                dp[0][i] = 1;
            }
        }
        //第一行和第一列已经初始化完毕
        for(int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                int num = dp[i][j];
                boolean more = more(matrix, i, j, num);
                if(more){
                    dp[i][j]++;
                }
            }
        }
        return dp[N-1][M-1]*dp[N-1][M-1];
    }

    public boolean more(char[][] matrix,int row,int col,int num){
        boolean flag = true;
        if(row-num<0 || col-num<0){
            return false;
        }
        for(int i=row;i>=row-num;i--){
            for(int j=col;j>=col-num;j--){
                if(matrix[i][j]=='0'){
                    flag=false;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
}