package leetcode.pending;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

public class BinaryTreeTilt {

	public int findTilt(TreeNode root) {
		if (root == null) {
			return 0;
		}
		tilt = 0;
		postorder(root);
		return tilt;
	}

	int tilt;

	private int postorder(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int l = postorder(node.left);
		int r = postorder(node.right);
		tilt += Math.abs(l - r);
		return l + r + node.val;
	}

	public static void main(String[] args) {
		BinaryTreeTilt s = new BinaryTreeTilt();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int expect;
		int output;

		nodes = new int[] { 1, 2, 3 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = 1;
		output = s.findTilt(root);
		Util.verify(expect, output, 1);

	}

}
