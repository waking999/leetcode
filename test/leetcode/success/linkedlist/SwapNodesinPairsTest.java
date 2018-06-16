package leetcode.success.linkedlist;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class SwapNodesinPairsTest {

    @Test
    public void test1() {
        SwapNodesinPairs s = new SwapNodesinPairs();

        int[] nums;
        ListNode head;
        int[] expect;
        List<Integer> output;

        nums = new int[]{1, 2, 3, 4};
        head = ListNode.constructListNode(nums);
        head = s.swapPairs(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{2, 1, 4, 3};
        verifyUnsort(expect, output, 1);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        head = ListNode.constructListNode(nums);
        head = s.swapPairs(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{2, 1, 4, 3, 6, 5, 8, 7};
        verifyUnsort(expect, output, 2);

        nums = new int[]{};
        head = ListNode.constructListNode(nums);
        head = s.swapPairs(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{};
        verifyUnsort(expect, output, 3);

        nums = new int[]{1};
        head = ListNode.constructListNode(nums);
        head = s.swapPairs(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{1};
        verifyUnsort(expect, output, 4);

        nums = new int[]{1, 2, 3};
        head = ListNode.constructListNode(nums);
        head = s.swapPairs(head);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{2, 1, 3};
        verifyUnsort(expect, output, 5);
    }
}
