package leetcode.pending;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}

		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		
		while (!s.isEmpty()) {
			TreeNode node=s.peek();
			ret.add(node.val);
			s.pop();
			 
			if(node.right!=null){
				s.push(node.right);
			}
			
			if(node.left!=null){
				s.push(node.left);
			}
			
		}
		
		return ret;
	}

	@Test
	public void test1() {
		BinaryTreePreorderTraversal s = new BinaryTreePreorderTraversal();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int[] expect;

		List<Integer> output;
		int seq=1;

		nodes = new int[] { 1, 2, 3 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 1, 0 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = new int[] { 1, 2, 3 };

		output = s.preorderTraversal(root);
		Util.verifyUnsort(expect, output, seq++);
	}

}
