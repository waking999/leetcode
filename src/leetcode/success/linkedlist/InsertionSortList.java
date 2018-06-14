package leetcode.success.linkedlist;

import common.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = new ListNode(head.val);


        ListNode p = head.next;
        while (p != null) {
            int val = p.val;
            ListNode tmpP = dummy;

            while (tmpP.next != null && val > tmpP.next.val) {
                tmpP = tmpP.next;
            }

            ListNode tmpPNext = tmpP.next;

            tmpP.next = new ListNode(val);
            tmpP.next.next = tmpPNext;

            p = p.next;
        }

        return dummy.next;
    }


}
