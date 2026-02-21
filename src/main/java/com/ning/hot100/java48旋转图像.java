package com.ning.hot100;

public class java48旋转图像 {

}
class Solution48 {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        for(int i=0;i<=N/2;i++){
            for(int j=0;j<=M;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[N-i-1][j];
                matrix[N-i-1][j] = tmp;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=i;j<M;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}