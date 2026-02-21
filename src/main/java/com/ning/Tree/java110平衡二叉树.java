package com.ning.Tree;

import com.ning.common.TreeNode;

public class java110平衡二叉树 {
    public static void main(String[] args) {

    }
}

class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBalance;
    }

    public Result process(TreeNode node){
        if(node ==null){
            return new Result(0,true);
        }
        Result leftResult = process(node.left);
        Result rightResult = process(node.right);
        int height = Math.max(leftResult.height,rightResult.height)+1;
        boolean isBalance = true;
        if(Math.abs(leftResult.height-rightResult.height)>1){
            isBalance = false;
        }
        isBalance = isBalance && leftResult.isBalance && rightResult.isBalance;
        return new Result(height,isBalance);
    }


    static class Result {
        public int height;
        public boolean isBalance;

        Result(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }
}
