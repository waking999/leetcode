package leetcode.pending;

import common.TreeNode;

public class BinaryTreeTilt {

    int tilt;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        tilt = 0;
        postorder(root);
        return tilt;
    }

    private int postorder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = postorder(node.left);
        int r = postorder(node.right);
        tilt += Math.abs(l - r);
        return l + r + node.val;
    }


}
