package leetcode.pending;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class DiameterOfBinaryTreeTest {
    @Test
    public void test1() {
        DiameterOfBinaryTree s = new DiameterOfBinaryTree();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int expect;
        int output;

        nodes = new int[]{1, 2, 3, 4, 5};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = 3;
        output = s.diameterOfBinaryTree(root);
        verify(expect, output, 1);
    }
}
