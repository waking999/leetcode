package leetcode.success.tree;

import java.util.ArrayList;
import java.util.List;

import common.BinarySearchTreeNode;
import common.TreeNode;

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



}
