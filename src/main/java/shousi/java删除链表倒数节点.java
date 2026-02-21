package shousi;

import com.ning.common.ListNode;

import java.util.Scanner;

public class java删除链表倒数节点 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] ints = new int[s.length-1];
        ListNode pre = new ListNode();
        ListNode tmp = pre;
        for(int i=0;i<ints.length;i++){
           ints[i] =  Integer.parseInt(s[i]);
           tmp.next = new ListNode(ints[i]);
           tmp = tmp.next;
        }
        java删除链表倒数节点 main = new java删除链表倒数节点();
        ListNode node = main.removeNthFromEnd(pre.next, Integer.parseInt(s[s.length - 1]));
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        ListNode tmp2 = head;
        ListNode pre = head;
        int length =0;
        while(tmp!=null){
            length++;
            tmp = tmp.next;
        }
        int target = length-n+1;
        if(target==0){
            return head.next;
        }else{
            for(int i=1;i<=length;i++){
                if(i==target){
                    pre.next = tmp2.next;
                    tmp2.next= null;
                    break;
                }
                pre = tmp2;
                tmp2 = tmp2.next;
            }
            return head;
        }
    }
}
