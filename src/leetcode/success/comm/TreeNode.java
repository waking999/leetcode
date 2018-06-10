package leetcode.success.comm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	public static final int IMPOSSIBLE_VALUE = Integer.MIN_VALUE;
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	static List<Integer> getTreeNodeValueList(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<Integer> valList = new ArrayList<Integer>();

		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node != null) {
				valList.add(node.val);
				TreeNode left = node.left;
				TreeNode right = node.right;
				 
				if (left == null && right == null) {

				} else {
					q.add(left);
					q.add(right);
				}

			}  

		}
		return valList;
	}

	public static Integer[] unconstructTreeNode(TreeNode root) {
		List<Integer> valList = TreeNode.getTreeNodeValueList(root);
		int valListLen = valList.size();
		Integer[] valArray = new Integer[valListLen];
		return valList.toArray(valArray);
	}

	public String toString() {
		return Integer.toString(this.val);
	}

}
