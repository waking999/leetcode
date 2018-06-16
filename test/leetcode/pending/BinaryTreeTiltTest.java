package leetcode.pending;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class BinaryTreeTiltTest {

    @Test
    public void test1() {
        BinaryTreeTilt s = new BinaryTreeTilt();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int expect;
        int output;

        nodes = new int[]{1, 2, 3};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = 1;
        output = s.findTilt(root);
        verify(expect, output, 1);

    }
}
