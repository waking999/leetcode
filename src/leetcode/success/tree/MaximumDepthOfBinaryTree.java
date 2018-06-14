package leetcode.success.tree;

import common.BinarySearchTreeNode;

public class MaximumDepthOfBinaryTree {
	int maxDepth;
	public int maxDepth(BinarySearchTreeNode root) {
		if(root==null){
			return 0;
		}
		maxDepth=0;
		
		dfs(root,1);
		
        return maxDepth;
    }
	
	private void dfs(BinarySearchTreeNode node,int depth){
		if(node.left==null&&node.right==null){
			maxDepth=Math.max(depth, maxDepth);
			return;
		}
		if(node.left!=null){
			dfs((BinarySearchTreeNode)node.left,depth+1);
		}
		if(node.right!=null){
			dfs((BinarySearchTreeNode)node.right,depth+1);
		}
	}
	
	public static void main(String[] args) {
		MaximumDepthOfBinaryTree s=new MaximumDepthOfBinaryTree();

		int[] nodes;
		BinarySearchTreeNode root;
		int expect;
		int output;
		
		nodes=new int[]{5,3,7,1,4,2,8};
		root=BinarySearchTreeNode.constructTreeNode(nodes);
		expect=4;
		output=s.maxDepth(root);
		assert(expect==output):"1.wrong";
		
		
		System.out.println("Finish");
	}

}
