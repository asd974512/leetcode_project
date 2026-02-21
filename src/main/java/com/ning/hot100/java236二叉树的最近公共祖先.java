package com.ning.hot100;

import com.ning.common.TreeNode;

public class java236二叉树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        root.left = node1;
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        TreeNode node2 = new TreeNode(4);
        root.left.right.right = node2;
        Solution236 solution236 = new Solution236();
        TreeNode node = solution236.lowestCommonAncestor(root, node1, node2);
        System.out.println(node.val);
    }
}

class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p ||root==q){
            return root;
        }
        Result process = process(root, p, q);
        return process.node;
    }
    public Result process(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return new Result(false,null);
        }

        Result leftResult = process(root.left, p, q);
        Result rightResult = process(root.right, p, q);
        if(leftResult.node!=null){
            return new Result(true,leftResult.node);
        }
        if(rightResult.node!=null){
            return new Result(true, rightResult.node);
        }
        if((root==p || root==q) &&(leftResult.flag || rightResult.flag) ){
            return new Result(true,root);
        }
        if(root==p || root==q ){
            return new Result(true,null);
        }
        if(leftResult.flag && rightResult.flag){
            return new Result(true,root);
        }
        if(leftResult.flag || rightResult.flag){
            return new Result(true,null);
        }
        return new Result(false,null);
    }

    static class Result{
        boolean flag;
        TreeNode node;
        Result(boolean flag,TreeNode node){
            this.flag = flag;
            this.node = node;
        }
    }
}
