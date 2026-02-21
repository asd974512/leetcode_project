package com.ning.huisu;

import com.sun.imageio.plugins.gif.GIFImageReader;

public class java200岛屿数量 {
    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int i = solution200.numIslands(grid);
        System.out.println(i);
    }
}

//class Solution200 {
//    public int numIslands(char[][] grid) {
//        int islandCount = 0;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    islandCount++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
//        return islandCount;
//    }
//    //i是上下，j是左右
//    public void dfs(char[][] grid, int i, int j) {
//        //越界 已经经历过了 走到边间，直接return
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length  || grid[i][j] == '0') {
//            return;
//        }
//        grid[i][j]='0';
//        dfs(grid, i - 1, j);//向上
//        dfs(grid, i, j + 1);//向右
//        dfs(grid, i + 1, j);//向下
//        dfs(grid, i, j - 1);//向左
//    }
//}

class Solution200 {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    islandCount++;
                    dfs(grid, i, j, used);
                }
            }
        }
        return islandCount;
    }
    //i是上下，j是左右
    public void dfs(char[][] grid, int i, int j, boolean[][] used) {
        //越界 已经经历过了 走到边间，直接return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || used[i][j] || grid[i][j] == '0') {
            return;
        }
        used[i][j] = true;
        dfs(grid, i - 1, j, used);//向上
        dfs(grid, i, j + 1, used);//向右
        dfs(grid, i + 1, j, used);//向下
        dfs(grid, i, j - 1, used);//向左
    }
}
