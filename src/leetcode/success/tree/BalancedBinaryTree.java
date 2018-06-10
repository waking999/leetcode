package leetcode.success.tree;

import leetcode.success.comm.BinarySearchTreeNode;
import leetcode.success.comm.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if(root==null){
			return true;
		}
		int height=getHeight(root);
		return(height!=-1);
	}
	
	private int getHeight(TreeNode root){
		if(root==null){
			return 0;
		}
		int leftHeight=getHeight(root.left);
		if(leftHeight==-1){
			return -1;
		}
		int rightHeight=getHeight(root.right);
		if(rightHeight==-1){
			return -1;
		}
		int diffHeight=Math.abs(rightHeight-leftHeight);
		if(diffHeight>1){
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight)+1;
		}
		
	}

	public static void main(String[] args) {
		BalancedBinaryTree s=new BalancedBinaryTree();
		
		int[] nodes;
		BinarySearchTreeNode root;
		boolean expect;
		boolean output;
		
		nodes=new int[]{5,3,7,1,4,2,8};
		root=BinarySearchTreeNode.constructTreeNode(nodes);
		expect=true;
		output=s.isBalanced(root);
		assert(expect==output):"1.wrong";
		
		nodes=new int[]{5,3,7,1,4,2};
		root=BinarySearchTreeNode.constructTreeNode(nodes);
		expect=false;
		output=s.isBalanced(root);
		assert(expect==output):"2.wrong";
		
		System.out.println("Finish");

	}

}
