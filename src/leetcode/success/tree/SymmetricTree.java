package leetcode.success.tree;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		return equalTree(root.left,root.right);
	}
	
	private boolean equalTree(TreeNode t1, TreeNode t2){
		if(t1==null&&t2==null){
			return true;
		}else if(t1==null&&t2!=null){
			return false;
		}else if(t1!=null&&t2==null){
			return false;
		}else{
			return (t1.val==t2.val)&&equalTree(t1.left,t2.right)&&equalTree(t1.right,t2.left);
		}
	}

	public static void main(String[] args) {
		SymmetricTree s = new SymmetricTree();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		boolean expect;
		boolean output;

		nodes = new int[] { 1, 2, 2, 3, 4, 4, 3 };
		parents = new int[] { -1, 0, 0, 1, 1, 2, 2 };
		children = new int[] { -1, 0, 1, 0, 1, 0, 1 };
		expect = true;
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		output = s.isSymmetric(root);
		assert (expect == output) : "1.wrong";

		nodes = new int[] { 1, 2, 2, -1, 3, -1, 3 };
		parents = new int[] { -1, 0, 0, 1, 1, 2, 2 };
		children = new int[] { -1, 0, 1, 0, 1, 0, 1 };
		expect = false;
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		output = s.isSymmetric(root);
		assert (expect == output) : "2.wrong";
		
		nodes = new int[] { 1, 2, 3 };
		parents = new int[] { -1, 0, 0 };
		children = new int[] { -1, 0, 1 };
		expect = false;
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		output = s.isSymmetric(root);
		assert (expect == output) : "3.wrong";
		

		System.out.println("Finish");

	}

}
