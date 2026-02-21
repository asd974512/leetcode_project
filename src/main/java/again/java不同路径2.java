package again;

public class java不同路径2 {
    public static void main(String[] args) {

    }
}

class Solution不同路径 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
        int[][] map = new int[N][M];
        if (N == 0 || M == 0 || obstacleGrid[0][0] == 1
                || obstacleGrid[N - 1][M - 1] == 1) {
            return 0;
        }
        boolean isObstacle = false;
        //遍历第一列
        for (int i = 0; i < N; i++) {
            if (obstacleGrid[i][0] == 1) {
                //有障碍物，下面的都锁死了
                isObstacle = true;
            }
            if (isObstacle) {
                map[i][0] = 0;
            } else {
                map[i][0] = 1;
            }
        }
        //遍历第一行
        isObstacle = false;
        for (int i = 0; i < M; i++) {
            if (obstacleGrid[0][i] == 1) {
                isObstacle = true;
            }
            if (isObstacle) {
                map[0][i] = 0;
            } else {
                map[0][i] = 1;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
                    map[i][j] = 0;
                } else if (obstacleGrid[i - 1][j] == 1) {
                    map[i][j] = map[i][j - 1];
                } else if (obstacleGrid[i][j - 1] == 1) {
                    map[i][j] = map[i - 1][j];
                }else{
                    map[i][j] = map[i][j - 1]+map[i - 1][j];
                }
            }
        }
        return map[N-1][M-1];
    }
}