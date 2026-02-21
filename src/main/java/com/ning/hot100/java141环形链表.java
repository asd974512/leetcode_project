package com.ning.hot100;

import com.ning.common.ListNode;

import java.util.HashSet;
import java.util.List;

public class java141环形链表 {
    public static void main(String[] args) {
        Solution141 solution141 = new Solution141();
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        node1.next = new ListNode(0);
        node1.next = new ListNode(4);
        node1.next.next = node1;
        System.out.println(solution141.hasCycle(node));
    }
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
//        return process1(head);
        return process2(head);
    }

    public boolean process2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public boolean process1(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        if (head == null) {
            return false;
        }
        while (head != null) {
            if (listNodes.contains(head)) {
                return true;
            } else {
                listNodes.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
