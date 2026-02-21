package com.ning.hot100;

import java.util.Arrays;

public class java031下一个排列 {
    public static void main(String[] args) {
        Solution031 solution031 = new Solution031();
        int[] nums = {8,7,7,6,5,4,3,2};
        System.out.println(Arrays.toString(nums));
        solution031.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution031 {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                index = i;
            }
        }
        //-1说明没有变化，从左到右都是从大到小，已经是排列的最大值了
        if(index==-1){
            for(int i=0;i<nums.length/2;i++){
                int tmp = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = tmp;
            }
        }else{
            int larger = index+1;
            for(int i = index+1;i<nums.length-1;i++){
                if(nums[index]<nums[i]){
                    larger = i;
                }
            }
            int tmp = nums[index];
            nums[index] = nums[larger];
            nums[larger] = tmp;
        }
    }
}