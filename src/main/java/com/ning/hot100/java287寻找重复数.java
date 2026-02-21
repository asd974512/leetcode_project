package com.ning.hot100;

import java.util.HashSet;

public class java287寻找重复数 {
    public static void main(String[] args) {
        Solution287 solution287 = new Solution287();
        int duplicate = solution287.findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println(duplicate);
    }
}

class Solution287 {
//    public int findDuplicate(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(set.contains(nums[i])){
//                return nums[i];
//            }else{
//                set.add(nums[i]);
//            }
//        }
//        return -1;
//    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        //先走了一步
        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //走回原点
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}