package graph;

import java.util.Arrays;
import java.util.Scanner;

public class java二维数据 {
    public static void main(String[] args) {
        int[][] numbers = new int[][]{{1},{0,3},{2,4},{5}};
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<4;i++){
//            String[] strs = sc.nextLine().split(" ");
//            for(int j=0;j< strs.length;i++){
//                numbers[i][j] = Integer.parseInt(strs[i]);
//            }
        }
        for(int i=0;i<4;i++){
            System.out.println(Arrays.toString(numbers[i]));
        }
    }
}
