package leetcode.success.tree;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

public class ConstructStringfromBinaryTree {
	public String tree2str(TreeNode t) {
		if (t == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		dfs(t, sb);
		return sb.substring(1, sb.length() - 1);
	}

	private void dfs(TreeNode node, StringBuffer sb) {
		if (node == null) {
			return;
		}
		sb.append("(");
		sb.append(node.val);
		if (node.left == null && node.right != null) {
			sb.append("()");
		}
		dfs(node.left, sb);
		dfs(node.right, sb);
		sb.append(")");
	}

	public static void main(String[] args) {
		ConstructStringfromBinaryTree s = new ConstructStringfromBinaryTree();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode t;
		String expect;
		String output;

		nodes = new int[] { 1, 2, 3, 4 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0 };
		t = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = "1(2(4))(3)";
		output = s.tree2str(t);
		Util.verifyUnsort(expect, output, 1);

		nodes = new int[] { 1, 2, 3, 4 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 1 };
		t = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = "1(2()(4))(3)";
		output = s.tree2str(t);
		Util.verifyUnsort(expect, output, 2);

		nodes = new int[] { 1, 2, 3 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1 };
		t = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = "1(2)(3)";
		output = s.tree2str(t);
		Util.verifyUnsort(expect, output, 2);

		System.out.println("Finish");
	}

}
