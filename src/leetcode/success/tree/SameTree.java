package leetcode.success.tree;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null){
			return true;
		}else if(p==null&&q!=null){
			return false;
		}else if(p!=null&&q==null){
			return false;
		}else{
			return (p.val==q.val)&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
		}
    }
	
	 

	public static void main(String[] args) {
		SameTree s = new SameTree();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		boolean expect;
		boolean output;

		nodes = new int[] { 1, 2, 2, 3, 3,3, 3 };
		parents = new int[] { -1, 0, 0, 1, 1, 2, 2 };
		children = new int[] { -1, 0, 1, 0, 1, 0, 1 };
		expect = true;
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		output = s.isSameTree(root.left,root.right);
		assert (expect == output) : "1.wrong";

		nodes = new int[] { 1, 2, 2, -1, 3, -1, 3 };
		parents = new int[] { -1, 0, 0, 1, 1, 2, 2 };
		children = new int[] { -1, 0, 1, 0, 1, 0, 1 };
		expect = true;
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		output = s.isSameTree(root.left,root.right);
		assert (expect == output) : "2.wrong";
		
		nodes = new int[] { 1, 2, 3 };
		parents = new int[] { -1, 0, 0 };
		children = new int[] { -1, 0, 1 };
		expect = false;
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		output = s.isSameTree(root.left,root.right);
		assert (expect == output) : "3.wrong";
		

		System.out.println("Finish");

	}

}
