package com.ning.hot100;

import java.util.Arrays;

public class java075颜色分类 {
    public static void main(String[] args) {
        Solution075 solution075 = new Solution075();
        int[] nums = {2,0,2,1,1,0};
        solution075.sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}

class Solution075 {
    public void sortColors(int[] nums) {
        if(nums.length<=1){
            return ;
        }
        //这样的left和right是在括号外面
        //比如1，2，3，4[Left])5,5,5([right]7,8,9,10
        int left = -1;
        int right = nums.length;
        int i = 0;
        while(i<right){
            if(nums[i]<1){
                swap(nums,++left,i++);
            }else if(nums[i]==1){
                i++;
            }else if(nums[i]>1){
                swap(nums,i,--right);
            }
        }
//        left++;
//        right--;
//        for(int j=left;j<=right;j++){
//            System.out.print(nums[j]+" ");
//        }
//        System.out.println();
    }

    public void swap(int[] nums,int left, int i){
        int temp = nums[left];
        nums[left] = nums[i];
        nums[i] = temp;
    }
}
