package leetcode.success.linkedlist;

import leetcode.success.comm.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode orignalL1 = l1;
		ListNode tmpL = l1;
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		int stepIn = 0;
		while (l1 != null && l2 != null) {
			l1.val = l1.val + l2.val + stepIn;
			if (l1.val > 9) {
				l1.val = l1.val - 10;
				stepIn = 1;
			} else {
				stepIn = 0;
			}
			tmpL = l1;
			l1 = l1.next;
			l2 = l2.next;

		}
		
		
		
		if (l1 == null) {
			if (l2 != null) {
				tmpL.next = l2;
				while (l2 != null) {
					l2.val = l2.val + stepIn;
					if (l2.val > 9) {
						l2.val = l2.val - 10;
						stepIn = 1;
					} else {
						stepIn = 0;
					}
					tmpL=l2;
					l2 = l2.next;
				}
			}
			if (stepIn > 0) {
				ListNode node = new ListNode(stepIn);
				tmpL.next = node;
			}

		} else {
			while (l1 != null) {
				l1.val = l1.val + stepIn;
				if (l1.val > 9) {
					l1.val = l1.val - 10;
					stepIn = 1;
				} else {
					stepIn = 0;
				}
				tmpL=l1;
				l1 = l1.next;
			}
			if (stepIn > 0) {
				ListNode node = new ListNode(stepIn);
				tmpL.next = node;
			}
		}

		return orignalL1;
	}

	public static void main(String[] args) {
		AddTwoNumbers s = new AddTwoNumbers();
		int[] nums1;
		ListNode node1;
		int[] nums2;
		ListNode node2;
		int[] expectNums;
		ListNode expect;
		ListNode output;

		nums1 = new int[] { 2, 4, 3 };
		node1 = ListNode.constructListNode(nums1);
		nums2 = new int[] { 5, 6, 4 };
		node2 = ListNode.constructListNode(nums2);
		expectNums = new int[] { 7, 0, 8 };
		expect = ListNode.constructListNode(expectNums);
		output = s.addTwoNumbers(node1, node2);

		while (output.next != null && expect.next != null) {
			assert (output.val == expect.val) : "1:wrong";
			output = output.next;
			expect = expect.next;
		}
		assert (output.next == null) : "1:wrong";
		assert (expect.next == null) : "1:wrong";

		nums1 = new int[] { 1 };
		node1 = ListNode.constructListNode(nums1);
		nums2 = new int[] { 9, 9, 9 };
		node2 = ListNode.constructListNode(nums2);
		expectNums = new int[] { 0, 0, 0, 1 };
		expect = ListNode.constructListNode(expectNums);
		output = s.addTwoNumbers(node1, node2);

		while (output.next != null && expect.next != null) {
			assert (output.val == expect.val) : "2:wrong";
			output = output.next;
			expect = expect.next;
		}
		assert (output.next == null) : "2:wrong";
		assert (expect.next == null) : "2:wrong";
		
		
		nums1 = new int[] { 9,9,9 };
		node1 = ListNode.constructListNode(nums1);
		nums2 = new int[] { 1 };
		node2 = ListNode.constructListNode(nums2);
		expectNums = new int[] { 0, 0, 0, 1 };
		expect = ListNode.constructListNode(expectNums);
		output = s.addTwoNumbers(node1, node2);

		while (output.next != null && expect.next != null) {
			assert (output.val == expect.val) : "3:wrong";
			output = output.next;
			expect = expect.next;
		}
		assert (output.next == null) : "3:wrong";
		assert (expect.next == null) : "3:wrong";
		
		nums1 = new int[] { };
		node1 = ListNode.constructListNode(nums1);
		nums2 = new int[] { 9, 9, 9 };
		node2 = ListNode.constructListNode(nums2);
		expectNums = new int[] { 9,9,9 };
		expect = ListNode.constructListNode(expectNums);
		output = s.addTwoNumbers(node1, node2);

		while (output.next != null && expect.next != null) {
			assert (output.val == expect.val) : "4:wrong";
			output = output.next;
			expect = expect.next;
		}
		assert (output.next == null) : "4:wrong";
		assert (expect.next == null) : "4:wrong";
		
		nums1 = new int[] { 9,9,9 };
		node1 = ListNode.constructListNode(nums1);
		nums2 = new int[] {   };
		node2 = ListNode.constructListNode(nums2);
		expectNums = new int[] { 9,9,9 };
		expect = ListNode.constructListNode(expectNums);
		output = s.addTwoNumbers(node1, node2);

		while (output.next != null && expect.next != null) {
			assert (output.val == expect.val) : "5:wrong";
			output = output.next;
			expect = expect.next;
		}
		assert (output.next == null) : "5:wrong";
		assert (expect.next == null) : "5:wrong";

		System.out.println("Finish");
	}

}
