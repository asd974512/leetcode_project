package com.ning.hot100;

import java.util.ArrayDeque;

public class java739每日温度 {
    public static void main(String[] args) {

    }
}

class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        int index = 0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                index = stack.pop();
                ans[index] = i-index;
            }
            stack.push(i);
        }
        return ans;
    }
}