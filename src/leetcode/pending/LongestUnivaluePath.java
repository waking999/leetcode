package leetcode.pending;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

public class LongestUnivaluePath {
	public int longestUnivaluePath(TreeNode root) {
		int[] res=new int[1];
		if(root!=null) dfs(root,res);
		return res[0];
	}
	
	private int dfs(TreeNode node, int[] res) {
		int l=node.left!=null?dfs(node.left,res):0;
		int r=node.right!=null?dfs(node.right,res):0;
		int resl=node.left!=null && node.left.val==node.val?l+1:0;
		int resr=node.right!=null&&node.right.val==node.val?r+1:0;
		res[0]=Math.max(res[0], resl+resr);
		return Math.max(resl, resr);
	}

	public static void main(String[] args) {
		LongestUnivaluePath s = new LongestUnivaluePath();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int expect;
		int output;
		int seq = 0;

		nodes = new int[] { 5, 4, 5, 1, 1, 5 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1, 2 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = 2;
		output = s.longestUnivaluePath(root);
		Util.verifyUnsort(expect, output, ++seq);

		nodes = new int[] { 1, 4, 5, 4, 4, 5 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1, 2 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = 2;
		output = s.longestUnivaluePath(root);
		Util.verifyUnsort(expect, output, ++seq);

	}

}
