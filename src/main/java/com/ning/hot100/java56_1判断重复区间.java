package com.ning.hot100;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class java56_1判断重复区间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int time = sc.nextInt();
            int[][] times = new int[time][2];
            for (int i = 0; i < times.length; i++) {
                times[i][0] = sc.nextInt();
                times[i][1] = sc.nextInt();
            }
            for (int[] ints : times) {
                System.out.println(Arrays.toString(ints));
            }
            boolean flag = process(times);
            System.out.println(flag?"有重复":"没有重复");
        }
    }

    public static boolean process(int[][] times) {
        Arrays.sort(times, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                }
        );
        for(int i=1;i<times.length;i++){
            if(times[i-1][1]>times[i][0]){
                return true;
            }
        }
        return false;
    }
}
