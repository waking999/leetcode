package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class BinaryTreeLevelOrderTraversalIITest {

    @Test
    public void test1() {
        BinaryTreeLevelOrderTraversalII s = new BinaryTreeLevelOrderTraversalII();
        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int[][] expect;

        List<List<Integer>> output;

        nodes = new int[]{3, 9, 20, 15, 7};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = new int[][]{{15, 7}, {9, 20}, {3}};

        output = s.levelOrderBottom(root);

        verifyUnsort(expect, output, 1);

    }
}
