package com.ning.Tree;

import com.ning.common.TreeNode;

public class java108有序数组转二叉树 {
    public static void main(String[] args) {

    }
}

class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode BST = process(nums,0,nums.length-1);
        return BST;
    }

    public TreeNode process(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = process(nums,left,mid-1);
        node.right = process(nums,mid+1,right);
        return node;
    }
}