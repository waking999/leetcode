package leetcode.success.tree;

import java.util.Arrays;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int inorderLen=inorder.length;
		int postorderLen=postorder.length;
		if(inorderLen==0){
			return null;
		}
		if(postorderLen==0){
			return null;
		}
		
		if(inorderLen!=postorderLen){
			return null;
		}
		int root=postorder[postorderLen-1];
		int rootInorderPos=rootInorderPosition(inorder,root);
		int[] leftInorder=Arrays.copyOfRange(inorder, 0, rootInorderPos);
		int[] rightInorder=Arrays.copyOfRange(inorder, rootInorderPos+1, inorderLen);
		
		int[] leftPostorder=Arrays.copyOfRange(postorder, 0, rootInorderPos);
		int[] rightPostorder=Arrays.copyOfRange(postorder, rootInorderPos, inorderLen-1);
		
		TreeNode node=new TreeNode(root);
		node.left=buildTree(leftInorder,leftPostorder);
		node.right=buildTree(rightInorder,rightPostorder);
		
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
		ConstructBinaryTreeFromInorderAndPostorderTraversal s = new ConstructBinaryTreeFromInorderAndPostorderTraversal();

		int[] inorder;
		int[] postorder;
		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode expectNode;
		int[] expect;

		TreeNode outputNode;
		int[] output;
		int seq=1;
		
		inorder=new int[]{4,2,5,1,6,3,7};
		postorder=new int[]{4,5,2,6,7,3,1};
		nodes=new int[]{1,2,3,4,5,6,7};
		parents=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,0,1,1,2,2};
		children=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1,0,1,0,1};
		expectNode=NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = NormalBinaryTreeNode.unconstructTreeNode(expectNode);
		outputNode=s.buildTree(inorder, postorder);
		output = NormalBinaryTreeNode.unconstructTreeNode(outputNode);
		Util.verifyUnsort(expect,output,seq++);
		
		
	}

}
