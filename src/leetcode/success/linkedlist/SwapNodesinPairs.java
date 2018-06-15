package leetcode.success.linkedlist;

import java.util.List;

import common.ListNode;

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



}
