package com.ning.hot100;

import com.ning.common.ListNode;

public class java142环形节点2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        node1.next = new ListNode(0);
        node1.next = new ListNode(4);
        node1.next.next = node1;
        Solution142 solution142 = new Solution142();
        ListNode listNode = solution142.detectCycle(node);
        System.out.println(listNode.val);
    }
}

class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast!=slow){
            if(fast.next==null || fast.next.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
