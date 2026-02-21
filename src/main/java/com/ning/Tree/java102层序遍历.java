package com.ning.Tree;

import com.ning.common.TreeNode;

import java.util.*;

public class java102层序遍历 {
    public static void main(String[] args) {

    }
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        process(root, lists);
        return lists;
    }

    public void process(TreeNode root, List<List<Integer>> lists) {
        //生成队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //队列需要while而不是递归
        while (queue.size() > 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            lists.add(tmp);
        }
    }
}
