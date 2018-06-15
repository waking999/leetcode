package leetcode.attempt;

import common.ListNode;
import common.Util;
import org.junit.Test;

import java.util.List;

import static common.Util.*;

public class RemoveDuplicatesfromSortedListIITest {
    @Test
    public void test1() {
        RemoveDuplicatesfromSortedListII s = new RemoveDuplicatesfromSortedListII();

        int[] nums;
        ListNode head;
        int[] expect;
        List<Integer> output;
        int seq = 0;

        nums = new int[]{1, 2, 3, 3, 4, 4, 5};
        head = ListNode.constructListNode(nums);
        head = s.deleteDuplicates(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{1, 2, 5};
        verifyUnsort(expect, output, ++seq);

        nums = new int[]{1, 2, 2, 3, 3, 4, 4, 5};
        head = ListNode.constructListNode(nums);
        head = s.deleteDuplicates(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{1, 5};
        verifyUnsort(expect, output, ++seq);

        nums = new int[]{1, 1, 1, 2, 3};
        head = ListNode.constructListNode(nums);
        head = s.deleteDuplicates(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{2, 3};
        verifyUnsort(expect, output, ++seq);

        nums = new int[]{1, 1};
        head = ListNode.constructListNode(nums);
        head = s.deleteDuplicates(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{};
        verifyUnsort(expect, output, ++seq);

        nums = new int[]{1, 2, 2};
        head = ListNode.constructListNode(nums);
        head = s.deleteDuplicates(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{1};
        verifyUnsort(expect, output, ++seq);

        nums = new int[]{1, 1, 2};
        head = ListNode.constructListNode(nums);
        head = s.deleteDuplicates(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{2};
        verifyUnsort(expect, output, ++seq);

        nums = new int[]{1, 2, 2, 2};
        head = ListNode.constructListNode(nums);
        head = s.deleteDuplicates(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{1};
        verifyUnsort(expect, output, ++seq);

        nums = new int[]{1, 1, 2, 2};
        head = ListNode.constructListNode(nums);
        head = s.deleteDuplicates(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{};
        verifyUnsort(expect, output, ++seq);
    }
}
