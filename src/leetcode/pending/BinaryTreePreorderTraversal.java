package leetcode.pending;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}

		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		
		while (!s.isEmpty()) {
			TreeNode node=s.peek();
			ret.add(node.val);
			s.pop();
			 
			if(node.right!=null){
				s.push(node.right);
			}
			
			if(node.left!=null){
				s.push(node.left);
			}
			
		}
		
		return ret;
	}

	public static void main(String[] args) {
		BinaryTreePreorderTraversal s = new BinaryTreePreorderTraversal();

		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		int[] expect;
		int expectLen;
		List<Integer> output;
		int outputSize;

		nodes = new int[] { 1, 2, 3 };
		parents = new int[] { -1, 0, 1 };
		children = new int[] { -1, 1, 0 };
		root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		expect = new int[] { 1, 2, 3 };
		expectLen = expect.length;
		output = s.preorderTraversal(root);
		outputSize = output.size();
		assert (outputSize == expectLen) : "1:wrong";
		String s1 = IntStream.of(expect).map(str -> str).boxed().collect(Collectors.toList()).stream()
				.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		String s2 = output.stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
		assert (s1.equals(s2)) : "1:wrong";

		System.out.println("Finish");
	}

}
