package history;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

import leetcode.success.comm.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		Set<Integer> visited=new HashSet<Integer>();
		
		while(head!=null){
			int v=head.val;
			if(visited.contains(v)) return true;
			visited.add(v);
			head=head.next;
		}
		
		return false;
	}

	public static void main(String[] args) {
		LinkedListCycle x = new LinkedListCycle();

		ListNode n01;
		ListNode n02;
		ListNode n03;
		ListNode n04;

		n01 = new ListNode(1);
		n02 = new ListNode(2);
		n03 = new ListNode(3);
		n04 = new ListNode(4);

		n01.next = n02;
		n02.next = n03;
		n03.next = n04;

		Assert.assertTrue(!x.hasCycle(n01));

		n04.next = n02;

		Assert.assertTrue(x.hasCycle(n01));

		
		 
				 
		System.out.println("done");
	}

}
