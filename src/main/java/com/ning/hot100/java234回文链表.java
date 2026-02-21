package com.ning.hot100;

import com.ning.common.ListNode;

import java.util.Stack;

public class java234回文链表 {
    public static void main(String[] args) {

    }
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        if(head==null){
            return false;
        }
        ListNode root = head;
        while(root!=null){
            stack.push(root);
            root = root.next;
        }
        ListNode root2 =head;
        while(root2!=null){
            ListNode pop = stack.pop();
            if(pop.val!=root2.val){
                return false;
            }
            root2=root2.next;
        }
        return true;
    }
}
