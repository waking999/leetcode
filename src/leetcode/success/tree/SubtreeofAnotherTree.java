package leetcode.success.tree;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

public class SubtreeofAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null)
			return false;
		if (t == null)
			return true;
		if (isSameTree(s, t))
			return true;
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null && q != null) {
			return false;
		} else if (p != null && q == null) {
			return false;
		} else {
			return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}

	public static void main(String[] args) {
		SubtreeofAnotherTree s = new SubtreeofAnotherTree();

		int[] nodes1;
		int[] parents1;
		int[] children1;
		TreeNode s1;
		int[] nodes2;
		int[] parents2;
		int[] children2;
		TreeNode t2;
		boolean expect;
		boolean output;

		nodes1 = new int[] { 3, 4, 5, 1, 2 };
		parents1 = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1 };
		children1 = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1 };
		s1 = NormalBinaryTreeNode.constructTreeNode(nodes1, parents1, children1);
		nodes2 = new int[] { 4, 1, 2 };
		parents2 = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0 };
		children2 = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1 };
		t2 = NormalBinaryTreeNode.constructTreeNode(nodes2, parents2, children2);
		expect = true;
		output = s.isSubtree(s1, t2);
		Util.verify(expect, output, 1);

		nodes1 = new int[] { 3, 4, 5, 1, 2 };
		parents1 = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1 };
		children1 = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1 };
		s1 = NormalBinaryTreeNode.constructTreeNode(nodes1, parents1, children1);
		nodes2 = new int[] { 4, 1, 2, 0 };
		parents2 = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2 };
		children2 = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 1 };
		t2 = NormalBinaryTreeNode.constructTreeNode(nodes2, parents2, children2);
		expect = false;
		output = s.isSubtree(s1, t2);
		Util.verify(expect, output, 2);
	}

}
