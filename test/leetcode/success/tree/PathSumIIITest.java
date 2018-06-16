package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class PathSumIIITest {
    @Test
    public void test1() {
        PathSumIII s = new PathSumIII();
        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int sum;
        int expect;
        int output;

        nodes = new int[]{10, 5, -3, 3, 2, 11, 3, -2, 1};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1, 2, 3, 3, 4};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1, 1, 0, 1, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        sum = 8;

        expect = 3;
        output = s.pathSum(root, sum);
        verify(expect, output, 1);
    }
}
