package com.ning.Tree;

import com.ning.common.TreeNode;

public class java700二叉搜索树的搜索 {
    public static void main(String[] args) {

    }
}
class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        while(root!=null){
            if(root.val ==val){
                return root;
            }else if(root.val>val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return null;
    }
}
