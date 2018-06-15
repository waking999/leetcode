package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;

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



}
