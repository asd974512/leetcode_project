package com.ning.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class java015三数之和 {
    public static void main(String[] args) {
        Solution015 solution015 = new Solution015();
        int[] nums = {-1, 0, 0, 1};
        List<List<Integer>> lists = solution015.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if (length <= 2) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            //升序排序，如果第1个就大于0了，肯定没有三数之和等于0
            if (nums[i] > 0) {
                break;
            }
            //如果上一个和这个是同值，就跳过
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int right = length - 1;
            int left = i + 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {  //等于0的情况
                    ArrayList<Integer> list1 = new ArrayList<>(
                            Arrays.asList(nums[i], nums[left], nums[right]));
                    list.add(list1);
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
