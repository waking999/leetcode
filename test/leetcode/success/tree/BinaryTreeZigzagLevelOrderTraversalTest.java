package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversalTest {
    @Test
    public void test1() {
        BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int[][] expect;

        List<List<Integer>> output;
        int seq = 1;

        nodes = new int[]{3, 9, 20, 15, 7};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = new int[][]{{3}, {20, 9}, {15, 7}};

        output = s.zigzagLevelOrder(root);
        Util.verifyUnsort(expect, output, seq++);
    }
}
