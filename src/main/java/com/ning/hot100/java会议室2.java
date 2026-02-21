package com.ning.hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class java会议室2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int[][] times = new int[time][2];
        for(int i=0;i<time;i++){
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
        }
        //先对数组进行排序
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //以结束时间作为小根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int maxSize = 1;
        queue.add(times[0]);
        for(int i=1;i<times.length;i++){
            while(!queue.isEmpty()){
                int[] peek = queue.peek();
                if(peek[1]<times[i][0]){
                    queue.poll();
                }else{
                    break;
                }
            }
            queue.add(times[i]);
            maxSize = Math.max(maxSize,queue.size());
        }

        System.out.println(maxSize);
    }
}


