package com.ning.huisu;

import java.util.*;

public class java040组合总和2 {
    public static void main(String[] args) {
        Solution040 solution040 = new Solution040();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = solution040.combinationSum2(nums, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

class Solution040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length == 0) {
            return lists;
        }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(candidates, 0, candidates.length, lists, path, used, target);
        return lists;
    }

    public void dfs(int[] candicates, int begin, int end,
                    List<List<Integer>> lists, Deque<Integer> path, boolean[] used, int target) {
        if (target == 0) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < end; i++) {
//            if (used[i]) {    用不上，因为只用1次，
//                continue;
//            }
            if (target - candicates[i] < 0) { //结果为负数，直接剪枝
                break;
            }
            //判断上一个是否为false得是i-1
            if (i > 0 && candicates[i] == candicates[i - 1] && used[i-1] == false) {
                continue;
            }
            path.add(candicates[i]);
            used[i] = true;
            //因为每个数只能使用1次，所以是i+1，如果多次就是i
            dfs(candicates, i + 1, end, lists, path, used, target - candicates[i]);
            used[i] = false;
            path.removeLast();
        }
    }
}
