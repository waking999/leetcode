package leetcode.success.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import common.NormalBinaryTreeNode;
import common.TreeNode;

public class AverageOfLevelsInBinaryTree {

	private void dfs(TreeNode node, int level, Map<Integer, Integer> counts, Map<Integer, Double> sums) {
		if (node == null) {
			return;
		}
		if (counts.containsKey(level)) {
			counts.put(level, counts.get(level) + 1);
		} else {
			counts.put(level, 1);
		}
		if (sums.containsKey(level)) {
			sums.put(level, sums.get(level) + node.val);
		} else {
			sums.put(level, (double)node.val);
		}

		dfs(node.left, level + 1, counts, sums);
		dfs(node.right, level + 1, counts, sums);
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Map<Integer, Integer> counts = new HashMap<>();
		Map<Integer, Double> sums = new HashMap<>();
		dfs(root, 0, counts, sums);

		Set<Integer> keySet = counts.keySet();
		int keySetSize = keySet.size();
		List<Double> ret = new ArrayList<>(keySetSize);
		for (Integer key : keySet) {
			int count = counts.get(key);
			double sum = sums.get(key);
			double av = sum / count;
			ret.add(key, av);
		}
		return ret;
	}


}
