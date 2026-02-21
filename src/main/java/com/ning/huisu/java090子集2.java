package com.ning.huisu;

import java.util.*;

public class java090子集2 {
    public static void main(String[] args) {
        Solution090 solution090 = new Solution090();
        int[] num = {1, 2, 2};
        List<List<Integer>> lists = solution090.subsetsWithDup(num);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}


class Solution090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        if (nums.length == 0) {
            lists.add(new ArrayList<>(path));
            return lists;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, lists, path, 0, used);
        return lists;
    }

    public void dfs(int[] nums, List<List<Integer>> lists,
                    Deque<Integer> path, int index, boolean[] used) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(path));
            return;
        }
        //这个是不要这个数
        dfs(nums, lists, path, index + 1, used);
        //满足这个条件就不进行了
        if (index > 0 && nums[index] == nums[index - 1] && !used[index - 1]){
        }else{
            //这个是要这个数
            path.add(nums[index]);
            used[index]=true;
            dfs(nums, lists, path, index + 1, used);
            used[index]=false;
            path.removeLast();
        }
    }
}
