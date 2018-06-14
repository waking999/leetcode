package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.Test;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, start, mid - 1);
        node.right = build(nums, mid + 1, end);
        return node;
    }

    @Test
    public void test1() {
        ConvertSortedArrayToBinarySearchTree s = new ConvertSortedArrayToBinarySearchTree();

        int[] nodes;
        int nodesLen;
        TreeNode outputNode;
        int[] output;
        int outputArrayLen;

        nodes = new int[]{4, 5, 8, 11, 13, 17, 22, 23, 31, 58};
        nodesLen = nodes.length;
        outputNode = s.sortedArrayToBST(nodes);
        output = NormalBinaryTreeNode.unconstructTreeNode(outputNode);
        outputArrayLen = output.length;

        assert (outputArrayLen == nodesLen) : "1.wrong";
        for (int i = 0; i < nodesLen; i++) {
            assert (nodes[i] == output[i]) : "1.wrong:" + i;
        }

        System.out.println("Finish");

    }

}
