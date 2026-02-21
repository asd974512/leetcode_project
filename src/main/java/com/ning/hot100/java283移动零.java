package com.ning.hot100;

public class java283移动零 {
    public static void main(String[] args) {

    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        int zeroPoint = 0;
        int leftPoint = 0;
        if(nums.length==0){
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums,zeroPoint++,leftPoint++);
            }else{
                leftPoint++;
            }
        }
    }

    public void swap(int[] nums,int left,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
