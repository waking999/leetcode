package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import org.junit.Test;

public class ConvertBSTToGreaterTree {
	int sum;
	public TreeNode convertBST(TreeNode root) {
		sum=0;
		dfs(root);
		return root;
	}

	private void dfs(TreeNode node) {
		if(node==null) {
			return;
		}
		dfs(node.right);
		node.val+=sum;
		sum=node.val;
		dfs(node.left);
	}




}
