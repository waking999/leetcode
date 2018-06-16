package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class ConvertBSTToGreaterTreeTest {
    @Test
    public void test1() {
        ConvertBSTToGreaterTree s = new ConvertBSTToGreaterTree();

        int[] nodes;
        TreeNode root;
        int[] expect;
        TreeNode outputNode;
        int[] output;
        int seq = 1;

        nodes = new int[]{5, 2, 13};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        outputNode = s.convertBST(root);
        expect = new int[]{18, 20, 13};
        output = TreeNode.unconstructTreeNode(outputNode);
        verifyUnsort(expect, output, seq++);

    }
}
