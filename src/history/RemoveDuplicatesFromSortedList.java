package history;

import common.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode current = head;
        ListNode next = head.next;

        while (next != null) {
            if (next.val == current.val) {
                current.next = next.next;
                next = current.next;
            } else {
                current = next;
                next = next.next;
            }
        }


        return head;
    }


}
