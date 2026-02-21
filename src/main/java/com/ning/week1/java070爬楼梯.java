package com.ning.week1;

public class java070爬楼梯 {
    public static void main(String[] args) {
        Solution070 solution070 = new Solution070();
        System.out.println(solution070.climbStairs(1));

    }
}


class Solution070 {
    public int climbStairs(int n) {
        int[] ints = new int[n+1];
        ints[0]=0;
        if(n<3){
            return n;
        }
        ints[1]=1;
        ints[2]=2;
        for(int i=3;i<n+1;i++){
            ints[i] = ints[i-1]+ints[i-2];
        }
        return ints[n];
    }
}
