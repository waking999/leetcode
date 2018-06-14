package leetcode.success.linkedlist;

import common.ListNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.List;

public class PartitionListTest {

    @Test
    public void testpartition() {
        PartitionList s = new PartitionList();

        int[] nums;
        ListNode head;
        int x;
        int[] expect;
        ListNode outputNode;
        List<Integer> output;
        int seq = 1;

        nums = new int[]{1, 4, 3, 2, 5, 2};
        head = ListNode.constructListNode(nums);
        x = 3;
        expect = new int[]{1, 2, 2, 4, 3, 5};
        outputNode = s.partition(head, x);
        output = ListNode.unConstructListNode(outputNode);
        Util.verifyUnsort(expect, output, seq++);
    }
}
