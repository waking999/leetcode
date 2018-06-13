package leetcode.success.tree;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

public class PathSumIII {
	int count=0;
	public int pathSum(TreeNode root, int sum) {
		if(root==null) {
			return 0;
		}
	 
		dfs(root, sum);
		pathSum(root.left,sum);
		pathSum(root.right,sum);
		
		return count;
	}
	 
	private void dfs(TreeNode node, int sum) {
		if(node==null) {
			return ;
		}
		if(node.val==sum) {
			count++;
		}
		dfs(node.left, sum-node.val);
		dfs(node.right, sum-node.val);
	}

	public static void main(String[] args) {
		PathSumIII s=new PathSumIII();
		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int sum;
		int expect;
		int output;

		nodes = new int[] { 10, 5, -3, 3, 2, 11, 3, -2, 1 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1, 2, 3, 3, 4 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1, 1, 0, 1, 1 };
		root=NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		sum = 8;

		expect = 3;
		output=s.pathSum(root, sum);
		Util.verify(expect, output, 1);
	}

}
