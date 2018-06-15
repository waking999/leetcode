package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.Test;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		return equalTree(root.left,root.right);
	}
	
	private boolean equalTree(TreeNode t1, TreeNode t2){
		if(t1==null&&t2==null){
			return true;
		}else if(t1==null&&t2!=null){
			return false;
		}else if(t1!=null&&t2==null){
			return false;
		}else{
			return (t1.val==t2.val)&&equalTree(t1.left,t2.right)&&equalTree(t1.right,t2.left);
		}
	}



}
