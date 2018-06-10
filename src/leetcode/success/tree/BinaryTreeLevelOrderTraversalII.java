package leetcode.success.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ret=new ArrayList<List<Integer>>();
		if(root==null) {
			return ret;
		}
		Map<Integer, List<Integer>> map=new HashMap<Integer,List<Integer>>();
		dfs(root, map, 0);
		
		int mapSize=map.size();
		for(int i=mapSize-1;i>=0;i--) {
			ret.add(map.get(i));
		}
		
		return ret;
	}
	
	private void dfs(TreeNode node,Map<Integer, List<Integer>> map,int level) {
		if(node==null) {
			return;
		}
		 
		List<Integer> row;
		if(!map.containsKey(level)) {
			row=new ArrayList<Integer>();
			map.put(level, row);
		}else {
			row=map.get(level);
		}
		row.add(node.val);
		dfs(node.left,map,level+1);
		dfs(node.right,map, level+1);
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII s = new BinaryTreeLevelOrderTraversalII();
		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int[][] expect;

		List<List<Integer>> output;

		nodes = new int[] { 3, 9, 20, 15, 7 };
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2 };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = new int[][] { { 15, 7 }, { 9, 20 },{ 3 } };

		output = s.levelOrderBottom(root);

		Util.verify(expect, output, 1);

		System.out.println("Finish");
	}

}
