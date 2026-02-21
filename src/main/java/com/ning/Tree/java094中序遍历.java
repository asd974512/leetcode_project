package com.ning.Tree;

import com.ning.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class java094中序遍历 {
    public static void main(String[] args) {

    }
}
class Solution094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderUnRecur(root,list);
        return list;
    }

    public void inOrderUnRecur(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() ||root!=null ){
            if(root!=null){
                stack.push(root);
                root= root.left;
            }else{
                TreeNode node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
    }
}

