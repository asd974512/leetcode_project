package com.ning.week1;


import com.ning.common.ListNode;

public class java083排序链表重复元素 {

    public static void main(String[] args) {
        Solution083 solution083 = new Solution083();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(5);
        ListNode listNode083 = solution083.deleteDuplicates(node);
        printList(listNode083);

    }

    public static void printList(ListNode node) {
        System.out.print("[  ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print("  ]");
        System.out.println();
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution083 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode newHead = head;
        ListNode changeNode = newHead;

        while(newHead.next !=null){
            if(newHead.val!= newHead.next.val){
                newHead = newHead.next;
            }else if(newHead.val== newHead.next.val){
                if(newHead.next.next!=null){
                    newHead.next = newHead.next.next;
                }else{
                    newHead.next = null;
                }
            }
        }
        return changeNode;
    }
}
