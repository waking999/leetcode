package leetcode.success.linkedlist;

import common.ListNode;
import common.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void testdetectCycle() {
        LinkedListCycleII s = new LinkedListCycleII();

        int[] nums;
        int[] childIdx;
        ListNode head;
        int[] expect;
        ListNode outputNode;
        List<Integer> output;
        int seq = 1;


        nums = new int[]{4, 5, 6, 7};
        childIdx = new int[]{1, 2, 3, TreeNode.IMPOSSIBLE_VALUE};
        head = ListNode.constructListNode(nums, childIdx);
        expect = new int[]{};
        outputNode = s.detectCycle(head);
        output = ListNode.unConstructListNode(outputNode);
        Util.verifyUnsort(expect, output, seq++);


        nums = new int[]{4, 5, 6, 7};
        childIdx = new int[]{1, 2, 3, 0};
        head = ListNode.constructListNode(nums, childIdx);
        expect = new int[]{4, 5, 6, 7};
        outputNode = s.detectCycle(head);
        output = ListNode.unConstructListNode(outputNode, true);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{4, 5, 6, 7};
        childIdx = new int[]{1, 2, 3, 2};
        head = ListNode.constructListNode(nums, childIdx);
        expect = new int[]{6, 7};
        outputNode = s.detectCycle(head);
        output = ListNode.unConstructListNode(outputNode, true);
        Util.verifyUnsort(expect, output, seq++);


        nums = new int[]{3, 2, 0, -4};
        childIdx = new int[]{1, 2, 3, 1};
        head = ListNode.constructListNode(nums, childIdx);
        expect = new int[]{2, 0, -4};
        outputNode = s.detectCycle(head);
        output = ListNode.unConstructListNode(outputNode, true);
        Util.verifyUnsort(expect, output, seq++);

    }
}
