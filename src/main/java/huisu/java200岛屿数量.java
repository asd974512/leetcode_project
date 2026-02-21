package huisu;

public class java200岛屿数量 {
}

class Solution200 {
    int count = 0;
    public int numIslands(char[][] grid) {
        int n =grid.length;
        int m =grid[0].length;
        boolean[][] used = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&& !used[i][j]){
                    count++;
                    dfs(grid,i,j,used);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int row,int col,boolean[][] used){
        if(row<0||row>=grid.length||col<0||col> grid[0].length){
            return;
        }
        if(grid[row][col]=='1' && !used[row][col] ){
            used[row][col]=true;
            dfs(grid,row+1,col,used);
            dfs(grid,row-1,col,used);
            dfs(grid,row,col+1,used);
            dfs(grid,row,col-1,used);
        }
    }
}