package com.ning.hot100;

import com.ning.common.ListNode;

import java.util.List;

public class java023合并K个升序链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        ListNode[] nodes = {node1,node2,node3};

        Solution023 solution023 = new Solution023();
        ListNode node = solution023.mergeKLists(nodes);
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}

class Solution023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        int length = lists.length;
        int[] index = new int[length];
        ListNode node = new ListNode(10);
        ListNode node2 = node;

        //记录是哪个数组
        int location = 0;
        //记录链表走到头的个数，若是等于length，就表示都走完了
        int null_count = 0;
        //给出list数组的横向遍历->->->->
        while(true) {
            int min = Integer.MAX_VALUE;
            null_count=0;
            //给出的list数组竖向遍历
            for (int i = 0; i < length; i++) {
                //说明这个已经到达末尾了
                if (lists[i] == null) {
                    null_count++;
                    continue;
                }
                int nowValue = lists[i].val;
                //现在这个值小于等于min，他就是最小的
                if (min >= nowValue) {
                    min = nowValue;
                    location = i;
                }
            }
            //说明都走到末尾了
            if(null_count==length){
                break;
            }
            node.next = new ListNode(lists[location].val);
            node = node.next;
            lists[location] = lists[location].next;
        }
        return node2.next;
    }
}
