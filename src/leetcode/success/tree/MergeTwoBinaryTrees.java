package leetcode.success.tree;

import java.util.Stack;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;

public class MergeTwoBinaryTrees {
	 
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		Stack<TreeNode[]> stack = new Stack<TreeNode[]>();
		stack.push(new TreeNode[] { t1, t2 });
		while (!stack.isEmpty()) {
			TreeNode[] t = stack.pop();
			if(t[0]==null||t[1]==null){
				continue;
			}
			t[0].val+=t[1].val;
			if(t[0].left==null){
				t[0].left=t[1].left;
			}else{
				stack.push(new TreeNode[]{t[0].left,t[1].left});
			}
			if(t[0].right==null){
				t[0].right=t[1].right;
			}else{
				stack.push(new TreeNode[]{t[0].right,t[1].right});
			}
			 
		}
		return t1;
	}

	public static void main(String[] args) {
		MergeTwoBinaryTrees s = new MergeTwoBinaryTrees();

		int[] nodes1;
		int[] parents1;
		int[] children1;
		int[] nodes2;
		int[] parents2;
		int[] children2;
		int[] expect;
		int expectLen;

		TreeNode root1;
		TreeNode root2;
		TreeNode output;
		Integer[] outputArray;
		int outputArrayLen;

		nodes1 = new int[] { 1, 3, 2, 5 ,7};
		parents1 = new int[] { -1, 0, 0, 1 ,1};
		children1 = new int[] { -1, 0, 1, 0 ,1};
		nodes2 = new int[] { 2, 1, 3, -1, 4, -1, 7 };
		parents2 = new int[] { -1, 0, 0, 1, 1, 2, 2 };
		children2 = new int[] { -1, 0, 1, 0, 1, 0, 1 };
		expect = new int[] { 3, 4, 5, 5, 4, -1, 7 };
		expectLen = expect.length;

		root1 = NormalBinaryTreeNode.constructTreeNode(nodes1, parents1, children1);
		root2 = NormalBinaryTreeNode.constructTreeNode(nodes2, parents2, children2);
		output = s.mergeTrees(root1, root2);

		outputArray = NormalBinaryTreeNode.unconstructTreeNode(output);
		outputArrayLen = outputArray.length;

		assert (outputArrayLen == expectLen) : "1.wrong";
		for (int i = 0; i < expectLen; i++) {
			assert (expect[i] == outputArray[i]) : "1.wrong";
		}

		System.out.println("Finish");

	}

}
