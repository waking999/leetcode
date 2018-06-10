package leetcode.success.tree;

import leetcode.success.comm.ListNode;
import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null){
			return null;
		}
		return build(head, null);
	}
	
	private TreeNode build(ListNode start,ListNode end){
		if(start==end){
			return null;
		}
		ListNode slow=start;
		ListNode fast=start;
		while(fast!=end&&fast.next!=end){
			slow=slow.next;
			fast=fast.next.next;
		}
		
		TreeNode node=new TreeNode(slow.val);
		node.left=build(start, slow);
		node.right=build(slow.next,end);
		return node;
	}

	public static void main(String[] args) {
		ConvertSortedListToBinarySearchTree s=new ConvertSortedListToBinarySearchTree();
		
		int[] nodes;		 
		ListNode head;
		int[] expect;
		int expectLen;
		TreeNode output;
		Integer[] outputArray;
		int outputArrayLen;
		
		
		nodes=new int[]{4,5,8,11,13,17,22,23,31,58};
		 
		head=ListNode.constructListNode(nodes);
		output=s.sortedListToBST(head);
		outputArray = NormalBinaryTreeNode.unconstructTreeNode(output);
		outputArrayLen = outputArray.length;
		expect=new int[]{17, 8, 31, 5, 13, 23, 58, 4, -1, 11, -1, 22, -1};
		expectLen=expect.length;
		assert (outputArrayLen == expectLen) : "1.wrong";
		for (int i = 0; i < expectLen; i++) {
			assert (expect[i] == outputArray[i]) : "1.wrong:"+i;
		}
		
		System.out.println("Finished");

	}

}
