package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class BinaryTreeInorderTraversalTest {
    @Test
    public void testinorderTraversal() {
        BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int[] expect;
        List<Integer> output;
        int seq = 0;

        nodes = new int[]{1, 2, 3};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 1, 0};
        expect = new int[]{1, 3, 2};

        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        output = s.inorderTraversal(root);
        verifyUnsort(expect, output, seq++);

    }
}
