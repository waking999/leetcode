package leetcode.success.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

public class BSTIterator {
    private List<Integer> nodes;
    private int pointer;
    private int nodeCount;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        pointer = 0;
        inorder(root);
        nodeCount = nodes.size();

    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        nodes.add(node.val);
        inorder(node.right);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return (pointer < nodeCount);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int val = nodes.get(pointer);
        pointer++;
        return val;
    }


}


/*
  Your BSTIterator will be called like this:
  BSTIterator i = new BSTIterator(root);
  while (i.hasNext()) v[f()] = i.next();
 */