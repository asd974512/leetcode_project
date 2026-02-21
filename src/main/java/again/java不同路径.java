package again;

import java.util.Scanner;

public class java不同路径 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i < M; i++) {
            map[0][i] = 1;
        }
        for(int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        System.out.println(map[N-1][M-1]);
    }
}
