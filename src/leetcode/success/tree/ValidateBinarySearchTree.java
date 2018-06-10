package leetcode.success.tree;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	
	private boolean dfs(TreeNode node,long min,long max){
		if(node==null){
			return true;
		}
		if(node.val<=min||node.val>=max){
			return false;
		}
		return dfs(node.left,min, node.val)&&dfs(node.right,node.val,max);
		
 
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree s=new ValidateBinarySearchTree();
		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		boolean expect;
		boolean output;

		nodes = new int[] { 2,1,3};
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0  };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1  };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect=true;
		output=s.isValidBST(root);
		assert(expect==output):"1:wrong";
		
		nodes = new int[] { 1,2,3};
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0  };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1  };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect=false;
		output=s.isValidBST(root);
		assert(expect==output):"2:wrong";
		
		
		nodes = new int[] {0,-1};
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0   };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0  };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect=true;
		output=s.isValidBST(root);
		assert(expect==output):"3:wrong";
		
		nodes = new int[] {1,1};
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0   };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0  };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect=false;
		output=s.isValidBST(root);
		assert(expect==output):"4:wrong";
		
		nodes = new int[] {10,5,15,TreeNode.IMPOSSIBLE_VALUE,TreeNode.IMPOSSIBLE_VALUE,6,20};
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0 ,0,1,1,2,2  };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0,1,0,1,0,1  };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect=false;
		output=s.isValidBST(root);
		assert(expect==output):"5:wrong";
		
		nodes = new int[] {2147483647};
		parents = new int[] { TreeNode.IMPOSSIBLE_VALUE  };
		children = new int[] { TreeNode.IMPOSSIBLE_VALUE  };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect=true;
		output=s.isValidBST(root);
		assert(expect==output):"6:wrong";
		
		System.out.println("Finish");
		
	}

}
