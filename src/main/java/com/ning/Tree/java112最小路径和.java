package com.ning.Tree;

import com.ning.common.TreeNode;

public class java112最小路径和 {
    public static void main(String[] args) {

    }
}

class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(targetSum-root.val<0){
            return false;
        }
        return process(root,targetSum);
    }

    public boolean process(TreeNode root,int targetSum){
        //左右子树可能是空的情况如node.left==null;
        if(root==null){
            return false;
        }
        //为叶子节点，同时用完了
        if(root.left==null &&root.right ==null && targetSum==root.val ){
            return true;
        }
        //为叶子节点，没用完
        if(root.left==null &&root.right ==null && targetSum!=0 ){
            return false;
        }


        boolean left = process(root.left,targetSum-root.val);
        boolean right = process(root.right,targetSum-root.val);
        return left || right;//只要一个为真就行
    }
}
