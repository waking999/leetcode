package leetcode.success.tree;

import common.TreeNode;

public class MinimumDistanceBetweenBSTNodes {

    int minDiff;
    Integer prev;

    public int minDiffInBST(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        inorder(node.right);
    }


}
