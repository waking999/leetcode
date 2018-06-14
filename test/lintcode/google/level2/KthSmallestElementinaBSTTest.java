package lintcode.google.level2;

import common.BinarySearchTreeNode;
import common.TreeNode;
import org.junit.Test;

import static common.Util.*;

public class KthSmallestElementinaBSTTest {
    @Test
    public void testkthSmallest() {
        KthSmallestElementinaBST s = new KthSmallestElementinaBST();

        int[] nodes;
        TreeNode root;
        int k;
        int expect;
        int output;
        int seq = 1;

        nodes = new int[]{1, 2, 3, 4, 5, 6, 7, 9};
        k = 4;
        expect = 4;
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        output = s.kthSmallest(root, k);
        verify(expect, output, seq++);

    }
}
