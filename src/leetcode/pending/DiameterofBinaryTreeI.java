package leetcode.pending;

import common.TreeNode;

public class DiameterofBinaryTreeI {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lH = getHeight(root.left);
        int rH = getHeight(root.right);

        // left, right subtree diameter
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);

        int maxSubDia = Math.max(leftDia, rightDia);
        return Math.max(maxSubDia, lH + rH);

    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lH = getHeight(node.left);
        int rH = getHeight(node.right);
        return Math.max(lH, rH) + 1;

    }


}
