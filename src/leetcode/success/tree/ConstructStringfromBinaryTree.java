package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;

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



}
