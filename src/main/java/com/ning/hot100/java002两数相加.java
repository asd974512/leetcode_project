package com.ning.hot100;

import com.ning.common.ListNode;

import java.util.*;

public class java002两数相加 {
    public static void main(String[] args) {

        Solution002 solution002 = new Solution002();
        ListNode node1 = new ListNode(9);
//        node1.next = new ListNode(4);
//        node1.next.next =new ListNode(9);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(9);
        node2.next.next= new ListNode(9);
        node2.next.next.next = new ListNode(9);
        node2.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next= new ListNode(9);
        node2.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next.next= new ListNode(9);
        node2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode listNode = solution002.addTwoNumbers(node1, node2);
        printList(listNode);
    }

    public static void printList(ListNode node){
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}

class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();
        while(l1!=null){
            list1.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            list2.add(l2.val);
            l2 = l2.next;
        }
        //true为进位，false表示没有进位
        boolean flag =false;
        int value = 0;
        while(!list1.isEmpty() && !list2.isEmpty()){
            value = value + list1.removeFirst() + list2.removeFirst();
            if(value>=10){
                flag = true;
                list3.add(value-10);
            }else{
                flag = false;
                list3.add(value);
            }
            if(flag){
                value=1;
            }else{
                value=0;
            }
        }
        //list1还剩下
        while(!list1.isEmpty()){
            value = value +list1.removeFirst();
            if(value>=10){
                flag = true;
                list3.add(value-10);
            }else{
                flag = false;
                list3.add(value);
            }
            if(flag){
                value=1;
            }else{
                value=0;
            }
        }
        //list2还剩下
        while(!list2.isEmpty()){
            value = value +list2.removeFirst();
            if(value>=10){
                flag = true;
                list3.add(value-10);
            }else{
                flag = false;
                list3.add(value);
            }
            if(flag){
                value=1;
            }else{
                value=0;
            }
        }
        //最后一位进位了
        if(flag){
            list3.add(1);
        }

        ListNode listNode = new ListNode();
        ListNode root = listNode;
        while(!list3.isEmpty()){
            listNode.next = new ListNode(list3.removeFirst());
            listNode = listNode.next;
        }
        return root.next;
    }
}
