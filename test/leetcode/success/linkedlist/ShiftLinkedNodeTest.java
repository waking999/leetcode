package leetcode.success.linkedlist;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class ShiftLinkedNodeTest {
    @Test
    public void test1() {
        ShiftLinkedNode s = new ShiftLinkedNode();

        int[] nums;
        ListNode head;
        int m;
        int[] expect;
        ListNode node;
        List<Integer> output;

        nums = new int[]{1, 2, 3, 4, 5, 6};
        head = ListNode.constructListNode(nums);
        m = 2;
        expect = new int[]{3, 4, 5, 6, 1, 2};
        node = s.shiftLeft(head, m);
        output = ListNode.unConstructListNode(node);
        verifyUnsort(expect, output, 1);

        nums = new int[]{1, 2, 3, 4, 5, 6};
        head = ListNode.constructListNode(nums);
        m = 3;
        expect = new int[]{4, 5, 6, 1, 2, 3};
        node = s.shiftLeft(head, m);
        output = ListNode.unConstructListNode(node);
        verifyUnsort(expect, output, 2);

    }
}
