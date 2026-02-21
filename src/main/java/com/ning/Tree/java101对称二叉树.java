package com.ning.Tree;

import com.ning.common.TreeNode;

public class java101对称二叉树 {
    public static void main(String[] args) {

    }
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root.left, root.right);
    }

    public boolean process(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if(leftNode.val!=rightNode.val){
            return false;
        }
        return process(leftNode.left,rightNode.right) &&process(leftNode.right,rightNode.left);
    }
}
