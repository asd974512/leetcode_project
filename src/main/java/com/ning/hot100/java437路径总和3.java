package com.ning.hot100;

import com.ning.common.TreeNode;

public class java437路径总和3 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(-2);
        node.right = new TreeNode(-3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.left.left.left = new TreeNode(-1);
        node.right.left = new TreeNode(-2);
        Solution437 solution437 = new Solution437();
        int i = solution437.pathSum(node, -1);
        System.out.println(i);
    }
}

class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = process(root, targetSum);
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);
        return count + left + right;
    }

    public int process(TreeNode root, int target) {
        //为什么要加count，是因为题目中没说遇到一个对的情况后就不往下走了
        //意思就是下面的路径之和可能为0.那么也算是一种情况
        int count =0;
        if (root == null) {
            return 0;
        }
        //因此这里不会返回1，而是count++，最后在加上
        if (target - root.val == 0) {
            count++;
        }
//        if(target-root.val<0){
//            return 0;
//        }
        int left = process(root.left, target - root.val);
        int right = process(root.right, target - root.val);
        return left+right+count;
    }
}
