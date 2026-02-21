package huisu;

public class java695岛屿最大面积 {
    public static void main(String[] args) {

    }
}

class Solution695 {
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] used = new boolean[n][m];
        int[] nowArea = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !used[i][j]) {
                    nowArea[0] = 0;
                    dfs(grid, i, j, used, nowArea);
                    maxArea = Math.max(maxArea, nowArea[0]);
                }
            }
        }
        return maxArea;
    }

    public void dfs(int[][] grid, int cow, int col, boolean[][] used, int[] nowArea) {
        if (cow >= grid.length || col >= grid[0].length || cow < 0 || col < 0) {
            return;
        }
        if(grid[cow][col]==1 && !used[cow][col]){
            used[cow][col] =true;
            nowArea[0]++;
            dfs(grid,cow+1,col,used,nowArea);
            dfs(grid,cow-1,col,used,nowArea);
            dfs(grid,cow,col+1,used,nowArea);
            dfs(grid,cow,col-1,used,nowArea);
        }
    }
}