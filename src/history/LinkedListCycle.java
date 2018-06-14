package history;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

import common.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		Set<Integer> visited= new HashSet<>();
		
		while(head!=null){
			int v=head.val;
			if(visited.contains(v)) return true;
			visited.add(v);
			head=head.next;
		}
		
		return false;
	}



}
