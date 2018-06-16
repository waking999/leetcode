package leetcode.pending;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.Test;

import static common.Util.verify;

public class LongestUnivaluePathTest {
    @Test
    public void test1() {
        LongestUnivaluePath s = new LongestUnivaluePath();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int expect;
        int output;
        int seq = 0;

        nodes = new int[]{5, 4, 5, 1, 1, 5};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1, 2};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = 2;
        output = s.longestUnivaluePath(root);
        verify(expect, output, ++seq);

        nodes = new int[]{1, 4, 5, 4, 4, 5};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1, 2};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = 2;
        output = s.longestUnivaluePath(root);
        verify(expect, output, ++seq);

    }
}
