package again;

import java.util.*;

public class java全排列1 {
    public static void main(String[] args) {

    }
}

class Solution全排列1 {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (length == 0) {
            return lists;
        } else if (length == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[nums.length];
        dfs(lists, path, nums, 0, used);
        return lists;
    }

    public void dfs(List<List<Integer>> lists, Deque<Integer> path, int[] nums, int length,
                    boolean[] used) {
        if (length == nums.length) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(lists, path, nums, length + 1, used);
            used[i] = false;
            path.removeLast();
        }
    }
}