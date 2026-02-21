package com.ning.hot100;

import com.ning.common.TreeNode;

public class java226翻转二叉树 {
    public static void main(String[] args) {

    }
}

class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        process(root);
        return  root;
    }

    public void process(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode =root.right;
        process(root.left);
        process(root.right);
        root.left = rightNode;
        root.right = leftNode;
    }
}
