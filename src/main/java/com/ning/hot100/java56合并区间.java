package com.ning.hot100;

import java.util.Arrays;
import java.util.Comparator;

public class java56合并区间 {
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] intervals = {{1,3},{2,6},{6,10},{15,18}};
        int[][] merge = solution56.merge(intervals);
        for (int[] ints : merge) {
            System.out.print(Arrays.toString(ints)+" ");
        }
    }
}

class Solution56 {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        if(intervals==null || intervals.length==0){
            return result;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int index = 0;
        result[index++] = intervals[0];
        for(int i=1;i<intervals.length;i++){
            //我的开始比上一个的结尾还大
            if(intervals[i][0]>result[index-1][1]){
                result[index++] = intervals[i];
            }else{
                //我的开始比上个结尾小，那就比较我和上一个的结尾哪个大
                result[index-1][1] = Math.max(result[index-1][1],intervals[i][1]);
            }
        }
        //因为每次添加都是index++，所以index要比索引大1
        return Arrays.copyOf(result,index);
    }
}