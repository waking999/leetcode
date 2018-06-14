package leetcode.success.tree;

import common.BinarySearchTreeNode;

public class MinimumDepthOfBinaryTree {
	int minDepth;
	public int minDepth(BinarySearchTreeNode root) {
		if(root==null){
			return 0;
		}
		minDepth=Integer.MAX_VALUE;
		
		dfs(root,1);
		
        return minDepth;
    }
	
	private void dfs(BinarySearchTreeNode node,int depth){
		if(node.left==null&&node.right==null){
			minDepth=Math.min(depth, minDepth);
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
		MinimumDepthOfBinaryTree s=new MinimumDepthOfBinaryTree();

		int[] nodes;
		BinarySearchTreeNode root;
		int expect;
		int output;
		
		nodes=new int[]{5,3,7,1,4,2,8};
		root=BinarySearchTreeNode.constructTreeNode(nodes);
		expect=3;
		output=s.minDepth(root);
		assert(expect==output):"1.wrong";
		
		
		System.out.println("Finish");
	}
}
