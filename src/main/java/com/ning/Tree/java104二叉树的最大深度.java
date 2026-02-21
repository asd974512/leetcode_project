package com.ning.Tree;

import com.ning.common.TreeNode;

public class java104二叉树的最大深度 {
    public static void main(String[] args) {

    }
}

class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
