package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

    @Test
    public void test1() {
        ConstructBinaryTreeFromInorderAndPostorderTraversal s = new ConstructBinaryTreeFromInorderAndPostorderTraversal();

        int[] inorder;
        int[] postorder;
        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode expectNode;
        int[] expect;

        TreeNode outputNode;
        int[] output;
        int seq = 1;

        inorder = new int[]{4, 2, 5, 1, 6, 3, 7};
        postorder = new int[]{4, 5, 2, 6, 7, 3, 1};
        nodes = new int[]{1, 2, 3, 4, 5, 6, 7};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 1, 2, 2};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1, 0, 1};
        expectNode = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = NormalBinaryTreeNode.unconstructTreeNode(expectNode);
        outputNode = s.buildTree(inorder, postorder);
        output = NormalBinaryTreeNode.unconstructTreeNode(outputNode);
        verifyUnsort(expect, output, seq++);


    }
}
