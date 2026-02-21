package com.ning.week2;

import java.util.Arrays;

public class java135分发糖果 {
    public static void main(String[] args) {
        Solution135 solution135 = new Solution135();
        int[] nums = {1,0,2};
        int candy = solution135.candy(nums);
        System.out.println(candy);
    }
}

class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int count = n;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                count++;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                count++;
            }
        }
        return count;
    }
}
