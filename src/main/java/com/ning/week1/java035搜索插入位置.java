package com.ning.week1;

public class java035搜索插入位置 {
    public static void main(String[] args) {
        Solution035 solution035 = new Solution035();
        int[] nums = {1};
        int target = 1;
        int i = solution035.searchInsert(nums, target);
        System.out.println(i);
    }
}


class Solution035 {  //先写一个二分查找
    public int searchInsert(int[] nums, int target) {
        int process = process(nums, 0, nums.length - 1, target);
        return process;
    }
    public int process(int[] nums, int left, int right, int target) {

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (left >= right) {
            if (nums[right] > target) {
                return right;
            } else {
                return right + 1;
            }
        }
        if (target < nums[mid]) {
            return process(nums, left, mid, target);
        } else {
            return process(nums, mid + 1, right, target);
        }
    }
}
