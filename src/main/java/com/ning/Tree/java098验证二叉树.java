package com.ning.Tree;

import com.ning.common.TreeNode;

public class java098验证二叉树 {
    public static void main(String[] args) {

    }
}

class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Result result = process(root);
        return result.flag;
    }

    public Result process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Result leftResult = process(root.left);
        Result rightResult = process(root.right);
        boolean flag = true;
        int min = root.val;
        int max = root.val;
        if (leftResult != null) {
            //左子树是否为搜索二叉树，并且root的值要比左子树最大的值还要大
            flag = leftResult.flag && leftResult.max < root.val;
            min = Math.min(min,leftResult.min);
            max = Math.max(max,leftResult.max);
        }
        if (rightResult != null) {
            //右子树是否为搜索二叉树，并且root的值要比右子树最小的值还要小
            flag = flag && rightResult.flag && rightResult.min > root.val;
            min = Math.min(min,rightResult.min);
            max = Math.max(max,rightResult.max);
        }

        return new Result(flag,min,max);

    }

    static class Result {
        int min;
        int max;
        boolean flag;

        Result(boolean flag, int min, int max) {
            this.min = min;
            this.max = max;
            this.flag = flag;
        }
    }
}
