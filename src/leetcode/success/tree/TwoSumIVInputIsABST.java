package leetcode.success.tree;

import java.util.HashSet;
import java.util.Set;

import common.BinarySearchTreeNode;
import common.TreeNode;

public class TwoSumIVInputIsABST {
	boolean ret;
	public boolean findTarget(TreeNode root, int k) {
		if(root==null) {
			return false;
		}
		ret =false;
		
		Set<Integer> list=new HashSet<>();
		
		
		dfs(root, list, k);
		
		return ret;
	}
	
	private void dfs(TreeNode node,Set<Integer> list,int k) {
		if(node==null) {
			return;
		}
		if(list.contains(node.val)) {
			ret=true;
			return;
		}else {
			list.add(k-node.val);
		}
		dfs(node.left,list,k);
		dfs(node.right,list, k);		
	}



}
