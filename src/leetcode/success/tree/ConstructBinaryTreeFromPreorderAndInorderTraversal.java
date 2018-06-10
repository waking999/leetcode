package leetcode.success.tree;

import java.util.Arrays;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		 
		int inorderLen=inorder.length;
		int preorderLen=preorder.length;
		if(inorderLen==0){
			return null;
		}
		if(preorderLen==0){
			return null;
		}
		
		if(inorderLen!=preorderLen){
			return null;
		}
		int root=preorder[0];
		int rootInorderPos=rootInorderPosition(inorder,root);
		int[] leftInorder=Arrays.copyOfRange(inorder, 0, rootInorderPos);
		int[] rightInorder=Arrays.copyOfRange(inorder, rootInorderPos+1, inorderLen);
		
		int[] leftPreorder=Arrays.copyOfRange(preorder, 1, rootInorderPos+1);
		int[] rightPreorder=Arrays.copyOfRange(preorder, rootInorderPos+1, inorderLen);
		
		TreeNode node=new TreeNode(root);
		node.left=buildTree(leftPreorder,leftInorder);
		node.right=buildTree(rightPreorder,rightInorder);
		
		return node;
		
	}
	
	 
	private int rootInorderPosition(int[] order, int root){
		int orderLen=order.length;
		if(orderLen==0){
			return -1;
		}
		if(orderLen==1){
			return 0;
		}
		for(int i=0;i<orderLen;i++){
			if(order[i]==root){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal s = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

		int[] inorder;
		int[] preorder;
		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode expect;
		Integer[] expectArray;
		int expectLen;
		TreeNode output;
		Integer[] outputArray;
		int outputArrayLen;

		inorder = new int[] { 4, 2, 5, 1, 6, 3, 7 };
		preorder = new int[] { 1,2,4,5,3,6,7 };
		nodes = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		parents = new int[] { -1, 0, 0, 1, 1, 2, 2 };
		children = new int[] { -1, 0, 1, 0, 1, 0, 1 };
		expect = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expectArray = NormalBinaryTreeNode.unconstructTreeNode(expect);
		expectLen = expectArray.length;

		output = s.buildTree(preorder, inorder);
		outputArray = NormalBinaryTreeNode.unconstructTreeNode(output);
		outputArrayLen = outputArray.length;

		assert (outputArrayLen == expectLen) : "1.wrong";
		for (int i = 0; i < expectLen; i++) {
			assert (expectArray[i] == outputArray[i]) : "1.wrong";
		}
		System.out.println("Finish");

	}

}
