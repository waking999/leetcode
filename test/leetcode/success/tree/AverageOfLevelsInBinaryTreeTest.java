package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class AverageOfLevelsInBinaryTreeTest {
    @Test
    public void test1() {
        AverageOfLevelsInBinaryTree s = new AverageOfLevelsInBinaryTree();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        double[] expect;
        List<Double> output;

        nodes = new int[]{3, 9, 20, 15, 7};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = new double[]{3, 14.5, 11};
        output = s.averageOfLevels(root);
        verifyUnsort(expect, output, 1);

        nodes = new int[]{5, 14, 1};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = new double[]{5, 14, 1};
        output = s.averageOfLevels(root);
        verifyUnsort(expect, output, 2);

        nodes = new int[]{2147483647, 2147483647, 2147483647};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = new double[]{2147483647, 2147483647};
        output = s.averageOfLevels(root);
        verifyUnsort(expect, output, 3);
    }

}
