package leetcode.success.linkedlist;

import common.ListNode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;

        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }


        int pos = length - n;
        if (pos == 0) {
            return head.next;
        }
        int count = 1;
        tmp = head;
        while (count < pos) {
            tmp = tmp.next;
            count++;
        }
        tmp.next = tmp.next.next;

        return head;
    }

}
