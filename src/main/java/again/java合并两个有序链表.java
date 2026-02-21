package again;

import java.util.Scanner;

public class java合并两个有序链表 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] strs1 = s1.split(" ");
        String[] strs2 = s2.split(" ");
        int[] nums1 = new int[strs1.length];
        int[] nums2 = new int[strs2.length];
        for (int i = 0; i < strs1.length; i++) {
            nums1[i] = Integer.parseInt(strs1[i]);
        }
        for (int i = 0; i < strs2.length; i++) {
            nums2[i] = Integer.parseInt(strs2[i]);
        }
        LinkNode root1 = new LinkNode(-1);
        LinkNode root1_1 = root1;
        LinkNode root1_2 = root1;
        LinkNode root2 = new LinkNode(-1);
        LinkNode root2_1 = root2;
        LinkNode root2_2 = root2;
        for (int i = 0; i < nums1.length; i++) {
            LinkNode node = new LinkNode(nums1[i]);
            root1_1.next = node;
            root1_1 = root1_1.next;
        }
        for (int i = 0; i < nums2.length; i++) {
            LinkNode node = new LinkNode(nums2[i]);
            root2_1.next = node;
            root2_1 = root2_1.next;
        }
        /**
         *试试输入的链表遍历如何，正常，说明输入没错
         */
//        root1_2 = root1_2.next;
//        while (root1_2!=null){
//            System.out.print(root1_2.val+" ");
//            root1_2 = root1_2.next;
//        }
//        System.out.println();
//        root2_2 = root2_2.next;
//        while (root2_2!=null){
//            System.out.print(root2_2.val+" ");
//            root2_2 = root2_2.next;
//        }
        LinkNode node = solution(root1_2.next, root2_2.next);
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    public static LinkNode solution(LinkNode root1, LinkNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        if (root1 == null && root2 == null) {
            return null;
        }
        LinkNode head = new LinkNode(-1);
        LinkNode head1 = head;
        while (root1 != null && root2 != null) {
            if (root1.val >= root2.val) {
                head1.next = new LinkNode(root2.val);
                head1 = head1.next;
                root2 = root2.next;
            } else {
                head1.next = new LinkNode(root1.val);
                head1 = head1.next;
                root1 = root1.next;
            }
        }
        head1.next = root1 == null ? root2 : root1;
        return head.next;
    }


    static class LinkNode {
        int val;
        LinkNode next;

        LinkNode(int val) {
            this.val = val;
        }
    }
}

