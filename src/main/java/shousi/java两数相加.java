package shousi;

import java.util.Scanner;

public class java两数相加 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        ListNode pre1 = new ListNode();
        ListNode tmp1 = pre1;
        ListNode pre2 = new ListNode();
        ListNode tmp2 = pre2;
        for (int i = 0; i < str1.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(str1[i]));
            tmp1.next = node;
            tmp1 = tmp1.next;
        }
        for (int i = 0; i < str2.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(str2[i]));
            tmp2.next = node;
            tmp2 = tmp2.next;
        }
        java两数相加 main = new java两数相加();
        ListNode node = main.addTwoNumbers(pre1.next, pre2.next);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode tmp = root;
        int sum = 0;
        int sign = 0 ;//表示进位
        while (l1 != null || l2 != null) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            sum = value1+value2+sign;
            sign = sum/10; //如果sign等于1，表示需要进位
            sum = sum%10; //sum只能是0-9
            ListNode node = new ListNode(sum);
            tmp.next = node;
            tmp = tmp.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        //l1和l2都循环完了，如果还有进位的话，说明需要在末尾再加一个节点
        if(sign!=0){
            ListNode node = new ListNode(1);
            tmp.next = node;
        }
        return root.next;
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
