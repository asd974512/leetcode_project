package com.ning.Tree;

import com.ning.common.TreeNode;

public class java235二叉搜索树最近公共祖先 {
    public static void main(String[] args) {
        Solution235 solution235 = new Solution235();
        TreeNode root = new TreeNode(6);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(0);
        TreeNode left2_2 = new TreeNode(7);
        TreeNode left3 = new TreeNode(3);
        TreeNode right1 = new TreeNode(8);
        TreeNode right2 = new TreeNode(4);
        TreeNode right2_2 = new TreeNode(9);
        TreeNode right3 = new TreeNode(5);
        root.left = left1;
        root.right = right1;
        root.left.left = left2;
        root.left.right = right2;
        root.right.left = left2_2;
        root.right.right = right2_2;
        root.left.right.left = left3;
        root.left.right.right = right3;
    }
}

class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (min <= root.val && root.val <= max) {
            return root;
        }
        TreeNode node;
        if(root.val<min){
            node = lowestCommonAncestor(root.right, p, q);
        }else{
            node = lowestCommonAncestor(root.left, p, q);
        }
        return node;
    }
}