package com.ning.hot100;

import java.util.Arrays;

public class java338比特位数 {
    public static void main(String[] args) {
        Solution338 solution = new Solution338();
        int[] ints = solution.countBits(5);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution338 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        if(n==0){
            return bits;
        }
        bits[1] = 1;
        for(int i=2;i<=n;i++){
            bits[i] = My_bits(i);
        }
        return bits;
    }
    public int My_bits(int n){
        int count = 0;
        int x = 1;
        while(x<n){
            x = x<<1;
        }
        //现在x是比n大的2次幂
        if(x==n){
            return 1;
        }
        x = x>>1;
        while(n!=0){
            n = n-x;
            count++;
            while(x>n){
                x = x>>1;
            }
        }
        return count;
    }
}