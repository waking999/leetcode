package leetcode.success.tree;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		
		if (root == null) {
			return;
		}
		
		
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		TreeNode ret=new TreeNode(root.val);
		TreeNode n=ret;
		
		while (!s.isEmpty()) {
			TreeNode p=s.peek();
			n.right=p;
			n.left=null;
			n=n.right;
			s.pop();
			 
			if(p.right!=null){
				s.push(p.right);
			}
			
			if(p.left!=null){
				s.push(p.left);
			}
			
		}
		root=ret.right;
		return ;
	}

	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList s = new FlattenBinaryTreeToLinkedList();
		int[] nodes1;
		int[] parents1;
		int[] children1;
		TreeNode root1;
		Integer[] root1Array;
		int root1ArrayLen;
		int[] nodes2;
		int[] parents2;
		int[] children2;
		TreeNode expect;
		Integer[] expectArray;
		int expectArrayLen;

		nodes1 = new int[] { 1, 2, 3, 4, 5, 6 };
		parents1 = new int[] { -1, 0, 1, 1, 0, 4 };
		children1 = new int[] { -1, 0, 0, 1, 1, 1 };
		root1 = NormalBinaryTreeNode.constructTreeNode(nodes1, parents1, children1);

		nodes2 = new int[] { 1, 2, 3, 4, 5, 6 };
		parents2 = new int[] { -1, 0, 1, 2, 3, 4 };
		children2 = new int[] { -1, 1, 1, 1, 1, 1 };
		expect = NormalBinaryTreeNode.constructTreeNode(nodes2, parents2, children2);
		expectArray = NormalBinaryTreeNode.unconstructTreeNode(expect);
		expectArrayLen = expectArray.length;

		s.flatten(root1);
		root1Array = NormalBinaryTreeNode.unconstructTreeNode(root1);
		root1ArrayLen = root1Array.length;
		assert (root1ArrayLen == expectArrayLen) : "1:wrong";

		String s1 = Arrays.stream(expectArray).map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		String s2 = Arrays.stream(root1Array).map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		assert (s1.equals(s2)) : "1:wrong";

		System.out.println("Finish");

	}

}
