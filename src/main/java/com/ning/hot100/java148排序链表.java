package com.ning.hot100;

import com.ning.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;

public class java148排序链表 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next= new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        Solution148 solution148 = new Solution148();
        ListNode listNode = solution148.sortList(node);
        while(listNode!=null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }
}

class Solution148 {
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode root1 = head;
        while(root1!=null){
            list.add(root1);
            root1 = root1.next;
        }
        //使用自己的比较器进行sort排序
        list.sort(new My_Comparator());
        //注意有i+1，所以是list.size()-1
        for(int i=0;i<list.size()-1;i++){
            list.get(i).next = list.get(i+1);
        }
        //记得把最后一个节点的next置为null
        list.get(list.size()-1).next=null;
        return list.get(0);
    }

    //自己写比较器，注意范式
    static class My_Comparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val- o2.val;
        }
    }
}
