package com.ning.DP;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class java118杨辉三角 {
    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
        List<Integer> lists = solution118.generate(5);
        System.out.println(lists);
    }
}

class Solution118 {
    public List<Integer> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if(numRows==0){
            return null;
        }
        int[][] dp = new int[numRows+1][numRows+1];

        for(int i=0;i<=numRows;i++){
            dp[i][1] = 1;
        }
        for(int i=1;i<=numRows;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=1;j<=i;j++){
                //表的上方和左上方
                dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                list.add(dp[i][j]);
            }
            lists.add(list);
        }
        return lists.get(lists.size()-1);

    }
}

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        if(rowIndex==0){
            return null;
        }
        int[][] dp = new int[rowIndex+1][rowIndex+1];

        for(int i=0;i<=rowIndex;i++){
            dp[i][1] = 1;
        }
        for(int i=1;i<=rowIndex;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=1;j<=i;j++){
                //表的上方和左上方
                dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                list.add(dp[i][j]);
            }
            lists.add(list);
        }
        return lists.get(lists.size()-1);

    }
}
