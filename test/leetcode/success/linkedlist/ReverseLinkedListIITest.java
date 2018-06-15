package leetcode.success.linkedlist;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class ReverseLinkedListIITest {
    @Test
    public void testreverseBetween() {
        ReverseLinkedListII s = new ReverseLinkedListII();

        int[] nums;
        ListNode head;
        int m;
        int n;
        int[] expect;
        List<Integer> output;
        ListNode outputNode;
        int seq = 0;


        nums = new int[]{1, 2, 3, 4, 5};
        m = 2;
        n = 4;
        expect = new int[]{1, 4, 3, 2, 5};
        head = ListNode.constructListNode(nums);
        outputNode = s.reverseBetween(head, m, n);
        output = ListNode.unConstructListNode(outputNode);
        verifyUnsort(expect, output, seq++);


        nums = new int[]{3, 5};
        m = 1;
        n = 2;
        expect = new int[]{5, 3};
        head = ListNode.constructListNode(nums);
        outputNode = s.reverseBetween(head, m, n);
        output = ListNode.unConstructListNode(outputNode);
        verifyUnsort(expect, output, seq++);


    }
}
