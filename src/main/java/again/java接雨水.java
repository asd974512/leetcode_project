package again;

import java.util.Scanner;

public class java接雨水 {
    public static void main(String[] args) {

    }
}

class Solution接雨水 {
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[right.length-1] = height[height.length-1];
        for(int i=1;i<left.length;i++){
            //左边的最高和自己比谁更高，右同理
            left[i] = Math.max(left[i-1],height[i]);
        }
        for(int i = right.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        //目前得到了每个点的左边最高和右边最高，开始计算每个点的雨水量
        int areaSum = 0;
        //最左边和最右边是没有雨水的
        for(int i=1;i<height.length-1;i++){
            int leftMax = left[i];
            int rightMax = right[i];
            int rainHeight = Math.min(leftMax,rightMax);
            int sum = rainHeight>height[i]?(rainHeight-height[i]):0;
            areaSum+=sum;
        }
        return areaSum;
    }
}