package history;
import org.junit.Assert;

import common.ListNode;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head==null) return null;
		
        ListNode current=head;
        ListNode next=head.next; 
		
        while(next!=null){
        	if(next.val==current.val){
        		current.next=next.next;
        		next=current.next;
        	}else{
        		current=next;
        		next=next.next;
        	}
        }
		
		
		return head;
    }

	public static void main(String[] args) {
		/*
		 * Given 1->1->2, return 1->2.

		 */
		RemoveDuplicatesFromSortedList x=new RemoveDuplicatesFromSortedList();
		
		
		ListNode n01=new ListNode(1);
		ListNode n02=new ListNode(1);
		ListNode n03=new ListNode(2);
		
		n01.next=n02;
		n02.next=n03;
		
		n01=x.deleteDuplicates(n01);
		Assert.assertEquals(n03.val, n01.next.val);
		
		/*
		 * Given 1->1->2->3->3, return 1->2->3.
		 */
		  n01=new ListNode(1);
		  n02=new ListNode(1);
		  n03=new ListNode(2);
		ListNode n04=new ListNode(3);
		ListNode n05=new ListNode(3); 
		
		n01.next=n02;
		n02.next=n03;
		n03.next=n04;
		n04.next=n05;
		
		n01=x.deleteDuplicates(n01);
		Assert.assertEquals(n03.val, n01.next.val);
		Assert.assertNull(n04.next);
		
		n01=null;
		n01=x.deleteDuplicates(n01);
		Assert.assertNull(n01);
		
		System.out.println("done");
	}

}
