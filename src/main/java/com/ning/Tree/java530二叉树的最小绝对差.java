package com.ning.Tree;

import com.ning.common.TreeNode;

public class java530二叉树的最小绝对差 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
//        node.left.left = new TreeNode(4);
//        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(3);
//        node.right.right = new TreeNode(7);
        Solution530 solution530 = new Solution530();
        int i = solution530.getMinimumDifference(node);
        System.out.println(i);
    }
}

class Solution530 {
    static int min = Integer.MAX_VALUE;
    static int pre_value = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root==null || root.left==null &&root.right==null){
            return 0;
        }
        inOrderRecur(root);
        return min;
    }

    public void inOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        //第一次的时候，pre_value没值
        if(pre_value==Integer.MAX_VALUE){
            pre_value = root.val;

        }else{
            min = Math.min(min, Math.abs(root.val - pre_value));
            pre_value = root.val;
//        System.out.println(root.val);
        }


        inOrderRecur(root.right);
    }
}
