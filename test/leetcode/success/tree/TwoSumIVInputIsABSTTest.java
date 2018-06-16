package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class TwoSumIVInputIsABSTTest {
    @Test
    public void test1() {
        TwoSumIVInputIsABST s = new TwoSumIVInputIsABST();

        int[] nodes;
        TreeNode root;
        int k;
        boolean expect;
        boolean output;

        nodes = new int[]{5, 3, 6, 2, 4, 7};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        k = 9;
        expect = true;
        output = s.findTarget(root, k);
        verify(expect, output, 1);


        nodes = new int[]{5, 3, 6, 2, 4, 7};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        k = 28;
        expect = false;
        output = s.findTarget(root, k);
        verify(expect, output, 2);
    }
}
