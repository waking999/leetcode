package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import leetcode.success.tree.FindBottomLeftTreeValue;
import org.junit.jupiter.api.Test;

public class FindBottomLeftTreeValueTest {
    @Test
    public void test1() {
        FindBottomLeftTreeValue s = new FindBottomLeftTreeValue();

        Integer[] nodes;
        TreeNode root;
        int expect;
        int output;
        int seq = 1;

        nodes = new Integer[]{2, 1, 3};
        root = NormalBinaryTreeNode.constructTreeNode(nodes);
        expect = 1;
        output = s.findBottomLeftValue(root);
        Util.verify(expect, output, seq++);

        nodes = new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7};
        root = NormalBinaryTreeNode.constructTreeNode(nodes);
        expect = 7;
        output = s.findBottomLeftValue(root);
        Util.verify(expect, output, seq++);
    }
}
