package com.ning.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class java215第k个最大元素 {
    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        int[] nums = {1,2,5,4,8,3,2,9};
        solution215.findKthLargest(nums,3);
    }
}

class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,(a,b)->(a-b));
        for(int i=0;i<k;i++){
            queue.offer(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            int number = nums[i];
            if(number>queue.peek()){
                queue.poll();
                queue.add(number);
            }
        }
        return queue.peek();
    }



//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new myComparator());
//        for(int i =0;i<nums.length;i++){
//            queue.add(nums[i]);
//        }
//        int i = 0;
//        while(k>0){
//            i = queue.poll();
//            k--;
//        }
//        return i;
//    }
//
//    static class myComparator implements Comparator<Integer>{
//
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o2-o1;
//        }
//    }
}