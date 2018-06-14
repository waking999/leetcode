package leetcode.success.tree;

import java.util.Arrays;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

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

	@Test
	public void test1() {
		ConstructBinaryTreeFromPreorderAndInorderTraversal s = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

		int[] inorder;
		int[] preorder;
		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode expectNode;
		int[] expect;

		TreeNode outputNode;
		int[] output;
		int seq=1;

		inorder = new int[] { 4, 2, 5, 1, 6, 3, 7 };
		preorder = new int[] { 1,2,4,5,3,6,7 };
		nodes = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		parents = new int[] { -1, 0, 0, 1, 1, 2, 2 };
		children = new int[] { -1, 0, 1, 0, 1, 0, 1 };
		expectNode = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = NormalBinaryTreeNode.unconstructTreeNode(expectNode);
		outputNode = s.buildTree(preorder, inorder);
		output = NormalBinaryTreeNode.unconstructTreeNode(outputNode);
		Util.verifyUnsort(expect ,output ,seq++);
	}

}
