package leetcode.success.linkedlist;

import leetcode.success.comm.ListNode;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null){
			return null;
		}
		int headALen=0;
		int headBLen=0;
		
		ListNode headA1=headA;
		ListNode headB1=headB;
		
		while(headA1.next!=null){
			headA1=headA1.next;
			headALen++;
		}
		while(headB1.next!=null){
			headB1=headB1.next;
			headBLen++;
		}
		if(headA1.val!=headB1.val){
			return null;
		}
		int diff=headALen-headBLen;
		headA1=headA;
		headB1=headB;
		
		int count=0;
		if(diff>0){
			while(count<diff){
				headA1=headA1.next;
				count++;
			}
		}else if(diff<0){
			diff=0-diff;
			while(count<diff){
				headB1=headB1.next;
				count++;
			}
		}
		
		while(headA1.val!=headB1.val){
			headA1=headA1.next;
			headB1=headB1.next;
		}
		
		return headA1;
	}

	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();

		int[] aNums;
		int[] bNums;
		int[] cNums;
		
		ListNode a;
		ListNode b;
		ListNode c;
		
		ListNode output;
		
		aNums=new int[]{1,2,3};
		bNums=new int[]{1,2};
		cNums=new int[]{4,5,6};
		
		a=ListNode.constructListNode(aNums);
		b=ListNode.constructListNode(bNums);
		c=ListNode.constructListNode(cNums);
		
		output=s.getIntersectionNode(a, b);
		assert(output==null):"1:wrong";
		
		ListNode a1=a;
		while(a.next!=null){
			a=a.next;
		}
		ListNode b1=b;
		while(b.next!=null){
			b=b.next;
		}
		a.next=c;
		b.next=c;
		output=s.getIntersectionNode(a1, b1);
		assert(output==c):"2:wrong";
		
		
		a=null;
		b=null;
		output=s.getIntersectionNode(a, b);
		assert(output==null):"3:wrong";
		
		System.out.println("Finish");
	}

}