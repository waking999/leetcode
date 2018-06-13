package leetcode.success.tree;

import java.util.HashSet;
import java.util.Set;

import leetcode.success.comm.BinarySearchTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

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

	public static void main(String[] args) {
		TwoSumIVInputIsABST s = new TwoSumIVInputIsABST();
		
		int[] nodes;
		TreeNode root;
		int k;
		boolean expect;
		boolean output;
		 
		nodes=new int[] {5,3,6,2,4,7};
		root=BinarySearchTreeNode.constructTreeNode(nodes);
		k=9;
		expect=true;
		output=s.findTarget(root, k);
		Util.verify(expect, output, 1);
		
		
		nodes=new int[] {5,3,6,2,4,7};
		root=BinarySearchTreeNode.constructTreeNode(nodes);
		k=28;
		expect=false;
		output=s.findTarget(root, k);
		Util.verify(expect, output, 2);
		
		System.out.println("Finish");
	}

}
