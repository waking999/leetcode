package history;
import org.junit.Assert;

import common.ListNode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 

		ListNode h=new ListNode(0);
		ListNode curr=h;
		 
		while(l1!=null&&l2!=null){
			if (l1.val >= l2.val) {
	            curr.next = l2;
	            l2 = l2.next;
	        } 
	        else {
	            curr.next = l1;
	            l1 = l1.next;
	        }
	        curr = curr.next;
		}
		if (l1 != null) curr.next = l1;
	    else if (l2 != null) curr.next = l2;
		return h.next;
	}

	public static void main(String[] args) {
		MergeTwoSortedLists x = new MergeTwoSortedLists();

		ListNode h;
		ListNode n01;
		ListNode n02;
		ListNode n03;
		
		ListNode n11;
		ListNode n12;
		 
		/*
		 * l1: null l2: null h:null
		 */

		n01 = null;
		n02 = null;
		h = x.mergeTwoLists(n01, n02);
		Assert.assertNull(h);

		/*
		 * l1: 1->2->5 l2: 3->4 h: 1->2->3->4->5
		 */
		n01=new ListNode(1);
		n02=new ListNode(2);
		n03=new ListNode(5);
		
		n01.next=n02;
		n02.next=n03;
		
		n11=new ListNode(3);
		n12=new ListNode(4);
		n11.next=n12;
		
		h = x.mergeTwoLists(n01, n11);
		Assert.assertEquals(n02.val, n01.next.val);
		Assert.assertEquals(n11.val, n02.next.val);
		Assert.assertEquals(n12.val, n11.next.val);
		Assert.assertEquals(n03.val, n12.next.val);
		System.out.println("done");

	}

}
