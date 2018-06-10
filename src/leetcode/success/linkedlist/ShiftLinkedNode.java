package leetcode.success.linkedlist;

import java.util.List;

import leetcode.success.comm.ListNode;
import leetcode.success.comm.Util;

public class ShiftLinkedNode {
	public ListNode shiftLeft(ListNode head, int m) {
		int count = 0;
		ListNode tmp = head;
		while (tmp != null) {
			count++;
			tmp = tmp.next;
		}
		m = m % count;
		ListNode l = rotate(head, m);
		int i = 1;
		tmp = head;
		while (i < m) {
			tmp = tmp.next;
			i++;
		}
		ListNode r = rotate(tmp.next, count - m);
		i = 1;
		tmp = l;
		while (i < m) {
			tmp = tmp.next;
			i++;
		}
		tmp.next = r;
		l = rotate(l, count);

		return l;
	}

	private ListNode rotate(ListNode head, int m) {
		ListNode oriPointer = head;
		int j = 1;
		while (j < m) {
			oriPointer = oriPointer.next;
			j++;
		}

		ListNode ret = new ListNode(oriPointer.val);
		ListNode newPointer = ret;
		while (m > 1) {
			int i = 1;
			oriPointer = head;
			while (i < m - 1) {
				oriPointer = oriPointer.next;
				i++;
			}
			newPointer.next = new ListNode(oriPointer.val);
			newPointer = newPointer.next;
			m--;
		}
		return ret;

	}

	public static void main(String[] args) {
		ShiftLinkedNode s = new ShiftLinkedNode();

		int[] nums;
		ListNode head;
		int m;
		int[] expect;
		ListNode node;
		List<Integer> output;

		nums = new int[] { 1, 2, 3, 4, 5, 6 };
		head = ListNode.constructListNode(nums);
		m = 2;
		expect = new int[] { 3, 4, 5, 6, 1, 2 };
		node = s.shiftLeft(head, m);
		output = ListNode.unConstructListNode(node);
		Util.verifyUnsort(expect, output, 1);

		nums = new int[] { 1, 2, 3, 4, 5, 6 };
		head = ListNode.constructListNode(nums);
		m = 3;
		expect = new int[] { 4, 5, 6, 1, 2, 3 };
		node = s.shiftLeft(head, m);
		output = ListNode.unConstructListNode(node);
		Util.verifyUnsort(expect, output, 2);

	}

}
