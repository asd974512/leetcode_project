package com.ning.week1;

/**
 * 2022/3/3 15:17
 * 2022/3/3 15:35
 */

public class java027移除元素 {
    public static void main(String[] args) {
        Solution027 solution027 = new Solution027();
        int[] nums1 = {1, 2, 3, 5, 4, 8, 2, 3, 9, 7, 5, 2, 1, 6, 2, 0};
        int[] nums2 = {1};
        int val = 1;
        int i = solution027.removeElement(nums2, val);
        System.out.println(i);
    }
}

class Solution027 { //采用双指针，左右两个指针
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        //count用来计数，left和right计数都不行
        int count =0;
        //left比right大，说明全部遍历完了，两个相等还可能是val值，所以必须<=
        while (left <= right) {
            //如果碰到了，就前后指针元素交换，后指针前移
            if (nums[left] == val) {
                swap(nums, left, right);
                count++;
                right--;
            } else {
                left++;
            }
        }
        return length-count;
    }

    public void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}