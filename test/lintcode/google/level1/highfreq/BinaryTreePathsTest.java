package lintcode.google.level1.highfreq;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinaryTreePathsTest {
    @Test
    public void test1() {
        BinaryTreePaths s = new BinaryTreePaths();

        int[] nodes;
        int[] parentIdxs;
        int[] childrenPos;
        TreeNode root;
        String[] expect;
        List<String> output;
        int seq = 1;

        nodes = new int[]{1, 2, 3, 5};
        parentIdxs = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1};
        childrenPos = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parentIdxs, childrenPos);
        expect = new String[]{"1->2->5", "1->3"};
        output = s.binaryTreePaths(root);
        Util.verifyUnsort(expect, output, seq++);


        nodes = new int[]{};
        parentIdxs = new int[]{};
        childrenPos = new int[]{};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parentIdxs, childrenPos);
        expect = new String[]{};
        output = s.binaryTreePaths(root);
        Util.verifyUnsort(expect, output, seq++);

    }
}
