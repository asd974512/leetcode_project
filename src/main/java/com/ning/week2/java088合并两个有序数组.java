package com.ning.week2;

import java.util.Arrays;

public class java088合并两个有序数组 {
    public static void main(String[] args) {
        Solution088 solution088 = new Solution088();
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 5, 6};
        solution088.merge(nums1, 3, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }
}

class Solution088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //把nums1的原始值保存
        int[] newNums = Arrays.copyOf(nums1, m);
        //双指针,nums1的指针
        int i = 0, j = 0,k=0;
        while (i < m && j < n) {
            if (newNums[i]<=nums2[j]){
                nums1[k++] = newNums[i++];
            }else{
                nums1[k++] = nums2[j++];
            }
        }
        while(i<m){
            nums1[k++] = newNums[i++];
        }
        while(j<n){
            nums1[k++] = nums2[j++];
        }
    }
}