package leetcode.pending;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class BinaryTreePreorderTraversalTest {
    @Test
    public void test1() {
        BinaryTreePreorderTraversal s = new BinaryTreePreorderTraversal();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int[] expect;

        List<Integer> output;
        int seq = 1;

        nodes = new int[]{1, 2, 3};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 1, 0};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = new int[]{1, 2, 3};

        output = s.preorderTraversal(root);
        verifyUnsort(expect, output, seq++);
    }

}
