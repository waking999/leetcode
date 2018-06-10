package leetcode.success.linkedlist;

import leetcode.success.comm.ListNode;
import leetcode.success.comm.Util;

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode s = head;
		ListNode r = head;
		ListNode f = head;

		ListNode pre = null;
		while (f != null && f.next != null) {

			f = f.next.next;
			s = s.next;
			ListNode next = r.next;
			r.next = pre;
			pre = r;
			r = next;

		}
		if(f!=null) {
			//odd
			s=s.next;
		}
		while (s != null) {
			if (pre.val != s.val) {
				return false;
			}
			s = s.next;
			pre = pre.next;

		}

		return true;

	}

	public static void main(String[] args) {
		PalindromeLinkedList s = new PalindromeLinkedList();

		int[] nums;
		ListNode head;
		boolean output;
		boolean expect;
		int seq = 0;

		nums = new int[] { 1, 2, 3, 2, 1 };
		head = ListNode.constructListNode(nums);
		output = s.isPalindrome(head);
		expect = true;
		Util.verify(expect, output, seq++);

		nums = new int[] { 1, 2, 3, 2 };
		head = ListNode.constructListNode(nums);
		output = s.isPalindrome(head);
		expect = false;
		Util.verify(expect, output, seq++);

		nums = new int[] {};
		head = ListNode.constructListNode(nums);
		output = s.isPalindrome(head);
		expect = true;
		Util.verify(expect, output, seq++);

		nums = new int[] { 1 };
		head = ListNode.constructListNode(nums);
		output = s.isPalindrome(head);
		expect = true;
		Util.verify(expect, output, seq++);

		nums = new int[] { 1, 2, 3, 3, 2, 1 };
		head = ListNode.constructListNode(nums);
		output = s.isPalindrome(head);
		expect = true;
		Util.verify(expect, output, seq++);

	}

}
