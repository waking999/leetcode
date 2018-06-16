package leetcode.success.linkedlist;

import common.ListNode;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int headALen = 0;
        int headBLen = 0;

        ListNode headA1 = headA;
        ListNode headB1 = headB;

        while (headA1.next != null) {
            headA1 = headA1.next;
            headALen++;
        }
        while (headB1.next != null) {
            headB1 = headB1.next;
            headBLen++;
        }
        if (headA1.val != headB1.val) {
            return null;
        }
        int diff = headALen - headBLen;
        headA1 = headA;
        headB1 = headB;

        int count = 0;
        if (diff > 0) {
            while (count < diff) {
                headA1 = headA1.next;
                count++;
            }
        } else if (diff < 0) {
            diff = 0 - diff;
            while (count < diff) {
                headB1 = headB1.next;
                count++;
            }
        }

        while (headA1.val != headB1.val) {
            headA1 = headA1.next;
            headB1 = headB1.next;
        }

        return headA1;
    }


}
