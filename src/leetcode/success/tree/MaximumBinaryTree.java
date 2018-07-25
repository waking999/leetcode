package leetcode.success.tree;

import common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/description/
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * <p>
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * Note:
 * The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums == null) {
            return null;
        }
        int numsLen = nums.length;
        if (numsLen == 0) {
            return null;
        }
        TreeNode dumpNode = new TreeNode(-1);

        helper(nums, 0, numsLen - 1, dumpNode, true);

        return dumpNode.left;
    }

    private void helper(int[] nums, int l, int r, TreeNode parentNode, boolean isLeft) {
        if (l > r) {
            return;
        }
        int maxPos = findMaxPos(nums, l, r);
        int val = nums[maxPos];
        TreeNode n = new TreeNode(val);
        if (isLeft) {
            parentNode.left = n;
        } else {
            parentNode.right = n;
        }
        helper(nums, l, maxPos - 1, n, true);
        helper(nums, maxPos + 1, r, n, false);

    }

    private int findMaxPos(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        int pos = l;
        for (int i = l; i <= r; i++) {
            if (max < nums[i]) {
                max = nums[i];
                pos = i;
            }
        }
        return pos;
    }
}
