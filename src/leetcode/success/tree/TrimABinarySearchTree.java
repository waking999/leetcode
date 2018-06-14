package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

public class TrimABinarySearchTree {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(root==null) {
			return null;
		}
		
		root=dfs(root,L,R);
		
		return root;
	}

 
	private TreeNode dfs(TreeNode node,int L, int R) {
		if(node==null) {
			return null;
		}
		if(node.val<L) {
			return dfs(node.right,L,R);
		}
		if(node.val>R) {
			return dfs(node.left,L,R);
		}
		node.left=dfs(node.left, L, R);
		node.right=dfs(node.right,L,R);
		return node;
		
	}

	@Test
	public void test1()  {
		TrimABinarySearchTree s = new TrimABinarySearchTree();

		int[] nodes;
		TreeNode root;
		int L;
		int R;
		int[] expect;
		TreeNode outputNode;
		int[] output;
		int seq=1;

		nodes = new int[] { 1, 0, 2 };
		root = BinarySearchTreeNode.constructTreeNode(nodes);
		L = 1;
		R = 2;
		expect = new int[] { 1, 2 };
		outputNode = s.trimBST(root, L, R);
		output = BinarySearchTreeNode.unconstructTreeNode(outputNode);
		Util.verifyUnsort(expect, output, seq++);

		nodes = new int[] { 3, 0, 4, 2, 1 };
		root = BinarySearchTreeNode.constructTreeNode(nodes);
		L = 1;
		R = 3;
		expect = new int[] { 3, 2, 1 };
		outputNode = s.trimBST(root, L, R);
		Util.verifyUnsort(expect, output, seq++);
	}

}
