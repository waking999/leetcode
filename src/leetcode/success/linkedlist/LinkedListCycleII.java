package leetcode.success.linkedlist;

import common.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {


        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }


        if (!hasCycle) {
            return null;
        } else {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return fast;
        }
    }


}
