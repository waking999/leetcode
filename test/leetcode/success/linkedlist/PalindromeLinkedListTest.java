package leetcode.success.linkedlist;

import common.ListNode;
import org.junit.Test;

import static common.Util.verify;

public class PalindromeLinkedListTest {
    @Test
    public void test1() {
        PalindromeLinkedList s = new PalindromeLinkedList();

        int[] nums;
        ListNode head;
        boolean output;
        boolean expect;
        int seq = 0;

        nums = new int[]{1, 2, 3, 2, 1};
        head = ListNode.constructListNode(nums);
        output = s.isPalindrome(head);
        expect = true;
        verify(expect, output, seq++);

        nums = new int[]{1, 2, 3, 2};
        head = ListNode.constructListNode(nums);
        output = s.isPalindrome(head);
        expect = false;
        verify(expect, output, seq++);

        nums = new int[]{};
        head = ListNode.constructListNode(nums);
        output = s.isPalindrome(head);
        expect = true;
        verify(expect, output, seq++);

        nums = new int[]{1};
        head = ListNode.constructListNode(nums);
        output = s.isPalindrome(head);
        expect = true;
        verify(expect, output, seq++);

        nums = new int[]{1, 2, 3, 3, 2, 1};
        head = ListNode.constructListNode(nums);
        output = s.isPalindrome(head);
        expect = true;
        verify(expect, output, seq++);

    }
}
