package leetcode.success.linkedlist;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class InsertionSortListTest {
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
        verifyUnsort(expect, output, seq++);

        nums = new int[]{-1, 5, 3, 4, 0};
        expect = new int[]{-1, 0, 3, 4, 5};
        head = ListNode.constructListNode(nums);
        outputNode = s.insertionSortList(head);
        output = ListNode.unConstructListNode(outputNode);
        verifyUnsort(expect, output, seq++);

    }
}
