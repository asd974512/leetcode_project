package com.ning.Tree;

import com.ning.common.TreeNode;

public class java111二叉树最小深度 {
    public static void main(String[] args) {
        Solution111 solution111 = new Solution111();
        TreeNode node = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(5);
        node.right.right.right.right = new TreeNode(6);

        int i = solution111.minDepth(node);
        System.out.println(i);
    }
}

class Solution111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        //叶子节点
        if(root.left==null && root.left==null){
            return 1;
        }
        if(root.left ==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        return Math.min(leftMinDepth,rightMinDepth)+1;
    }
}
