package leetcode.success.linkedlist;

import common.ListNode;
import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class LinkedListCycleIITest {
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
        verifyUnsort(expect, output, seq++);


        nums = new int[]{4, 5, 6, 7};
        childIdx = new int[]{1, 2, 3, 0};
        head = ListNode.constructListNode(nums, childIdx);
        expect = new int[]{4, 5, 6, 7};
        outputNode = s.detectCycle(head);
        output = ListNode.unConstructListNode(outputNode, true);
        verifyUnsort(expect, output, seq++);

        nums = new int[]{4, 5, 6, 7};
        childIdx = new int[]{1, 2, 3, 2};
        head = ListNode.constructListNode(nums, childIdx);
        expect = new int[]{6, 7};
        outputNode = s.detectCycle(head);
        output = ListNode.unConstructListNode(outputNode, true);
        verifyUnsort(expect, output, seq++);


        nums = new int[]{3, 2, 0, -4};
        childIdx = new int[]{1, 2, 3, 1};
        head = ListNode.constructListNode(nums, childIdx);
        expect = new int[]{2, 0, -4};
        outputNode = s.detectCycle(head);
        output = ListNode.unConstructListNode(outputNode, true);
        verifyUnsort(expect, output, seq++);

    }
}
