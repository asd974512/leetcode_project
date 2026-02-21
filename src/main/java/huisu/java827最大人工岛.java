package huisu;

import java.util.Arrays;

public class java827最大人工岛 {
    public static void main(String[] args) {
        Solution827 solution827 = new Solution827();
        int i = solution827.largestIsland(new int[][]{{1, 0}, {0, 1}});
        System.out.println(i);
    }
}

class Solution827 {
    int maxArea=0;
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int area = 0;
                if(grid[i][j]==1){
                    boolean[][] used = new boolean[n][m];
                    area = dfs(grid,i,j,used);
//                    Arrays.fill(used,false);
                }
                if(grid[i][j]==0){
                    grid[i][j] = 1;
                    boolean[][] used = new boolean[n][m];
                    area += dfs(grid, i+1, j, used);
                    area += dfs(grid, i-1, j, used);
                    area += dfs(grid, i, j+1, used);
                    area += dfs(grid, i, j-1, used);
//                    Arrays.fill(used,false);
                }
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid,int row,int col,
                   boolean[][] used){
        if(row<0 ||row>=grid.length || col<0||col>=grid[0].length){
            return 0;
        }
        if(grid[row][col]==0 || used[row][col]){
            return 0;
        }
        if(grid[row][col]==1 && !used[row][col]){
            used[row][col] = true;
            int area = 1;
            area += dfs(grid,row+1,col,used);
            area += dfs(grid,row-1,col,used);
            area += dfs(grid,row,col+1,used);
            area += dfs(grid,row,col-1,used);
            return area;
        }
        return 0;
    }
}
