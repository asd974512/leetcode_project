package com.ning.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class java120三角形最小路径和 {
    public static void main(String[] args) {
        Solution120 solution120 = new Solution120();
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        list1.add(2);
        Collections.addAll(list2,3,4);
        Collections.addAll(list3,6,5,7);
        Collections.addAll(list4,4,1,8,3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        int i = solution120.minimumTotal(lists);
        System.out.println(i);
    }
}

class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int N =triangle.size();
        //dp[i][j]表示的是在i行j列这个位置上的最小路径和
        int[][] dp = new int[N + 1][N + 1];
        for(int i=0;i<=N;i++){
            dp[i][0] = Integer.MAX_VALUE-10;
            if(i>0 &&i<N){
                dp[i][i+1] = Integer.MAX_VALUE-10;
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                //相当于triangle中的[i][j]
                Integer value = triangle.get(i - 1).get(j - 1);
                dp[i][j] = value+ Math.min(dp[i-1][j],dp[i-1][j-1]);
            }
        }
        int min = dp[N][0];
        for(int i=0;i<=N;i++){
            min = Math.min(dp[N][i],min);
        }
        return min;
    }
}