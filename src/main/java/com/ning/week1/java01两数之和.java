package com.ning.week1;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Start Time 2022/3/1 15:07
 * End Time 2022/3/1 16:07
 */


public class java01两数之和 {
    public static void main(String[] args) {
        Solution01 solution = new Solution01();
        int[] nums = new int[]{2,7,11,15};
        int target = 22;
        int[] ints = solution.twoSum(nums,target);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution01 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){   //遍历数组
            //如果能在hashmap中找到可以互补的元素，就不需要添加了，直接返回互补的元素和自己
            //如果添加的话，可能会造成覆盖，比如target=6 nums=[2,3,3]
            //hashmap第二个3会把第一个3给覆盖掉，就找不到答案了
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            //因为hashmap用get通过key找到value，所以必须把序号作为value，不能为key
            //如果序号为key的话，那么通过value是找不到key的
            hashMap.put(nums[i],i);  //放入hashmap中
        }
        return null;
    }
}



/*class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count =0;
        for (int num:nums) { //将数组放入hashmap中  [顺序，值]
            hashMap.put(num,count);
            count++;
        }
        count =0;
        for(int num:nums){  //查找hashmap中key和value的值
            count++;
            if(hashMap.containsValue(target-num)){
                int[] ints = new int[2];
                ints[0] = count;
                ints[1] =;
            }
        }
        return new int[]{1,3};
    }
}*/