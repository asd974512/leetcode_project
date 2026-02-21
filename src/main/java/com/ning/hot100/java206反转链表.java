package com.ning.hot100;

import com.ning.common.ListNode;

public class java206反转链表{
    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode listNode1 = solution206.reverseList(listNode);
        while(listNode1!=null){
            System.out.print(listNode1.val+" ");
            listNode1 = listNode1.next;
        }
    }
}

class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        //只有1个节点的情况
        if(head.next ==null){
            return head;
        }
        ListNode p1 =head;
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;
        //反转链表，记得第一个节点要指向null
        p1.next = null;
        //p1->p2->p3
        //第一次肯定不会为null，p2表示的就是他的下一个节点，
        // 因此p2需要指向p1，p3一直是p2的原本下一个节点
        //一直到p2等于null，那么p1就是最后一个节点
        while(p2!=null){
            //先假设p3不为null
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if(p3!=null){
                p3 = p3.next;
            }
        }
        return p1;
    }
}
