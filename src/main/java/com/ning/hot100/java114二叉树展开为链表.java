package com.ning.hot100;

import com.ning.common.TreeNode;

import java.util.Stack;

public class java114二叉树展开为链表 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Solution114 solution114 = new Solution114();
        solution114.flatten(root);
        System.out.println();
        solution114.process(root);
    }
}

class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        process1(root);
    }
    /**
     * 展平操作
     */
    public void process1(TreeNode root) {
        //使用stack保存右子树，以免被覆盖
        Stack<TreeNode> stack = new Stack<>();
        TreeNode newRoot = root;
        while(true){
            //左右子树的四种情况
            if (newRoot.left != null && newRoot.right != null) {
                stack.push(newRoot.right);
                newRoot.right = newRoot.left;
                newRoot.left = null;
            } else if (newRoot.left != null && newRoot.right == null) {
                newRoot.right = newRoot.left;
                newRoot.left = null;
            }else if(newRoot.left==null && newRoot.right!=null){
                //不动
            }else if(newRoot.left==null && newRoot.right==null){
                //说明走到叶子节点了， 往回走
                if(!stack.isEmpty()){
                    TreeNode pop = stack.pop();
                    newRoot.right = pop;
                }else{//说明栈里面也没有，全部遍历完了
                    break;
                }
            }
            newRoot =newRoot.right;
        }
    }

    /**
     * 先序遍历
     *
     * @param root
     */
    public void process(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        process(root.left);
        process(root.right);
    }
}
