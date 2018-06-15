package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.Test;

public class ConvertSortedArrayToBinarySearchTreeTest {
    @Test
    public void test1() {
        ConvertSortedArrayToBinarySearchTree s = new ConvertSortedArrayToBinarySearchTree();

        int[] nodes;
        TreeNode outputNode;
        int[] output;


        nodes = new int[]{4, 5, 8, 11, 13, 17, 22, 23, 31, 58};
        outputNode = s.sortedArrayToBST(nodes);
        output = NormalBinaryTreeNode.unconstructTreeNode(outputNode);
        Util.verifyUnsort(nodes, output, 1);


    }
}
