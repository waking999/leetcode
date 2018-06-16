package leetcode.success.linkedlist;

import common.ListNode;
import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class RemoveNthNodeFromEndofListTest {
    @Test
    public void test1() {
        RemoveNthNodeFromEndofList s = new RemoveNthNodeFromEndofList();

        int n;
        int[] nums;
        ListNode head;
        int[] expect;
        List<Integer> output;

        nums = new int[]{1, 2, 3, 4, 5};
        head = ListNode.constructListNode(nums);
        n = 2;
        head = s.removeNthFromEnd(head, n);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{1, 2, 3, 5};
        verifyUnsort(expect, output, 1);


        nums = new int[]{1};
        head = ListNode.constructListNode(nums);
        n = 1;
        head = s.removeNthFromEnd(head, n);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{};
        verifyUnsort(expect, output, 2);

        nums = new int[]{1, 2};
        head = ListNode.constructListNode(nums);
        n = 2;
        head = s.removeNthFromEnd(head, n);
        output = ListNode.unConstructListNode(head);
        expect = new int[]{2};
        verifyUnsort(expect, output, 3);
    }
}
