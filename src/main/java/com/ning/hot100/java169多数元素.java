package com.ning.hot100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class java169多数元素 {
}
class Solution169 {

    public int majorityElement(int[] nums){
        int number = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==number){
                count++;
            }else{
                count--;
                if(count==0){
                    number = nums[i];
                    count=1;
                }
            }
        }
        return number;
    }

//    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> hash = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(hash.containsKey(nums[i])){
//                hash.put(nums[i],hash.get(nums[i])+1);
//                if(hash.get(nums[i]) > nums.length/2){
//                    return nums[i];
//                }
//            }else{
//                hash.put(nums[i],1);
//                if(hash.get(nums[i]) > nums.length/2){
//                    return nums[i];
//                }
//            }
//        }
//        return 0;
//    }
}