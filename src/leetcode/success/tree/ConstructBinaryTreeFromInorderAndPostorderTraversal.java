package leetcode.success.tree;

import java.util.Arrays;

import common.NormalBinaryTreeNode;
import common.TreeNode;
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


}
