package com.ning.hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class java239滑动窗口最大值 {
    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] nums = {1,3,1,2,0,5};
        int[] ints = solution239.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        //是一个大根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(new myComparator());
        for(int i=0;i<k;i++){
            queue.add(new int[]{nums[i],i});
        }
        //此时peek出来的根节点，就是最大值
        result[resultIndex++] = queue.peek()[0];
        for(int i=k;i<nums.length;i++){

            //根节点的index小于等于i-k，说明根节点已经不在滑动窗口里面了，就弹出
            while(!queue.isEmpty() &&  queue.peek()[1]<=i-k){
                queue.poll();
            }
            queue.add(new int[]{nums[i],i});
            int[] peek = queue.peek();
            result[resultIndex++] = queue.peek()[0];
        }
        return result;
    }


    static class  myComparator implements Comparator<int[]>{
        /**
         *[0]是值,[1]是index
         */
        @Override
        public int compare(int[] o1, int[] o2) {
            //如果值不同就返回大的值，值相同就返回索引大的
            if(o1[0]!=o2[0]){
                return o2[0]-o1[0];
            }else{
                return o2[1]-o1[1];
            }
        }
    }
}