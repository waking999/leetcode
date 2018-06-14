package leetcode.success.tree;

import java.util.Stack;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

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
	}

	@Test
	public void test1() {
		FlattenBinaryTreeToLinkedList s = new FlattenBinaryTreeToLinkedList();
		int[] nodes1;
		int[] parents1;
		int[] children1;
		TreeNode root1;
		int[] output;
		int[] nodes2;
		int[] parents2;
		int[] children2;
		TreeNode expectNode;
		int[] expect;
		int seq=1;

		nodes1 = new int[] { 1, 2, 3, 4, 5, 6 };
		parents1 = new int[] { -1, 0, 1, 1, 0, 4 };
		children1 = new int[] { -1, 0, 0, 1, 1, 1 };
		root1 = NormalBinaryTreeNode.constructTreeNode(nodes1, parents1, children1);

		nodes2 = new int[] { 1, 2, 3, 4, 5, 6 };
		parents2 = new int[] { -1, 0, 1, 2, 3, 4 };
		children2 = new int[] { -1, 1, 1, 1, 1, 1 };
		expectNode = NormalBinaryTreeNode.constructTreeNode(nodes2, parents2, children2);
		expect = NormalBinaryTreeNode.unconstructTreeNode(expectNode);


		s.flatten(root1);
		output = NormalBinaryTreeNode.unconstructTreeNode(root1);
		Util.verifyUnsort(expect, output, seq++);



	}

}
