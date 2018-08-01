package leetcode.success.tree;

import common.TreeNode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Output:
 * 1
 * Example 2:
 * Input:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        left = new int[1000];
        Arrays.fill(left, -1);
        left[0]=root.val;
        leftSize = 1;

        int level = 0;
        helper(root, level);
        return left[leftSize-1];
    }

    private int[] left;
    private int leftSize;

    private void helper(TreeNode node, int level ) {

        if (level >= leftSize && left[leftSize] == -1) {
            left[leftSize++]=node.val;
        }
        if(node.left!=null) {
            helper(node.left, level + 1);
        }
        if(node.right!=null) {
            helper(node.right, level + 1);
        }
    }
}
