package com.ning.array;

/**
 * 14:35
 */
public class java033搜索旋转排列数组 {
    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        int[] ints1 = {3,1};
        int target = 1;
        Solution033 solution033 = new Solution033();
        int result = solution033.search(ints1, target);
        System.out.println(result);
    }
}

class Solution033 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left<=right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {  //左半边有序
                if (nums[left] <= target && target <= nums[mid]) {
                    //二分法查找有序数组
                    return binarySearch(nums, left, mid, target);
                } else {
                    left = mid+1;
                }
            }else{  //右半边有序
                if(nums[mid]<=target && target<=nums[right]){
                    //二分法查找数组
                    return binarySearch(nums,mid,right,target);
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
    public int binarySearch(int[] nums,int left,int right,int target){
        while(left<=right){
            int mid = ((right-left)>>1)+left;
            if(nums[mid]==target){
                return mid;
            }else if(target<nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}