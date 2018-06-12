package leetcode.success.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.success.comm.BinarySearchTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

public class MinimumAbsoluteDifferenceInBST {
	public int getMinimumDifference(TreeNode root) {
		List<Integer> list=new ArrayList<>();
		dfs(root,list);
		int min=Integer.MAX_VALUE;
		for(int i=1;i<list.size();i++) {
			int diff=list.get(i)-list.get(i-1);		
			if(diff<min) {
				min=diff;
			}
		}
		
		return min;
	}
	private void dfs(TreeNode node, List<Integer> list) {
		if(node==null) {
			return;
		}
		dfs(node.left,list);
		list.add(node.val);
		dfs(node.right,list);
	}

	public static void main(String[] args) {
		MinimumAbsoluteDifferenceInBST s = new MinimumAbsoluteDifferenceInBST();
		
		int[] nodes;
		TreeNode root;
		int expect;
		int output;
		
		nodes=new int[] {1,3,2};
		root=BinarySearchTreeNode.constructTreeNode(nodes);
		expect=1;
		output=s.getMinimumDifference(root);
		Util.verifyUnsort(expect, output, 1);
		
		System.out.println("Finish");
	}

}
