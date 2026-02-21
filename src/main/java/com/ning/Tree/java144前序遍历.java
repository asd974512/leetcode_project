package com.ning.Tree;

import com.ning.common.TreeNode;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class java144前序遍历 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        Solution144 solution144 = new Solution144();
        List<Integer> integers = solution144.preorderTraversal(node);
        Iterator<Integer> it = integers.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }


}

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrderRecur(root,list);
        return list;
    }

    public void preOrderRecur(TreeNode root, List<Integer> list){
        if(root ==null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //只要它非空，就要弹出.压入的顺序是1右2左
        while(!stack.isEmpty()){
            TreeNode node  = stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }

//    public void preOrderRecur(TreeNode head, List<Integer> list){
//        if(head == null){
//            return ;
//        }
//        list.add(head.val);
//        preOrderRecur(head.left,list);
//        preOrderRecur(head.right,list);
//
//    }
}
