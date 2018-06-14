package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;
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


	@Test
	public void test1()  {
		ConvertBSTToGreaterTree s = new ConvertBSTToGreaterTree();

		int[] nodes;
		TreeNode root;
		int[] expect;
		TreeNode outputNode;
		int[] output;
		int seq=1;

		nodes = new int[] { 5, 2, 13 };
		root = BinarySearchTreeNode.constructTreeNode(nodes);
		outputNode = s.convertBST(root);
		expect = new int[] { 18, 20, 13 };
		output= TreeNode.unconstructTreeNode(outputNode);
		Util.verifyUnsort(expect, output, seq++);

	}

}
