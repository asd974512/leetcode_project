package com.ning.hot100;

import java.util.HashSet;

public class java128最长连续序列 {
    public static void main(String[] args) {

    }
}

class Solution128 {
//    public int longestConsecutive(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        int largerest = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (!set.contains(nums[i] - 1)) {
//                int length = 0;
//                int number = nums[i];
//                while (set.contains(number)) {
//                    length++;
//                    number++;
//                }
//                largerest = Math.max(largerest, length);
//            }
//        }
//        return largerest;
//    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int largerest = 0;
        for (int number: nums) {
            if (!set.contains(number - 1)) {
                int length = 0;

                while (set.contains(number)) {
                    length++;
                    number++;
                }
                largerest = Math.max(largerest, length);
            }
        }
        return largerest;
    }
}
