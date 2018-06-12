package leetcode.success.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

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

	public static void main(String[] args) {
		AverageOfLevelsInBinaryTree s = new AverageOfLevelsInBinaryTree();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		double[] expect;
		List<Double> output;

		nodes = new int[] { 3, 9, 20, 15, 7 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = new double[] { 3, 14.5, 11 };
		output = s.averageOfLevels(root);
		Util.verifyUnsort(expect, output, 1);

		nodes = new int[] { 5, 14, 1 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = new double[] { 5, 14, 1 };
		output = s.averageOfLevels(root);
		Util.verifyUnsort(expect, output, 2);

		nodes = new int[] { 2147483647,2147483647,2147483647};
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = new double[] {2147483647,2147483647 };
		output = s.averageOfLevels(root);
		Util.verifyUnsort(expect, output, 3);
	}

}
