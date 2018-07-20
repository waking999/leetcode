package leetcode.success.tree;

import common.Node;

import java.util.List;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * For example, given a 3-ary tree:
 * We should return its max depth, which is 3.
 * <p>
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class MaximumDepthofNaryTree {

    private int maxLevel;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        maxLevel = 0;
        helper(root, 0);
        return maxLevel;
    }

    private void helper(Node node, int level) {
        List<Node> children = node.children;
        if (children == null) {
            return;
        }
        if (maxLevel < level + 1) {
            maxLevel = level + 1;
        }

        for (Node child : children) {
            helper(child, level + 1);
        }

    }


}
