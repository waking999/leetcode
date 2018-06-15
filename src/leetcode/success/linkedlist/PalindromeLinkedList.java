package leetcode.success.linkedlist;

import common.ListNode;

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



}
