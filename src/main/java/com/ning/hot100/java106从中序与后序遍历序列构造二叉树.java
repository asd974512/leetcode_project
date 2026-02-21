package com.ning.hot100;

import com.ning.common.TreeNode;

import java.util.HashMap;

public class java106从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution106 solution106 = new Solution106();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode node = solution106.buildTree(inorder, postorder);

    }
}

class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, map);
    }

    public TreeNode build(int[] inorder, int iStart, int iEnd,
                          int[] postorder, int pStart, int pEnd, HashMap<Integer,Integer> map) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        int rootValue = postorder[pEnd];
        TreeNode root = new TreeNode(rootValue);

        int index = map.get(rootValue);

        //中序遍历右子树的节点个数
        int right_count = iEnd-index;

        root.left = build(inorder,iStart,index-1,postorder,pStart,pEnd-right_count-1,map);
        root.right = build(inorder,index+1,iEnd,postorder,pEnd-right_count,pEnd-1,map);
        return root;
    }
}