package shousi;

import com.ning.common.TreeNode;

import java.util.*;

public class java路径之和2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int targetSum = Integer.parseInt(strs[strs.length-1]);
        int[] numbers = new int[strs.length - 1];
        for(int i=0;i< numbers.length;i++){
            if(strs[i].equals("null")){
                numbers[i] = Integer.MIN_VALUE+11;
            }else{
                numbers[i] = Integer.parseInt(strs[i]);
            }
        }
        TreeNode tree = createTree(numbers, 0);
        Solution路径之和2 main = new Solution路径之和2();
        List<List<Integer>> lists = main.pathSum(tree, 22);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static TreeNode createTree(int[] numbers,int i){
        int n = numbers.length;
        if(i>=n){
            return null;
        }
        if(numbers[i]==Integer.MIN_VALUE+11){
            return null;
        }
        TreeNode root = new TreeNode(numbers[i]);
        root.left = createTree(numbers,2*i+1);
        root.right = createTree(numbers,2*i+2);
        return root;
    }
}

class Solution路径之和2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null){
            return lists;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root,lists,path,targetSum);
        return lists;
    }

    public void dfs(TreeNode root,List<List<Integer>> path,
                    Deque<Integer> deque, int targetSum){
        //左子树或者右子树为空
        if(root==null){
            return;
        }

        //叶子节点，但是值不相等
        if(root.left==null&&root.right==null&&targetSum-root.val!=0){
            return;
        }
        if(root.left==null&&root.right==null&&targetSum-root.val==0){
            deque.add(root.val);
            path.add(new ArrayList<>(deque));
            deque.removeLast();
            return;
        }

        deque.addLast(root.val);
        targetSum = targetSum-root.val;
        dfs(root.left,path,deque,targetSum);
        dfs(root.right,path,deque,targetSum);
        deque.removeLast();
    }
}