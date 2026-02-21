package com.ning.huisu;

import java.util.*;

/**
 * 15：00
 */

public class java039组合总和 {
    public static void main(String[] args) {
        Solution039_my_2 solution039 = new Solution039_my_2();
        int[] nums = {2, 3, 9, 6}; // 2 3 6 9  || 9
        int target = 9;
        List<List<Integer>> lists = solution039.combinationSum(nums, target);
        lists.forEach((list) -> {
            System.out.println(list);
        });
    }
}

//class Solution039_my{
//    public List<List<Integer>> combinationSum(int[] candicates,int target){
//        int length = candicates.length;
//        List<List<Integer>> lists = new ArrayList<>();
//        //要用Deque，这样删除末尾好删
//        Deque<Integer> path = new ArrayDeque<>();
//        if(length==0){
//            return lists;
//        }
//        //将存入的值放到lists里面
//        dfs(candicates,0,length,lists,path,target);
//        return lists;
//    }
//
//    public void  dfs(int[] candicates,int begin,int end,
//                     List<List<Integer>> lists,Deque<Integer> path,int target){
//        if(target <0){ //如果是《0.说明这条路走不通
//            return;
//        }
//        if(target ==0){     //如果是=0，说明正好这条路
//            //既然用了Deque，添加的时候就需要转换
//            lists.add(new ArrayList<>(path));
//            return ;
//        }       //如果》0，说明还可以走下去
//                //注意i不能从0开始，因为从0开始就会有重复值（只是顺序不同），
//                // 注意从begin开始，而不是begin+1
//        for(int i =begin;i<end;i++){
//            path.add(candicates[i]);
//            dfs(candicates,i,end,lists,path,target-candicates[i]);
//            path.removeLast();
//        }
//    }
//
//}

class Solution039_my_2{
    public List<List<Integer>> combinationSum(int[] candicates,int target){
        int length = candicates.length;
        List<List<Integer>> lists = new ArrayList<>();
        //要用Deque，这样删除末尾好删
        Deque<Integer> path = new ArrayDeque<>();
        if(length==0){
            return lists;
        }
        //将存入的值放到lists里面
        //剪枝需要先排序
        Arrays.sort(candicates);
        dfs(candicates,0,length,lists,path,target);
        return lists;
    }

    public void  dfs(int[] candicates,int begin,int end,
                     List<List<Integer>> lists,Deque<Integer> path,int target){
        if(target ==0){     //如果是=0，说明正好这条路
            //既然用了Deque，添加的时候就需要转换
            lists.add(new ArrayList<>(path));
            return ;
        }       //如果》0，说明还可以走下去
        //注意i不能从0开始，因为从0开始就会有重复值（只是顺序不同），
        // 注意从begin开始，而不是begin+1
        for(int i =begin;i<end;i++){

            if(target-candicates[i]<0){
                break;
            }
            //注意这里和不剪枝的顺序，判断之后再添加，
            // 如果之后添加，那么add的元素就因为break而无法remove
            path.add(candicates[i]);
            dfs(candicates,i,end,lists,path,target-candicates[i]);
            path.removeLast();
        }
    }
}














class Solution039 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
//            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
//            System.out.println("递归之后 => " + path);
        }
    }
}

class Solution039_1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
