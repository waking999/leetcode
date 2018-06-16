package leetcode.success.tree;

import common.TreeNode;

public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        root = dfs(root, L, R);

        return root;
    }


    private TreeNode dfs(TreeNode node, int L, int R) {
        if (node == null) {
            return null;
        }
        if (node.val < L) {
            return dfs(node.right, L, R);
        }
        if (node.val > R) {
            return dfs(node.left, L, R);
        }
        node.left = dfs(node.left, L, R);
        node.right = dfs(node.right, L, R);
        return node;

    }


}
