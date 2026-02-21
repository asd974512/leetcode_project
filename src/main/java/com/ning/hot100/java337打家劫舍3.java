package com.ning.hot100;

import com.ning.common.TreeNode;

public class java337打家劫舍3 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.right.right = new TreeNode(1);
        Solution337 solution337 = new Solution337();
        int rob = solution337.rob(node);
        System.out.println(rob);
    }
}

class Solution337 {
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] nums = process(root);
        return Math.max(nums[0],nums[1]);

    }
    //返回一个数组，元素0表示拿当前的钱，元素1表示不拿当前的钱
    public int[] process(TreeNode root){
        //是null节点的情况下
        if(root==null){
            return new int[]{0,0};
        }
        //是叶子节点的情况下
        if(root.left==null && root.right==null){
            return new int[]{root.val,0};
        }
        int[] left = process(root.left);
        int[] right = process(root.right);
//        int noTakeMoney = left[0]+right[0]+0;
//        int takeMoney = left[1]+right[1]+root.val;
        int noTakeMoney = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        int takeMoney = left[1]+right[1]+root.val;
        return new int[]{takeMoney,noTakeMoney};
    }
}
