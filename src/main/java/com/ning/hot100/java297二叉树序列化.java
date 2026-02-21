package com.ning.hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class java297二叉树序列化 {
    public static void main(String[] args) {
        Codec.TreeNode node = new Codec.TreeNode(1);
        node.left = new Codec.TreeNode(2);
        node.right = new Codec.TreeNode(3);
        node.right.left = new Codec.TreeNode(4);
        node.right.right = new Codec.TreeNode(5);
        Codec codec = new Codec();
        String serialize = codec.serialize(node);
        System.out.println(serialize);


    }
}


class Codec {

    public void xian(TreeNode node){
        if(node==null){
//            System.out.print("null,");
            return;
        }
        System.out.print(node.val+",");
        xian(node.left);
        xian(node.right);
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = serProcess(root,"");

        return s.substring(0,s.length()-1);
    }
    //这个是先序的序列化
    public String serProcess(TreeNode root,String str){
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = serProcess(root.left, str);
            str = serProcess(root.right, str);
        }
        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        TreeNode node = process(strs, 0);
        return node;
    }

    //这个是层次的反序列化
    public TreeNode process(String[] strs,int index){
        if(strs.length==0){
            return null;
        }
        if(index>=strs.length){
            return null;
        }
        if(strs[index].equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[index]));
        node.left = process(strs,2*index+1);
        node.right = process(strs,2*index+2);
        return node;
    }
}