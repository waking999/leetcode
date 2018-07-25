package leetcode.success.tree;

import common.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 * <p>
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 * <p>
 * For example,
 * <p>
 * Given the tree:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * This tree is also valid:
 * <p>
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 */
public class InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        helper(root, val, false);

        return root;
    }

    private void helper(TreeNode parentNode, int val, boolean inserted) {
        if (inserted) {
            return;
        }
        if (parentNode == null) {
            return;
        }
        if (val < parentNode.val) {
            if (parentNode.left == null) {
                parentNode.left = new TreeNode(val);
                inserted = true;
                return;
            } else {
                helper(parentNode.left, val, inserted);
            }
        } else {
            if (parentNode.right == null) {
                parentNode.right = new TreeNode(val);
                inserted = true;
                return;
            } else {
                helper(parentNode.right, val, inserted);
            }
        }


    }

}
