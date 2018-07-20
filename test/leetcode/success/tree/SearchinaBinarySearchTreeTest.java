package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchinaBinarySearchTreeTest {
    @Test
    public void test1() {
        SearchinaBinarySearchTree s = new SearchinaBinarySearchTree();

        int[] nodes;
        TreeNode root;
        int val;
        int[] expect;
        TreeNode outputNode;
        List<Integer> output;
        int seq = 1;

        nodes = new int[]{4, 2, 7, 1, 3};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        expect = new int[]{2, 1, 3};
        val = 2;
        outputNode = s.searchBST(root, val);
        output = TreeNode.unconstructTreeNodeList(outputNode);
        Util.verifyUnsort(expect, output, seq++);

        nodes = new int[]{4, 2, 7, 1, 3};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        expect = null;
        val = 5;
        outputNode = s.searchBST(root, val);
        output = TreeNode.unconstructTreeNodeList(outputNode);
        Util.verifyUnsort(expect, output, seq++);
    }
}
