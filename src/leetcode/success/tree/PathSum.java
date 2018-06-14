package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null){
			return false;
		}
		return dfs(root,0,sum);
	}
	
	private boolean dfs(TreeNode node,int sum, int target){
		if(node==null){
			return false;
		}
		sum+=node.val;
		if(node.left==null&&node.right==null){
			return sum==target;
		}
		boolean leftPart=dfs(node.left,sum,target);
		boolean rightPart=dfs(node.right,sum,target);		
		
		return leftPart|rightPart;
	}

	public static void main(String[] args) {
		PathSum s=new PathSum();
		
		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int sum;
		boolean expect;
		boolean output;
		
		nodes=new int[]{5,4,8,11,-1,13,4,7,2,-1,-1,-1,1};
		parents=new int[]{-1,0,0,1,1,2,2,3,3,5,5,6,6};
		children=new int[]{-1,0,1,0,1,0,1,0,1,0,1,0,1};
		root=NormalBinaryTreeNode.constructTreeNode(nodes,parents, children);
		expect=true;
		sum=22;
		output=s.hasPathSum(root,sum);
		assert(expect==output):"1.wrong";
		
	 
		nodes=new int[]{5,4,8,11,-1,13,4,7,2,-1,-1,-1,1};
		parents=new int[]{-1,0,0,1,1,2,2,3,3,5,5,6,6};
		children=new int[]{-1,0,1,0,1,0,1,0,1,0,1,0,1};
		root=NormalBinaryTreeNode.constructTreeNode(nodes,parents, children);
		expect=true;
		sum=27;
		output=s.hasPathSum(root,sum);
		assert(expect==output):"2.wrong";
		
		nodes=new int[]{5,4,8,11,-1,13,4,7,2,-1,-1,-1,1};
		parents=new int[]{-1,0,0,1,1,2,2,3,3,5,5,6,6};
		children=new int[]{-1,0,1,0,1,0,1,0,1,0,1,0,1};
		root=NormalBinaryTreeNode.constructTreeNode(nodes,parents, children);
		expect=false;
		sum=122;
		output=s.hasPathSum(root,sum);
		assert(expect==output):"3.wrong";
		
		
		nodes=new int[]{};
		parents=new int[]{};
		children=new int[]{};
		root=NormalBinaryTreeNode.constructTreeNode(nodes,parents, children);
		expect=false;
		sum=0;
		output=s.hasPathSum(root,sum);
		assert(expect==output):"4.wrong";
		
		
		nodes=new int[]{1,2};
		parents=new int[]{-1,0};
		children=new int[]{-1,1};
		root=NormalBinaryTreeNode.constructTreeNode(nodes,parents, children);
		expect=false;
		sum=1;
		output=s.hasPathSum(root,sum);
		assert(expect==output):"5.wrong";
		
		System.out.println("Finish");

 
	}

}
