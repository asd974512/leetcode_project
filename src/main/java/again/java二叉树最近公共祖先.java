package again;

import com.ning.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class java二叉树最近公共祖先 {
    public static void main(String[] args) {

    }
}

class Solution {




    public List<List<TreeNode>> findPath(TreeNode root, TreeNode p) {
        List<List<TreeNode>> pathes = new ArrayList<>();
        Deque<TreeNode> path = new ArrayDeque<>();
        processPath(root, p, pathes, path);
        return pathes;
    }

    public void processPath(TreeNode root, TreeNode p,
                            List<List<TreeNode>> pathes, Deque<TreeNode> path) {
        if(root==null){
            return;
        }
        if (root == p) {
            path.add(root);
            pathes.add(new ArrayList<>(path));
            return;
        }
        path.add(root);
        processPath(root.left,p,pathes,path);
        processPath(root.right,p,pathes,path);
        path.removeLast();

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result result = process(root, p, q);
        return result.node;
    }

    //判断公共祖先的位置，返回公共祖先的位置
    public Result process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, false, false);
        }
        TreeNode node = null;
        boolean hasP = false;
        boolean hasQ = false;
        if (root == p) {
            hasP = true;
        }
        if (root == q) {
            hasQ = true;
        }
        Result resultLeft = process(root.left, p, q);
        Result resultRight = process(root.right, p, q);
        //说明左子树就找到祖先节点了
        if (resultLeft.node != null) {
            return new Result(resultLeft.node, false, false);
        }
        //说明右子树就找到祖先节点了
        if (resultRight.node != null) {
            return new Result(resultRight.node, false, false);
        }
        //说明左右子树都没找到祖先节点，看看自己是不是祖先节点
        hasP = hasP || resultLeft.hasP || resultRight.hasP;
        hasQ = hasQ || resultRight.hasQ || resultRight.hasQ;
        //说明自己就是祖先节点
        if (hasP && hasQ) {
            return new Result(root, false, false);
        } else {
            return new Result(null, hasP, hasQ);
        }

    }

    static class Result {
        TreeNode node;
        boolean hasP;
        boolean hasQ;

        Result(TreeNode node, boolean hasP, boolean hasQ) {
            this.node = node;
            this.hasP = hasP;
            this.hasQ = hasQ;
        }
    }
}
