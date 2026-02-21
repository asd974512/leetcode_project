package shousi;

public class java搜索二维矩阵 {
    public static void main(String[] args) {

    }
}

class Solution搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = n-1;
        int j = 0;
        while(i>=0 && j<m){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                i--;
            }else if(matrix[i][j]<target){
                j++;
            }
        }
        return false;
    }
}