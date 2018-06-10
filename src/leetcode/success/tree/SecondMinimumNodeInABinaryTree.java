package leetcode.success.tree;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

public class SecondMinimumNodeInABinaryTree {
	int fMin;
	int sMin;
	
	public int findSecondMinimumValue(TreeNode root) {
		if(root==null) {
			return -1;
		}
		fMin=Integer.MAX_VALUE;
		sMin=Integer.MAX_VALUE;
		dfs(root);
		if(sMin==Integer.MAX_VALUE) {
			return -1;
		}
		return sMin;		
		
	}
	
	private void dfs(TreeNode node) {
		if(node==null) {
			return;
		}
		if(node.val<fMin) {
			sMin=fMin;
			fMin=node.val;
		}else if(node.val>fMin && node.val<sMin) {
			sMin=node.val;
		}
		dfs(node.left);
		dfs(node.right);
	}

	public static void main(String[] args) {
		SecondMinimumNodeInABinaryTree s = new SecondMinimumNodeInABinaryTree();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int expect;
		int output;

		nodes = new int[] { 2, 2, 5, 5, 7 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = 5;
		output = s.findSecondMinimumValue(root);
		Util.verify(expect, output, 1);
		
		
		nodes = new int[] { 2, 2, 2};
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0};
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = -1;
		output = s.findSecondMinimumValue(root);
		Util.verify(expect, output, 2);
	}

}
