package huisu;

import java.util.*;

public class java47全排列2 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution47().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        if(length==0){
            return lists;
        }else if(length==1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }
        Arrays.sort(nums);
        dfs(lists,path,nums,0,used);
        return lists;
    }
    public void dfs(List<List<Integer>> lists,Deque<Integer> path,
                    int[] nums,int depth,boolean[] used){
        if(depth==nums.length){
            lists.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && used[i-1]==false){
                continue;
            }
            path.add(nums[i]);
            used[i] =true;
            dfs(lists,path,nums,depth+1,used);
            used[i] = false;
            path.removeLast();
        }

    }
}