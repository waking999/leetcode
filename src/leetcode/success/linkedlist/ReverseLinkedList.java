package leetcode.success.linkedlist;

import java.util.List;
import java.util.Stack;

import common.ListNode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head==null){
			return null;
		}
		
		Stack<Integer> s=new Stack<>();
		ListNode p=head;
		while(p!=null){
			s.push(p.val);
			p=p.next;
		}
		
		ListNode ret=null;		
		if(!s.isEmpty()){
			ret=new ListNode(s.pop());
		}
		
		p=ret;
		while(!s.isEmpty()){
			p.next= new ListNode(s.pop());
			p=p.next;
		}
		
		return ret;
	}

	public static void main(String[] args) {
		ReverseLinkedList s = new ReverseLinkedList();

		int[] nums;
		ListNode head;

		ListNode output;
		List<Integer> outputList;
		int[] expect;

		nums = new int[] { 1, 2, 3, 4, 5, 6 };
		head = ListNode.constructListNode(nums);
		output = s.reverseList(head);
		expect = new int[] { 6, 5, 4, 3, 2, 1 };

		outputList = ListNode.unConstructListNode(output);
		assert (expect.length == outputList.size()) : "1:wrong";
		for (int i = 0; i < expect.length; i++) {
			assert (expect[i] == outputList.get(i)) : "1:wrong";
		}
		
		System.out.println("Finish");

	}

}
