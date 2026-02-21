package again;

import com.ning.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class java二叉树展开为链表 {
    public static void main(String[] args) {

    }
}
class Solution二叉树展开为链表 {
    public void flatten(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        process(root,queue);
        TreeNode node = queue.pollFirst();
        while(!queue.isEmpty()){
            node.left = null;
            TreeNode nodeRight = queue.pollFirst();
            node.right = nodeRight;
        }
    }

    public void process(TreeNode root, Deque<TreeNode> queue){
        if(root==null){
            return;
        }
        queue.addLast(root);
        process(root.left,queue);
        process(root.right,queue);

    }
}