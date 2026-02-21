package com.ning.huisu;

import java.util.*;

public class java047全排列2 {
    public static void main(String[] args) {
        Solution047__2 solution047__2 = new Solution047__2();
        int[] nums = {1,1,2};
        List<List<Integer>> lists = solution047__2.permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

class Solution047__2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        boolean[] usedVertical = new boolean[length];
        Arrays.sort(nums);
        dfs(nums,length,lists,path,usedVertical,0);
        return lists;
    }

    public void dfs(int[] nums, int end, List<List<Integer>> lists,
                    Deque<Integer> path,boolean[] usedVertical,int index){
        if(index==end){
            lists.add(new ArrayList<>(path));
            return;
        }
        boolean[] usedHorizontal = new boolean[end];
        for(int i=0;i<end;i++){
            if(usedVertical[i]){  //这个和上一层用的是同一个元素
                continue;
            }

            if(usedHorizontal[i]){ //这个和本层用的是同一个值。也会重复
                continue;
            }
            usedVertical[i] = true;
            //函数，目的是让水平boolean都设置为true
            findSameValueUsed(nums,usedHorizontal,i);

            path.add(nums[i]);
            dfs(nums,end,lists,path,usedVertical,index+1);
            path.removeLast();
            usedVertical[i] = false;
        }
    }

    public void findSameValueUsed(int[] nums, boolean[] usedHorizontal,int index){
        int number = nums[index];
        for(int i=index;i<nums.length;i++){
            if(nums[i]==number){
                usedHorizontal[i] = true;
            }else{
                break;
            }
        }
    }
}
