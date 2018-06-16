package leetcode.success.linkedlist;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class RemoveLinkedListElementsTest {
    @Test
    public void test1() {
        RemoveLinkedListElements s = new RemoveLinkedListElements();

        int[] nums;
        ListNode head;
        int val;
        ListNode outputNode;
        List<Integer> output;
        int[] expect;
        int seq = 1;

        nums = new int[]{1, 2, 6, 3, 4, 5, 6};
        head = ListNode.constructListNode(nums);
        val = 6;
        outputNode = s.removeElements(head, val);
        expect = new int[]{1, 2, 3, 4, 5};
        output = ListNode.unConstructListNode(outputNode);
        verifyUnsort(expect, output, seq++);

        nums = new int[]{1};
        head = ListNode.constructListNode(nums);
        val = 1;
        outputNode = s.removeElements(head, val);
        expect = new int[]{};
        output = ListNode.unConstructListNode(outputNode);
        verifyUnsort(expect, output, seq++);

        nums = new int[]{1};
        head = ListNode.constructListNode(nums);
        val = 2;
        outputNode = s.removeElements(head, val);
        expect = new int[]{1};
        output = ListNode.unConstructListNode(outputNode);
        verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 1};
        head = ListNode.constructListNode(nums);
        val = 1;
        outputNode = s.removeElements(head, val);
        expect = new int[]{};
        output = ListNode.unConstructListNode(outputNode);
        verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 2, 2, 1};
        head = ListNode.constructListNode(nums);
        val = 2;
        outputNode = s.removeElements(head, val);
        expect = new int[]{1, 1};
        output = ListNode.unConstructListNode(outputNode);
        verifyUnsort(expect, output, seq++);

    }
}
