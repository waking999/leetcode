package leetcode.attempt;

import java.util.List;

import leetcode.success.comm.ListNode;
import leetcode.success.comm.Util;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		 
		head = removeDuplicatedStart(head);
		if(head==null) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = p1.next;
		ListNode p3 = null;
		if (p2 != null) {
			p3 = p2.next;
		}
		while (p3 != null) {
			if (p2.val != p3.val) {
				p1 = p2;
				p2 = p3;
				p3 = p3.next;
			} else {

				while (p3 != null && p2.val == p3.val) {
					p3 = p3.next;
				}
				if (p3 != null) {
					p1.next = p3;
					p2 = p1.next;
					p3 = p2 != null ? p2.next : null;
				} else {
					p1.next = p3;
				}
			}
		}

		return head;
	}

	private ListNode removeDuplicatedStart(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head.next;
		if (p2 == null) {
			return head;
		}

		while (p2 != null && p1.val == p2.val) {
			p2 = p2.next;
		}
		if (p1.next != p2) {
			head = p2;
		}
		if (head == null) {
			return null;
		}
		p1 = head;
		p2 = head.next;
		if (p2 != null && p1.val == p2.val) {
			return removeDuplicatedStart(head);
		} else {
			return head;
		}
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedListII s = new RemoveDuplicatesfromSortedListII();

		int[] nums;
		ListNode head;
		int[] expect;
		List<Integer> output;
		int seq = 0;

		nums = new int[] { 1, 2, 3, 3, 4, 4, 5 };
		head = ListNode.constructListNode(nums);
		head = s.deleteDuplicates(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] { 1, 2, 5 };
		Util.verifyUnsort(expect, output, ++seq);

		nums = new int[] { 1, 2, 2, 3, 3, 4, 4, 5 };
		head = ListNode.constructListNode(nums);
		head = s.deleteDuplicates(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] { 1, 5 };
		Util.verifyUnsort(expect, output, ++seq);

		nums = new int[] { 1, 1, 1, 2, 3 };
		head = ListNode.constructListNode(nums);
		head = s.deleteDuplicates(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] { 2, 3 };
		Util.verifyUnsort(expect, output, ++seq);

		nums = new int[] { 1, 1 };
		head = ListNode.constructListNode(nums);
		head = s.deleteDuplicates(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] {};
		Util.verifyUnsort(expect, output, ++seq);

		nums = new int[] { 1, 2, 2 };
		head = ListNode.constructListNode(nums);
		head = s.deleteDuplicates(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] { 1 };
		Util.verifyUnsort(expect, output, ++seq);

		nums = new int[] { 1, 1, 2 };
		head = ListNode.constructListNode(nums);
		head = s.deleteDuplicates(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] { 2 };
		Util.verifyUnsort(expect, output, ++seq);

		nums = new int[] { 1, 2, 2, 2 };
		head = ListNode.constructListNode(nums);
		head = s.deleteDuplicates(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] { 1 };
		Util.verifyUnsort(expect, output, ++seq);

		nums = new int[] { 1, 1, 2, 2 };
		head = ListNode.constructListNode(nums);
		head = s.deleteDuplicates(head);
		output = ListNode.unConstructListNode(head);
		expect = new int[] {};
		Util.verifyUnsort(expect, output, ++seq);
	}

}
