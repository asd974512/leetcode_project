package com.ning.hot100;

import java.util.Arrays;
import java.util.Comparator;

public class java57插入区间 {
    public static void main(String[] args) {

    }
}

class Solution057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        int[][] result = new int[length + 1][2];
        if (length == 0 || intervals == null) {
            result[0] = newInterval;
            return result;
        }
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int index = 0;
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[index++] = intervals[i++];
        }
        while (i < intervals.length && intervals[i][0] < newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result[index++] = newInterval;
        while(i<intervals.length){
            result[index++] = intervals[i];
        }
        return Arrays.copyOf(result,index);
    }
}
