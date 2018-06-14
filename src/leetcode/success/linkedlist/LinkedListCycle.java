package leetcode.success.linkedlist;

import common.ListNode;
import common.TreeNode;
import org.junit.Test;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if(head==null){
			return false;
		}
		
		ListNode slow=head;
		ListNode fast=head;
		
		while(fast.next!=null&&fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				return true;
			}
		}		
		
        return false;
    }

    @Test
	public void testhasCycle() {
		LinkedListCycle s=new LinkedListCycle();
		
		int[] nums;
		int[] childIdx;
		ListNode head;
		boolean expect;
		boolean output;
		
		//no cycle
		nums=new int[]{4,5,6,7};
		childIdx=new int[]{1,2,3,TreeNode.IMPOSSIBLE_VALUE};
		head=ListNode.constructListNode(nums,childIdx);
		expect=false;
		output=s.hasCycle(head);
		assert(output==expect):"1:wrong";
		
		
		//has cycle
		nums=new int[]{4,5,6,7};
		childIdx=new int[]{1,2,3,1};
		head=ListNode.constructListNode(nums,childIdx);
		expect=true;
		output=s.hasCycle(head);
		assert(output==expect):"2:wrong";
		
		System.out.println("Finish");

	}

}
