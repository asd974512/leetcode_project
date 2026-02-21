package com.ning.hot100;

import com.ning.common.TreeNode;

import java.util.HashMap;

public class java105从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {

    }
}

class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1,map);
    }

    public TreeNode build(int[] preorder,int pStart,int pEnd,
                          int[] inorder,int iStart,int iEnd,HashMap<Integer,Integer> map){
        //越界了，就结束
        if(pStart>pEnd || iStart>iEnd){
            return null;
        }
        int rootValue = preorder[pStart];
        TreeNode root = new TreeNode(rootValue);
        //得到root在中序遍历的位置，左边的都是root的左子树，右边的都是root的右子树
        int index = map.get(rootValue);
        int left_count = index-1 -iStart +1;
        root.left = build(preorder,pStart+1,pStart+left_count,inorder,iStart,index-1,map);
        root.right = build(preorder,pStart+left_count+1,pEnd,inorder,index+1,iEnd,map);
        return root;
    }
}