package com.ning.hot100;

import com.ning.common.ListNode;

public class java160相交链表 {
    public static void main(String[] args) {

    }
}

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        ListNode tmpA2 = headA;
        ListNode tmpB2 = headB;
        while (tmpA != null) {
            lengthA++;
            tmpA = tmpA.next;
        }
        while (tmpB != null) {
            lengthB++;
            tmpB = tmpB.next;
        }

        boolean isALong = lengthA >= lengthB ? true : false;
        if (isALong) {
            int num = lengthA - lengthB;
            while (num > 0) {
                tmpA2 = tmpA2.next;
                num--;
            }
        } else {
            int num = lengthB - lengthA;
            while (num > 0) {
                tmpB2 = tmpB2.next;
                num--;
            }
        }
        while (tmpA2 != null && tmpB2 != null) {
            if(tmpA2==tmpB2){
                return tmpA2;
            }else{
                tmpA2 = tmpA2.next;
                tmpB2 = tmpB2.next;
            }
        }
        return null;
    }
}
