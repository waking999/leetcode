package leetcode.success.linkedlist;

import java.util.List;

import leetcode.success.comm.ListNode;
import leetcode.success.comm.Util;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode h = new ListNode(0);
		ListNode curr = h;

		while (l1 != null && l2 != null) {
			if (l1.val >= l2.val) {
				curr.next = l2;
				l2 = l2.next;
			} else {
				curr.next = l1;
				l1 = l1.next;
			}
			curr = curr.next;
		}
		if (l1 != null)
			curr.next = l1;
		else if (l2 != null)
			curr.next = l2;
		return h.next;
	}

	public static void main(String[] args) {
		MergeTwoSortedLists s = new MergeTwoSortedLists();

		int[] nums1;
		ListNode l1;
		int[] nums2;
		ListNode l2;
		ListNode l3;
		int[] expect;
		List<Integer> output;
		int seq = 0;

		nums1 = new int[] { 1, 3, 5 };
		nums2 = new int[] { 2, 4, 6 };
		l1 = ListNode.constructListNode(nums1);
		l2 = ListNode.constructListNode(nums2);
		l3 = s.mergeTwoLists(l1, l2);
		expect = new int[] { 1, 2, 3, 4, 5, 6 };
		output = ListNode.unConstructListNode(l3);
		Util.verifyUnsort(expect, output, seq++);

	}

}
