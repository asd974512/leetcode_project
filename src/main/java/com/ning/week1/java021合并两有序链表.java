package com.ning.week1;

import com.ning.common.ListNode;

import java.util.List;

/**
 * 2022/3/3 09:05
 * 2022/3/3 11:01
 */

public class java021合并两有序链表 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);

        printList(list1);
        printList(list2);
        System.out.println("******************");

        Solution021 solution021 = new Solution021();
        ListNode node = solution021.mergeTwoLists(list1, list2);
        printList(list1);
        printList(list2);

        printList(node);


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
 */




class Solution021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}


/*class Solution021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        //找到list1和list2开头最小的那个
        ListNode point1 = list1.val > list2.val ? list2 : list1;
        //point1是list1，那么point2就是list2.反之一样
        ListNode point2 = point1 == list1 ? list2 : list1;

        ListNode head = point1;
        //返回truehead
        ListNode truehead = head;

        point1 = point1.next;

        while (point1 != null && point2 != null) {
            if (point1.val <= point2.val) {
                head.next = point1;
                point1 = point1.next;
            } else {
                head.next = point2;
                point2 = point2.next;
            }
            head = head.next;
        }
        if (point1 != null) {
            head.next = point1;
        }
        if (point2 != null) {
            head.next = point2;
        }
        return truehead;
    }
}
*/