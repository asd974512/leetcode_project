package com.ning.Tree;

import com.ning.common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class java145后序遍历 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        Solution145 solution145 = new Solution145();
        List<Integer> integers = solution145.postorderTraversal(node);
        Iterator<Integer> it = integers.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}

class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrderUnRecur(root,list);
        return list;
    }

    public void postOrderUnRecur(TreeNode root,List<Integer> list){
        if(root==null){
            return ;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push(node.right);
            }
        }
        //stack1的东西，全部进入stack2了
        while(!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            list.add(node.val);
        }
    }
}
