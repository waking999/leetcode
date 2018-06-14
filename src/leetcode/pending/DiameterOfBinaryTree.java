package leetcode.pending;

import java.util.HashMap;
import java.util.Map;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;

public class DiameterOfBinaryTree {
	int depth;

	public int diameterOfBinaryTree(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<>();
		maxDepth(root, map);
		return depth;
	}

	private int maxDepth(TreeNode node, Map<TreeNode, Integer> map) {
		if (node == null) {
			return 0;
		}
		if (map.containsKey(node)) {
			return map.get(node);
		}
		int left = maxDepth(node.left, map);
		int right = maxDepth(node.right, map);
		depth = Math.max(depth, left + right);
		int val = Math.max(left, right) + 1;
		map.put(node, val);
		return val;
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree s = new DiameterOfBinaryTree();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int expect;
		int output;

		nodes = new int[] { 1, 2, 3, 4, 5 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = 3;
		output = s.diameterOfBinaryTree(root);
		Util.verify(expect, output, 1);
	}

}
