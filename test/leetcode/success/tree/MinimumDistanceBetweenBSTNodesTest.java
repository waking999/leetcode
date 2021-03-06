package leetcode.success.tree;

import common.BinarySearchTreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class MinimumDistanceBetweenBSTNodesTest {
    @Test
    public void testMinDiffInBST() {
        MinimumDistanceBetweenBSTNodes s = new MinimumDistanceBetweenBSTNodes();

        int[] nodes;
        BinarySearchTreeNode root;
        int expect;
        int output;
        int seq = 0;

        nodes = new int[]{4, 2, 6, 1, 3};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        expect = 1;
        output = s.minDiffInBST(root);
        verify(expect, output, seq++);

        nodes = new int[]{90, 69, 49, 89, 52};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        expect = 1;
        output = s.minDiffInBST(root);
        verify(expect, output, seq++);


    }
}
