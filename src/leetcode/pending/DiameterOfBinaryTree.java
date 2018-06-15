package leetcode.pending;

import java.util.HashMap;
import java.util.Map;

import common.NormalBinaryTreeNode;
import common.TreeNode;

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



}
