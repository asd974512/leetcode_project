package com.ning.week1;

public class test二分查找 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,8,9,11,16,19,20,23};
        int target = 21;
        int process = process2(nums, 0, nums.length - 1, target);
        System.out.println(process);

    }

    public static int process(int[] nums,int left,int right,int target){
        if(left>right){
            return -1;
        }
        int mid = left + ((right-left)>>1);
        if(nums[mid]<target){
            return process(nums,mid+1,right,target);
        }else if (target<nums[mid]){
            return process(nums,left,mid-1,target);
        }else{
            return mid;
        }
    }

    public static int process2(int []nums,int left,int right,int target){
        while(left<=right){
            int mid = left+((right-left)>>1);
            if(nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }

}
