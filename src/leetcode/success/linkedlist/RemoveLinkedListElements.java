package leetcode.success.linkedlist;

import java.util.List;

import leetcode.success.comm.ListNode;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}

		while (head!=null&&head.val == val) {
			head = head.next;

		}

		ListNode p = head;

		while (p != null) {
			 
			if (p.next != null && p.next.val == val) {
				p.next = p.next.next;
			}else{
				p = p.next;
			}
		}

		return head;
	}

	public static void main(String[] args) {
		RemoveLinkedListElements s = new RemoveLinkedListElements();

		int[] nums;
		ListNode head;
		int val;
		ListNode output;
		List<Integer> outputList;
		int[] expect;

		nums = new int[] { 1, 2, 6, 3, 4, 5, 6 };
		head = ListNode.constructListNode(nums);
		val = 6;
		output = s.removeElements(head, val);		
		expect = new int[] { 1, 2, 3, 4, 5 };
		
		outputList=ListNode.unConstructListNode(output);
		assert(expect.length==outputList.size()):"1:wrong";
		for(int i=0;i<expect.length;i++){
			assert(expect[i]==outputList.get(i)):"1:wrong";
		}

		nums = new int[] { 1 };
		head = ListNode.constructListNode(nums);
		val = 1;
		output = s.removeElements(head, val);
		expect = new int[] {};
		outputList=ListNode.unConstructListNode(output);
		assert(expect.length==outputList.size()):"2:wrong";
		for(int i=0;i<expect.length;i++){
			assert(expect[i]==outputList.get(i)):"2:wrong";
		}
		
		nums = new int[] { 1 };
		head = ListNode.constructListNode(nums);
		val = 2;
		output = s.removeElements(head, val);
		expect = new int[] { 1 };
		outputList=ListNode.unConstructListNode(output);
		assert(expect.length==outputList.size()):"3:wrong";
		for(int i=0;i<expect.length;i++){
			assert(expect[i]==outputList.get(i)):"3:wrong";
		}
		
		nums = new int[] { 1, 1 };
		head = ListNode.constructListNode(nums);
		val = 1;
		output = s.removeElements(head, val);
		expect = new int[] {};
		outputList=ListNode.unConstructListNode(output);
		assert(expect.length==outputList.size()):"4:wrong";
		for(int i=0;i<expect.length;i++){
			assert(expect[i]==outputList.get(i)):"4:wrong";
		}
		
		nums = new int[] { 1,2,2, 1 };
		head = ListNode.constructListNode(nums);
		val = 2;
		output = s.removeElements(head, val);
		expect = new int[] {1,1};
		outputList=ListNode.unConstructListNode(output);
		assert(expect.length==outputList.size()):"5:wrong";
		for(int i=0;i<expect.length;i++){
			assert(expect[i]==outputList.get(i)):"5:wrong";
		}
		
		
		System.out.println("Finish");

	}

}
