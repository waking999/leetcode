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



}
