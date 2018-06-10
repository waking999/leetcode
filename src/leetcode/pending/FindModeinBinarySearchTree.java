package leetcode.pending;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

public class FindModeinBinarySearchTree {
	public int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[]{};
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		dfs(root, map);

		int mapSize = map.size();
		Set<Integer> keySet = map.keySet();
		int maxCount = 0;
		for (Integer key : keySet) {
			maxCount = Math.max(maxCount, map.get(key));
		}

		int[] nums = new int[mapSize];
		int i = 0;
		for (Integer key : keySet) {
			if (map.get(key) == maxCount) {
				nums[i] = key;
				i++;
			}
		}
		int[] ret = Arrays.copyOfRange(nums, 0, i);

		return ret;
	}

	private void dfs(TreeNode node, Map<Integer, Integer> map) {
		if (node == null) {
			return;
		}
		if (map.containsKey(node.val)) {
			map.put(node.val, map.get(node.val) + 1);
		} else {
			map.put(node.val, 1);
		}
		dfs(node.left, map);
		dfs(node.right, map);

	}

	public static void main(String[] args) {
		FindModeinBinarySearchTree s = new FindModeinBinarySearchTree();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int[] expect;
		int[] output;

		nodes = new int[] { 1, 2, 2 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 1, 0 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = new int[] { 2 };
		output = s.findMode(root);
		Util.verifySort(expect, output, 1);

	}

}
