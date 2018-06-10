package leetcode.success.tree;

import java.util.Stack;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class SumRootToLeafNumbers {
	int sum;
	public int sumNumbers(TreeNode root) {
		sum=0;
		Stack<Integer> s=new Stack<>();
		dfs(root,s);
		return sum;
    }
	private void dfs(TreeNode node,Stack<Integer> s){
		if(node==null){
			return;
		}
		s.push(node.val);
		if(node.left==null&&node.right==null){
			int num=stackToInt(s);
			sum+=num;
			 
		}else{
			if(node.left!=null){
				dfs(node.left,s);
			}
			if(node.right!=null){
				dfs(node.right,s);
			}
		}
		s.pop();
	}
	
	private int stackToInt(Stack<Integer> s){
		int num=0;
		for(Integer i:s){
			num=num*10+i;
		}
		return num;
	}
	public static void main(String[] args) {
		SumRootToLeafNumbers s=new SumRootToLeafNumbers();
		
		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int expect;
		int output;

		nodes = new int[] { 1,2,3 };
		parents = new int[] { -1, 0,0 };
		children = new int[] { -1, 0, 1 };
		expect = 25;
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		output = s.sumNumbers(root);
		assert (expect == output) : "1.wrong";
		
		System.out.println("Finish");
	}

}
