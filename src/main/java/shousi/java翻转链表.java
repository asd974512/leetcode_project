package shousi;

import com.ning.common.ListNode;

import java.util.Scanner;

public class java翻转链表 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        ListNode pre = new ListNode();
        ListNode tmp = pre;
        for (int i = 0; i < nums.length; i++) {
            tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
        }
        java翻转链表 main = new java翻转链表();
        ListNode node = main.reverseList(pre.next);
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;
        p1.next = null;
        while (p2 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if (p3 != null) {
                p3 = p3.next;
            }
        }
        return p1;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

}
