package com.ning.huisu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class java078子集 {
    public static void main(String[] args) {
        Solution078 solution078 = new Solution078();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = solution078.subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}

class Solution078 {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if(length==0){ return lists; }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        //我要这个数
        dfs(nums,0,lists,path,length,true);
        return lists;
    }

    public void dfs(int[] nums, int index, List<List<Integer>> lists,
                    Deque<Integer> path,int length,boolean choose){
        if(index==length){
            lists.add(new ArrayList<>(path));
            return;
        }
            //我要这个数
            path.add(nums[index]);
            dfs(nums,index+1,lists,path,length,true);
            //我不要这个数
            path.removeLast();
            dfs(nums,index+1,lists,path,length,false);
    }
}
