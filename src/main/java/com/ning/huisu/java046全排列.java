package com.ning.huisu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class java046全排列 {
    public static void main(String[] args) {
        Solution046 solution046 = new Solution046();
        int[] nums ={1,2,3};
        List<List<Integer>> permute = solution046.permute(nums);
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }
    }
}

class Solution046 {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if(length==0){
            return lists;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,length,lists,path,0);
        return lists;
    }

    /**
     *
     * @param nums
     * @param begin
     * @param end
     * @param lists
     * @param path
     * @param index 路径的长度，不能超过end(length)
     */
    public void dfs(int[] nums, int end, List<List<Integer>> lists,
                    Deque<Integer> path,int index){
//        if(index>end){
//            return;
//        }
        if(index==end){
            lists.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<end;i++){
//            if(index+1>=end){  //说明路径长度超过数组元素个数
//                break;
//            }
            if(path.contains(nums[i])){ //说明path中已经有这个元素了，不要重复添加
                continue;
            }
            path.add(nums[i]);
            dfs(nums,end,lists,path,index+1);
            path.removeLast();
        }
    }
}