package leetcode.pending;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.Test;

import static common.Util.*;

public class DiameterofBinaryTreeITest {

@Test
    public void test1() {
        DiameterofBinaryTreeI s = new DiameterofBinaryTreeI();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int expect;
        int output;

        nodes = new int[] { 1, 2, 3, 4, 5 };
        parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1 };
        children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1 };
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = 3;
        output = s.diameterOfBinaryTree(root);
        verify(expect, output, 1);

        nodes = new int[] { 4, -7, -3, -9, -3, 9, -7, -4, 6, -6, -6, 0, 6, 5, 9, -1, -4, -2 };
        parents = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2, 3, 3, 4, 5, 6, 6, 8, 8, 9, 10, 11, 12, 14 };
        children = new int[] { TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 };
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = 8;
        output = s.diameterOfBinaryTree(root);
        verify(expect, output, 2);
    }
}
