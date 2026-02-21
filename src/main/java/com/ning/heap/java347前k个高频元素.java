package com.ning.heap;

import java.util.*;

public class java347前k个高频元素 {
    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        int[] nums = {1,1,1,2,2,3};
        int[] ints = solution347.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k,new myComparator());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }else{
                hashMap.put(nums[i],1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Integer> next = it.next();
            if(queue.size()<k){
                queue.offer(next);
            }else{
                Integer nowValue = next.getValue();
                Integer topValue = queue.peek().getValue();
                if(nowValue>topValue){
                    queue.poll();
                    queue.add(next);
                }

            }
        }
        //此时hashmap里面的值已经遍历完了，都在堆中过了一遍
        int[] result = new int[k];
        for(int i =k-1;i>=0;i--){
            result[i] = queue.poll().getKey();
        }
        return result;

    }
    static class myComparator implements Comparator<Map.Entry<Integer, Integer>>{

        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o1.getValue()-o2.getValue();
        }
    }
}