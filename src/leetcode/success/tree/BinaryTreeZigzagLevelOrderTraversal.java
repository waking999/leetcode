package leetcode.success.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}

		int level = 0;
		dfs(root, level, ret);
		zigzag(ret);
		return ret;
	}

	private void zigzag(List<List<Integer>> list) {
		int listSize = list.size();
		for (int i = 1; i < listSize; i+=2) {
			List<Integer> tmpList=list.get(i);
			Collections.reverse(tmpList);
		}
	}

	private void dfs(TreeNode node, int level, List<List<Integer>> list) {
		if (node == null) {
			return;
		}
		int listSize = list.size();
		List<Integer> row;
		if (listSize <= level) {
			row = new ArrayList<Integer>();
			list.add(row);
		} else {
			row = list.get(level);
		}

		row.add(node.val);
		dfs(node.left, level + 1, list);
		dfs(node.right, level + 1, list);

	}

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int[][] expect;
		int expectLen;
		List<List<Integer>> output;
		int outputSize;

		nodes = new int[] { 3, 9, 20, 15, 7 };
		parents = new int[] { -1, 0, 0, 2, 2 };
		children = new int[] { -1, 0, 1, 0, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = new int[][] { { 3 }, { 20, 9 }, { 15, 7 } };
		expectLen = expect.length;
		output = s.zigzagLevelOrder(root);
		outputSize = output.size();
		assert (outputSize == expectLen) : "1:wrong";
		for (int i = 0; i < expectLen; i++) {

			String s1 = IntStream.of(expect[i]).map(str -> str).boxed().collect(Collectors.toList()).stream()
					.map(num -> Integer.toString(num)).collect(Collectors.joining(","));

			String s2 = output.get(i).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
			assert (s1.equals(s2)) : "1:wrong";
		}

		System.out.println("Finish");

	}

}
