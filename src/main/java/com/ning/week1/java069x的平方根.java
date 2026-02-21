package com.ning.week1;

public class java069x的平方根 {
    public static void main(String[] args) {
        Solution069 solution069 = new Solution069();
        System.out.println(solution069.mySqrt(4));
    }
}

class Solution069 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= x){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
}

