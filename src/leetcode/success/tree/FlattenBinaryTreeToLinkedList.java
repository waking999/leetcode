package leetcode.success.tree;

import java.util.Stack;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.Test;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		
		if (root == null) {
			return;
		}
		
		
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		TreeNode ret=new TreeNode(root.val);
		TreeNode n=ret;
		
		while (!s.isEmpty()) {
			TreeNode p=s.peek();
			n.right=p;
			n.left=null;
			n=n.right;
			s.pop();
			 
			if(p.right!=null){
				s.push(p.right);
			}
			
			if(p.left!=null){
				s.push(p.left);
			}
			
		}
		root=ret.right;
	}



}
