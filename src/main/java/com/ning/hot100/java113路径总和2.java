package com.ning.hot100;

import com.ning.common.TreeNode;

import javax.lang.model.element.VariableElement;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class java113路径总和2 {
    public static void main(String[] args) {
        Solution113 solution113 = new Solution113();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);
        List<List<Integer>> lists = solution113.pathSum(node, 22);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathes = new ArrayList<>();
        if (root == null) {
            return pathes;
        }
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(pathes, path, root, targetSum);
        return pathes;
    }

    public void dfs(List<List<Integer>> pathes, Deque<Integer> path,
                    TreeNode root, int target) {
        if(root==null){
            return;
        }
        //是叶子节点，并且正好为0
        if (target-root.val == 0 && root.left == null &&root.right==null) {
            path.add(root.val);
            pathes.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        //是叶子节点，但是没走完
        if (target-root.val != 0 && root.left == null &&root.right==null) {
            return;
        }
        path.add(root.val);
        dfs(pathes, path, root.left, target - root.val);
        dfs(pathes, path, root.right, target - root.val);
        path.removeLast();
    }
}
