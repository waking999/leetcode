package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;

public class SecondMinimumNodeInABinaryTree {
	int fMin;
	int sMin;
	
	public int findSecondMinimumValue(TreeNode root) {
		if(root==null) {
			return -1;
		}
		fMin=Integer.MAX_VALUE;
		sMin=Integer.MAX_VALUE;
		dfs(root);
		if(sMin==Integer.MAX_VALUE) {
			return -1;
		}
		return sMin;		
		
	}
	
	private void dfs(TreeNode node) {
		if(node==null) {
			return;
		}
		if(node.val<fMin) {
			sMin=fMin;
			fMin=node.val;
		}else if(node.val>fMin && node.val<sMin) {
			sMin=node.val;
		}
		dfs(node.left);
		dfs(node.right);
	}



}
