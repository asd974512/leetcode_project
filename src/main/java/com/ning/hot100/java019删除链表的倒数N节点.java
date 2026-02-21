package com.ning.hot100;

import com.ning.common.ListNode;

import java.util.ArrayList;
import java.util.Scanner;

public class java019删除链表的倒数N节点 {
    public static void main(String[] args) {

    }
}

class Solution019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode rootNode = head;
        ListNode rootNode2 = head;
        ListNode preNode = head;
        while (rootNode != null) {
            length++;
            rootNode = rootNode.next;
        }
        int point = length - n + 1;
        //删除第1个元素
        if (point == 1) {
            return preNode.next;
        }

        while (point > 1) {
            preNode = rootNode2;
            rootNode2 = rootNode2.next;
            point--;
        }
        //当前的rootNode2就是需要删除的节点
        if (rootNode2 != null) {
            preNode.next = rootNode2.next;
        } else {
            preNode.next = null;
        }
        return head;
    }
}
