package com.ning.week1;

import java.util.Arrays;

/**
 * 2022/3/3 15:00
 * 2020/3/3 15:11
 */


public class java026删除有序数组重复项 {
    public static void main(String[] args) {
        Solution026 solution026 = new Solution026();
        int[] nums = {0, 0, 1, 1, 2, 3, 3, 4, 5, 5, 5, 6};
        int count = solution026.removeDuplicates(nums);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution026 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        int index = 0;
        for (int i = 1; i < length;) {
            if(nums[index]==nums[i]){
                i++;
            }else{
                nums[++index]=nums[i++];
            }
        }
        return index+1;
    }
}
