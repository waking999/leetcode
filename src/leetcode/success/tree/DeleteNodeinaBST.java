package leetcode.success.tree;

import common.TreeNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 * <p>
 * Example:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * <p>
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * Another valid answer is [5,2,6,null,4,null,7].
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 */
public class DeleteNodeinaBST {
    private boolean found;

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode dump = new TreeNode(-1);
        dump.left = root;
        found = false;
        helper(dump, root, true, key);

        return dump.left;
    }

    private void helper(TreeNode parentNode, TreeNode childNode, boolean isLeft, int key) {
        if (childNode == null) {
            return;
        }
        if (!found) {
            if (childNode.val == key) {
                found = true;
            /*
            1. child.left...(most right right)=child.right
            2. if isLeft, parent.left=child.left
               if !isLeft, parent.right=child.left
            */
                if (childNode.left != null) {
                    TreeNode mostRight = getMostRight(childNode.left);
                    mostRight.right = childNode.right;
                    if (isLeft) {
                        parentNode.left = childNode.left;
                    } else {
                        parentNode.right = childNode.left;
                    }
                } else {
                    if (isLeft) {
                        parentNode.left = childNode.right;
                    } else {
                        parentNode.right = childNode.right;
                    }
                }

                return;
            }
        }
        if (!found) {
            if (key < childNode.val) {
                helper(childNode, childNode.left, true, key);
            }
        }
        if (!found) {
            if (key > childNode.val) {
                helper(childNode, childNode.right, false, key);

            }
        }
    }

    private TreeNode getMostRight(TreeNode node) {
        TreeNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
}
