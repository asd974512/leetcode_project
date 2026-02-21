package again;

import com.ning.common.TreeNode;

public class java翻转二叉树 {
    public static void main(String[] args) {

    }
}

class Solution翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return  null;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = rightNode;
        root.right = leftNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
