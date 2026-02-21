package shousi;

import java.util.Scanner;

public class java合并升序链表 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        ListNode pre1 = new ListNode();
        ListNode tmp1 = pre1;
        ListNode pre2 = new ListNode();
        ListNode tmp2 = pre2;
        for(int i=0;i<str1.length;i++){
            tmp1.next = new ListNode(Integer.parseInt(str1[i]));
            tmp1 = tmp1.next;
        }
        for(int i=0;i<str2.length;i++){
            tmp2.next = new ListNode(Integer.parseInt(str2[i]));
            tmp2 = tmp2.next;
        }
        java合并升序链表 main = new java合并升序链表();
        ListNode node = main.mergeTwoLists(pre1.next, pre2.next);
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode root2 = root;
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        while(list1!=null && list2!=null){
           ListNode node =  list1.val>=list2.val?list2:list1;
           root.next = node;
           root = root.next;
           if(node==list1){
               list1 = list1.next;
           }
           if(node==list2){
               list2 = list2.next;
           }
        }
        root.next = list1==null?list2:list1;
        return root2.next;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }
}
