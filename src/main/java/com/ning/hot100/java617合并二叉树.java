package com.ning.hot100;

import com.ning.common.TreeNode;

public class java617合并二叉树 {
    public static void main(String[] args) {

    }
}

class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        TreeNode head = dfs(root1,root2);
        return head;
    }

    public TreeNode dfs(TreeNode root1,TreeNode root2){
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }

        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = dfs(root1.left,root2.left);
        node.right = dfs(root1.right,root2.right);
        return node;
    }
}
