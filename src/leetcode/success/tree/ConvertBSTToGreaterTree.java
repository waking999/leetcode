package leetcode.success.tree;

import leetcode.success.comm.BinarySearchTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

public class ConvertBSTToGreaterTree {
	int sum;
	public TreeNode convertBST(TreeNode root) {
		sum=0;
		dfs(root);
		return root;
	}

	private void dfs(TreeNode node) {
		if(node==null) {
			return;
		}
		dfs(node.right);
		node.val+=sum;
		sum=node.val;
		dfs(node.left);
	}
	
	 
	public static void main(String[] args) {
		ConvertBSTToGreaterTree s = new ConvertBSTToGreaterTree();

		int[] nodes;
		TreeNode root;
		int[] expect;
		TreeNode output;

		nodes = new int[] { 5, 2, 13 };
		root = BinarySearchTreeNode.constructTreeNode(nodes);
		output = s.convertBST(root);
		expect = new int[] { 18, 20, 13 };
		Integer[] outputArr = TreeNode.unconstructTreeNode(output);
		Util.verifyUnsort(expect, outputArr, 1);

	}

}
