package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class SecondMinimumNodeInABinaryTreeTest {
    @Test
    public void test1() {
        SecondMinimumNodeInABinaryTree s = new SecondMinimumNodeInABinaryTree();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int expect;
        int output;

        nodes = new int[]{2, 2, 5, 5, 7};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = 5;
        output = s.findSecondMinimumValue(root);
        verify(expect, output, 1);


        nodes = new int[]{2, 2, 2};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = -1;
        output = s.findSecondMinimumValue(root);
        verify(expect, output, 2);
    }
}
