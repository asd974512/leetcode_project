package com.ning.Tree;

import com.ning.common.TreeNode;

public class java100相同的树 {
    public static void main(String[] args) {

    }
}

class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p!=null &&q==null) {
            return false;
        }
        if(p==null &&q==null){
            return true;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean leftSame = isSameTree(p.left, q.left);
        if(!leftSame){
            return leftSame;
        }
        boolean rightSame = isSameTree(p.right,q.right);
        return rightSame;
    }
}