package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class PathSumIITest {
    @Test
    public void test1() {
        PathSumII s = new PathSumII();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int sum;
        int[][] expect;

        List<List<Integer>> output;
        int seq = 1;

        nodes = new int[]{5, 4, 8, 11, 13, 4, 7, 2, 5, 1};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 2, 2, 3, 3, 5, 5};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 0, 1, 0, 1, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = new int[][]{{5, 4, 11, 2}, {5, 8, 4, 5}};

        sum = 22;
        output = s.pathSum(root, sum);
        verifyUnsort(expect, output, seq++);

    }
}
