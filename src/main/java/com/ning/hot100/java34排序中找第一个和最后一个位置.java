package com.ning.hot100;

import java.util.Arrays;

public class java34排序中找第一个和最后一个位置 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ints = solution34.searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }
        int i = binarySearch(nums, 0, nums.length-1, target);
        if(i==-1){
            return new int[]{-1,-1};
        }else{
            int left = i;
            int right = i;
            for(int index = left;left>=0;left--){
                if(nums[left]!=nums[i]){
                    break;
                }
            }
            for(int index = right;right<nums.length;right++){
                if(nums[right]!=nums[i]){
                    break;
                }
            }

            if(left<0){
                left++;
            }
            if(right==nums.length){
                right--;
            }
            if(nums[left]!=nums[i]){
                left++;
            }
            if(nums[right]!=nums[i]){
                right--;
            }
            return new int[]{left,right};
        }
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int mid = ((right-left)>>1)+left;
        if(left<=right){
            if(nums[mid]==target){
                return mid;
            }else if(target<nums[mid]){
                return binarySearch(nums,0,mid-1,target);
            }else{
                return binarySearch(nums,mid+1,right,target);
            }
        }else{
            return -1;
        }
    }
}
