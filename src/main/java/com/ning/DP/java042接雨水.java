package com.ning.DP;

public class java042接雨水 {
    public static void main(String[] args) {
        Solution042 solution043 = new Solution042();
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};
        int trap = solution043.trap(height1);
        System.out.println(trap);
    }
}

class Solution042 {

    public int trap(int[] height) {
        int length = height.length;
        if (length <= 2) {
            return 0;
        }
        int result = 0;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        leftMax[0] = height[0];
        rightMax[length-1] = height[length-1];
        //遍历leftMax,要么自己高度比之前左边最高还高，要么就是左边最高
        for(int i=1;i<length;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        for(int i=length-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        for (int i = 0; i < length; i++) {
            //Math.min(leftMax,rightMax)-height[i];
            result +=Math.min(leftMax[i],rightMax[i])-height[i]>0?
                    (Math.min(leftMax[i],rightMax[i])-height[i]):0;
        }
        return result;
    }


    public int trap1(int[] height) {
        int length = height.length;
        if (length <= 2) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            //找到目前高度的左边最高
            for (int left = i - 1; left >= 0; left--) {
                leftMax = height[left] > leftMax ? height[left] : leftMax;
            }
            //找到目前高度的右边最高
            for (int right = i + 1; right < length; right++) {
                rightMax = height[right] > rightMax ? height[right] : rightMax;
            }
            int minHeight = Math.min(leftMax, rightMax);
            //如果最低水位比目前的高度要高，就加上；否则目前高度没有水
            result += minHeight - height[i] > 0 ? (minHeight - height[i]) : 0;
        }
        return result;
    }
}
