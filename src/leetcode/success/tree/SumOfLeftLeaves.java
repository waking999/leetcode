package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;

public class SumOfLeftLeaves {
	int sum;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}

		sum = 0;
		dfs(root.left, true);
		dfs(root.right, false);

		return sum;
	}

	private void dfs(TreeNode node, boolean isLeft) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (isLeft) {
				sum = sum + node.val;
			}
		}
		dfs(node.left, true);
		dfs(node.right, false);
	}

	public static void main(String[] args) {
		SumOfLeftLeaves s = new SumOfLeftLeaves();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int expect;
		int output;

		nodes = new int[] { 3, 9, 20, 15, 7 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = 24;
		output = s.sumOfLeftLeaves(root);
		assert (expect == output) : "1:wrong";

		System.out.println("Finish");
	}

}
