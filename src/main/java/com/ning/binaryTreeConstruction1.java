package com.ning;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 层序构建二叉树
 */
public class binaryTreeConstruction1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int[] numbers = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            numbers[i] = Integer.parseInt(strs[i]);
        }
        TreeNode root = createTree2(numbers,0);
        xian(root);
        System.out.println();
        zhong(root);
        System.out.println();
    }

    public static void zhong(TreeNode node){
        if(node==null){
            return;
        }
        zhong(node.left);
        System.out.print(node.val+" ");
        zhong(node.right);
    }

    public static void xian(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        xian(node.left);
        xian(node.right);
    }

    public static TreeNode createTree2(int[] numbers,int i){
        if(numbers.length==0){
            return null;
        }
        if(i>=numbers.length){
            return null;
        }
        if(numbers[i]==0){
            return null;
        }
        TreeNode node = new TreeNode(numbers[i]);
        node.left = createTree2(numbers,2*i+1);
        node.right = createTree2(numbers,2*i+2);
        return node;
    }

//    public static TreeNode createTree(int[] numbers){
//        TreeNode root = new TreeNode(numbers[0]);
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        //先加一个节点进队列，index指的是数组下一个节点
//        int index = 1;
//        deque.add(root);
//        while(index<numbers.length){
//            TreeNode node = deque.pollFirst();
//            //先判断node的左子树，默认0为空节点
//            if(index<numbers.length){
//                if(numbers[index]!=0){
//                    TreeNode leftNode = new TreeNode(numbers[index]);
//                    node.left = leftNode;
//                    //注意，需要把左子树的节点也添加到队列中
//                    deque.addLast(leftNode);
//                    index++;
//                }else{
//                    //是空节点，什么也不用干，自动为null了
//                    index++;
//                }
//            }
//            if(index<numbers.length){
//                if(numbers[index]!=0){
//                    TreeNode rightNode = new TreeNode(numbers[index]);
//                    node.right = rightNode;
//                    //注意，需要把右子树的节点也添加到队列中
//                    deque.addLast(rightNode);
//                    index++;
//                }else{
//                    //是空节点，什么也不用干，自动为null了
//                    index++;
//                }
//            }
//        }
//        return root;
//    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){ }
        TreeNode(int val){
            this.val = val;
        }
    }
}
