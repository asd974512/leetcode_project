package com.ning.huisu;

import java.lang.reflect.Array;
import java.util.Arrays;

public class java733图像渲染 {
    public static void main(String[] args) {
        Solution733 solution733 = new Solution733();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] image1 = {{0,1,0},{0,0,1}};
        int[][] ints = solution733.floodFill(image1, 1, 1, 1);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}

class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        boolean[][] used = new boolean[image.length][image[0].length];
        //sr是上下，sc是左右 //顺序是下右上左
        dfs(image, sr, sc, oldColor, newColor, used);

        return image;
    }

    public void dfs(int[][] image, int sr, int sc,
                    int oldColor, int newColor, boolean[][] used) {
        //越界了
        if (sr >= image.length || sr < 0) {
            return;
        }
        if (sc >= image[0].length || sc < 0) {
            return;
        }
        //说明之前遍历过了
        if (used[sr][sc]) {
            return;
        }
        //之前颜色相邻   || image[sr][sc] == newColor
        if (image[sr][sc] == oldColor) {
            used[sr][sc] = true;
            image[sr][sc] = newColor;
            dfs(image, sr + 1, sc, oldColor, newColor, used);
            dfs(image, sr, sc + 1, oldColor, newColor, used);
            dfs(image, sr - 1, sc, oldColor, newColor, used);
            dfs(image, sr, sc - 1, oldColor, newColor, used);
        } else {//颜色不相邻
            return;
        }
    }
}
