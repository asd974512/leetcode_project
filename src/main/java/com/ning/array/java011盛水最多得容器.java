package com.ning.array;

public class java011盛水最多得容器 {
    public static void main(String[] args) {
        Solution011 solution011 = new Solution011();
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution011.maxArea(ints));
    }
}

class Solution011 {
    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length-1;
        int max = (R-L)*Math.min(height[R],height[L]);
        while(L<R){
            if(height[L]<=height[R]){
                L++;
                max = Math.max(max,(R-L)*Math.min(height[R],height[L]));
            }else{
                R--;
                max = Math.max(max,(R-L)*Math.min(height[R],height[L]));
            }
        }
        return max;
    }
}