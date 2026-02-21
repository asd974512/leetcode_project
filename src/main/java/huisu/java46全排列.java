package huisu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class java46全排列 {
    public static void main(String[] args) {

    }
}

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        if(length==0){
            return lists;
        }else if(length==1){
            List<Integer> list1 = new ArrayList<>();
            list1.add(nums[0]);
            lists.add(list1);
            return lists;
        }

        dfs(lists,path,nums,0,used);
        return lists;
    }

    public void dfs(List<List<Integer>> lists, Deque<Integer> path,
                    int[] nums,int depth,boolean[] used){
        if(depth==nums.length){
            lists.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(lists,path,nums,depth+1,used);
            used[i] = false;
            path.removeLast();
        }
    }
}