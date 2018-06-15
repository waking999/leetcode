package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import org.junit.Test;

import static common.Util.verifyUnsort;

public class TrimABinarySearchTreeTest {
    @Test
    public void test1() {
        TrimABinarySearchTree s = new TrimABinarySearchTree();

        int[] nodes;
        TreeNode root;
        int L;
        int R;
        int[] expect;
        TreeNode outputNode;
        int[] output;
        int seq = 1;

        nodes = new int[]{1, 0, 2};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        L = 1;
        R = 2;
        expect = new int[]{1, 2};
        outputNode = s.trimBST(root, L, R);
        output = BinarySearchTreeNode.unconstructTreeNode(outputNode);
        verifyUnsort(expect, output, seq++);

        nodes = new int[]{3, 0, 4, 2, 1};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        L = 1;
        R = 3;
        expect = new int[]{3, 2, 1};
        outputNode = s.trimBST(root, L, R);
        verifyUnsort(expect, output, seq++);
    }
}
