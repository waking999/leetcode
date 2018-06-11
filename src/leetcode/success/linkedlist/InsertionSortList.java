package leetcode.success.linkedlist;

import leetcode.success.comm.ListNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.List;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = new ListNode(head.val);
        ;


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

    @Test
    public void testinsertionSortList() {
        InsertionSortList s = new InsertionSortList();

        int[] nums;
        ListNode head;
        int[] expect;
        ListNode outputNode;
        List<Integer> output;
        int seq = 1;

        nums = new int[]{4, 2, 1, 3};
        expect = new int[]{1, 2, 3, 4};
        head = ListNode.constructListNode(nums);
        outputNode = s.insertionSortList(head);
        output = ListNode.unConstructListNode(outputNode);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{-1, 5, 3, 4, 0};
        expect = new int[]{-1, 0, 3, 4, 5};
        head = ListNode.constructListNode(nums);
        outputNode = s.insertionSortList(head);
        output = ListNode.unConstructListNode(outputNode);
        Util.verifyUnsort(expect, output, seq++);

    }
}
