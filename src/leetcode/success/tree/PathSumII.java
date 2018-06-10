package leetcode.success.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}

		Stack<Integer> path = new Stack<>();
		dfs(root, path, ret,sum);
		return ret;
	}

	private void dfs(TreeNode node, Stack<Integer> path, List<List<Integer>> result,int sum) {
		if (node == null) {
			return;
		}
		path.push(node.val);
		if (node.left == null && node.right == null &&sumStack(path)==sum) {
			result.add(generatePath(path));
		} else {
			if (node.left != null) {
				dfs(node.left, path, result,sum);
				path.pop();
			}
			if (node.right != null) {
				dfs(node.right, path, result,sum);
				path.pop();
			}
		}
	}

	private List<Integer> generatePath(List<Integer> list) {
		List<Integer> list2 = list.stream().collect(Collectors.toList());
		return list2;
	}

	private int sumStack(Stack<Integer> s) {

		Iterator<Integer> it = s.iterator();
		int sum = 0;
		while (it.hasNext()) {
			sum += it.next();
		}
		return sum;
	}

	public static void main(String[] args) {
		PathSumII s = new PathSumII();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int sum;
		int[][] expect;
		int expectLen;
		List<List<Integer>> output;
		int outputSize;

		nodes = new int[] { 5, 4, 8, 11, 13, 4, 7, 2, 5, 1 };
		parents = new int[] { -1, 0, 0, 1, 2, 2, 3, 3, 5, 5 };
		children = new int[] { -1, 0, 1, 0, 0, 1, 0, 1, 0, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = new int[][] { { 5, 4, 11, 2 }, { 5, 8, 4, 5 } };
		expectLen = expect.length;
		sum = 22;
		output = s.pathSum(root, sum);
		outputSize = output.size();
		assert (expectLen == outputSize) : "1.wrong";
		for (int i = 0; i < expectLen; i++) {

			String s1 = IntStream.of(expect[i]).map(str -> str).boxed().collect(Collectors.toList()).stream()
					.map(num -> Integer.toString(num)).collect(Collectors.joining(","));

			String s2 = output.get(i).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
			assert (s1.equals(s2)) : "1:wrong";
		}

		System.out.println("Finish");

	}

}
