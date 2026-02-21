package com.ning.DP;

public class java152乘积最大数组 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        if(N==0){
            return 0;
        }else if(N==1){
            return nums[0];
        }
        int[] maxDP = new int[N];
        int[] minDP = new int[N];
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        for(int i=0;i<N;i++){
            maxDP[i] = Math.max(nums[i],Math.max(maxDP[i-1]*nums[i],minDP[i-1]*nums[i]));
            minDP[i] = Math.min(nums[i],Math.min(maxDP[i-1]*nums[i],minDP[i-1]*nums[i]));
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            max = Math.max(max,maxDP[i]);
        }
        return max;
    }
}
