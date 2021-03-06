package leetcode.success.tree;

import common.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 * <p>
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * <p>
 * For example,
 * <p>
 * Given the tree:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * And the value to search: 2
 * You should return this subtree:
 * <p>
 * 2
 * / \
 * 1   3
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 * <p>
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 */
public class SearchinaBinarySearchTree {
    private TreeNode rtn;

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        rtn = null;
        help(root, val);
        return rtn;
    }

    private void help(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (node.val == val) {
            rtn = node;
            return;
        }
        if (val < node.val) {
            help(node.left, val);
        } else {
            help(node.right, val);
        }
        return;
    }
}
