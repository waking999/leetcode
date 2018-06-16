package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    @Test
    public void test1() {
        ConstructBinaryTreeFromPreorderAndInorderTraversal s = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        int[] inorder;
        int[] preorder;
        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode expectNode;
        int[] expect;

        TreeNode outputNode;
        int[] output;
        int seq = 1;

        inorder = new int[]{4, 2, 5, 1, 6, 3, 7};
        preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        nodes = new int[]{1, 2, 3, 4, 5, 6, 7};
        parents = new int[]{-1, 0, 0, 1, 1, 2, 2};
        children = new int[]{-1, 0, 1, 0, 1, 0, 1};
        expectNode = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = NormalBinaryTreeNode.unconstructTreeNode(expectNode);
        outputNode = s.buildTree(preorder, inorder);
        output = NormalBinaryTreeNode.unconstructTreeNode(outputNode);
        verifyUnsort(expect, output, seq++);
    }
}
