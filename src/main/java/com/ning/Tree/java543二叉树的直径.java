package com.ning.Tree;

import com.ning.common.TreeNode;

public class java543二叉树的直径 {
    public static void main(String[] args) {

    }
}

class Solution543 {
    int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        process(root);
        return maxLength;
    }
    //找各个节点的深度
    public int process(TreeNode root){
        if(root ==null){
            return 0;
        }
        int leftDepth = process(root.left);
        int rightDepth = process(root.right);
        int length = leftDepth+rightDepth;
        maxLength = Math.max(maxLength,length);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
