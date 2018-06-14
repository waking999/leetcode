package leetcode.success.linkedlist;

import java.util.List;

import common.ListNode;
import leetcode.success.comm.Util;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tmp=head;
		
		int length=0;
		while(tmp!=null) {
			length++;
			tmp=tmp.next;
		}
		
	 
		
		int pos=length-n;
		if(pos==0) {
			return head.next;
		}
		int count=1;
		tmp=head;
		while(count<pos) {
			tmp=tmp.next;
			count++;
		}
		tmp.next=tmp.next.next;
		
		return head;
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndofList s = new RemoveNthNodeFromEndofList();

		int n;
		int[] nums;
		ListNode head;
		int[] expect;
		List<Integer> output;
		
		nums=new int[] {1,2,3,4,5};
		head=ListNode.constructListNode(nums);
		n=2;
		head=s.removeNthFromEnd(head, n);
		output=ListNode.unConstructListNode(head);
		expect=new int[] {1,2,3,5};
		Util.verifyUnsort(expect, output, 1);
		
		
		nums=new int[] {1};
		head=ListNode.constructListNode(nums);
		n=1;
		head=s.removeNthFromEnd(head, n);
		output=ListNode.unConstructListNode(head);
		expect=new int[] {};
		Util.verifyUnsort(expect, output, 2);
		
		nums=new int[] {1,2};
		head=ListNode.constructListNode(nums);
		n=2;
		head=s.removeNthFromEnd(head, n);
		output=ListNode.unConstructListNode(head);
		expect=new int[] {2};
		Util.verifyUnsort(expect, output, 3);
	}
}
