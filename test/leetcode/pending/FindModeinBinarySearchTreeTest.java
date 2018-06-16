package leetcode.pending;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.Test;

import static common.Util.verifySort;

public class FindModeinBinarySearchTreeTest {
    @Test
    public void test1() {
        FindModeinBinarySearchTree s = new FindModeinBinarySearchTree();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int[] expect;
        int[] output;

        nodes = new int[]{1, 2, 2};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 1, 0};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = new int[]{2};
        output = s.findMode(root);
        verifySort(expect, output, 1);

    }
}
