package leetcode.success.linkedlist;

import java.util.List;

import common.ListNode;
import leetcode.success.comm.Util;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode tmpHead = new ListNode(Integer.MIN_VALUE);
		ListNode index = head;

		tmpHead.next = index.next.next;
		ListNode tmpNext = index.next;
		index.next = tmpHead.next;
		tmpNext.next = index;
		head = tmpNext;

		index = tmpHead.next;

		ListNode start = head.next;
		while (index != null) {
			if (index.next == null) {
				return head;
			}
			tmpHead.next = index.next.next;
			tmpNext = index.next;
			index.next = tmpHead.next;
			tmpNext.next = index;

			start.next = tmpNext;
			start = tmpNext.next;
			index = tmpHead.next;

		}

		return head;
	}

	public static void main(String[] args) {
		SwapNodesinPairs s = new SwapNodesinPairs();

		int[] nums;
		ListNode head;
		int[] expect;
		List<Integer> output;

		nums = new int[] { 1, 2, 3, 4 };
		head = ListNode.constructListNode(nums);
		head = s.swapPairs(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] { 2, 1, 4, 3 };
		Util.verifyUnsort(expect, output, 1);

		nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		head = ListNode.constructListNode(nums);
		head = s.swapPairs(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] { 2, 1, 4, 3, 6, 5, 8, 7 };
		Util.verifyUnsort(expect, output, 2);

		nums = new int[] {};
		head = ListNode.constructListNode(nums);
		head = s.swapPairs(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] {};
		Util.verifyUnsort(expect, output, 3);

		nums = new int[] { 1 };
		head = ListNode.constructListNode(nums);
		head = s.swapPairs(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] { 1 };
		Util.verifyUnsort(expect, output, 4);

		nums = new int[] { 1, 2, 3 };
		head = ListNode.constructListNode(nums);
		head = s.swapPairs(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] { 2, 1, 3 };
		Util.verifyUnsort(expect, output, 5);
	}

}
