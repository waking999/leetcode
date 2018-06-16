package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import org.junit.Test;

import static common.Util.verify;

public class MinimumAbsoluteDifferenceInBSTTest {
    @Test
    public void test1() {
        MinimumAbsoluteDifferenceInBST s = new MinimumAbsoluteDifferenceInBST();

        int[] nodes;
        TreeNode root;
        int expect;
        int output;

        nodes = new int[]{1, 3, 2};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        expect = 1;
        output = s.getMinimumDifference(root);
        verify(expect, output, 1);


    }
}
