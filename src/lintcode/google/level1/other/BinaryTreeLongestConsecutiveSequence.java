package lintcode.google.level1.other;

import common.TreeNode;

/**
 * Binary Tree Longest Consecutive Sequence
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * Example
 * For example,
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        return dfs(root,null,0);
    }

    private int dfs(TreeNode node, TreeNode parent, int lengthWithoutRoot){
        if(node==null){
            return 0;
        }
        int length=(parent!=null&&parent.val+1==node.val)?lengthWithoutRoot+1:1;
        int left=dfs(node.left,node,length);
        int right=dfs(node.right,node,length);
        return Math.max(length,Math.max(left,right));

    }
}
