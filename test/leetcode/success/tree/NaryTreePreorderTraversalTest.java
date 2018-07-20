package leetcode.success.tree;

import common.Node;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NaryTreePreorderTraversalTest {
    @Test
    public void test1() {
        NaryTreePreorderTraversal s = new NaryTreePreorderTraversal();

        int[] values;
        int[] parentIdxs;
        Node root;
        int[] expect;
        List<Integer> output;
        int seq = 1;

        values = new int[]{1, 3, 2, 4, 5, 6};
        parentIdxs = new int[]{Node.IMPOSSIBLE_VALUE, 0, 0, 0, 1, 1};
        root = Node.constructTreeNode(values, parentIdxs);
        expect = new int[]{1, 3, 5, 6, 2, 4};
        output = s.preorder(root);
        Util.verifyUnsort(expect, output, seq++);
    }
}
