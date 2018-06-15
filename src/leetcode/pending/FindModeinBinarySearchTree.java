package leetcode.pending;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import common.NormalBinaryTreeNode;
import common.TreeNode;

public class FindModeinBinarySearchTree {
	public int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[]{};
		}
		Map<Integer, Integer> map = new HashMap<>();

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

		return Arrays.copyOfRange(nums, 0, i);
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



}
