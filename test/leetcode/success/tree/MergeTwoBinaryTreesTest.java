package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.Test;

import static common.Util.verifyUnsort;

public class MergeTwoBinaryTreesTest {
    @Test
    public void test1() {
        MergeTwoBinaryTrees s = new MergeTwoBinaryTrees();

        int[] nodes1;
        int[] parents1;
        int[] children1;
        int[] nodes2;
        int[] parents2;
        int[] children2;
        int[] expect;


        TreeNode root1;
        TreeNode root2;
        TreeNode outputNode;
        int[] output;
        int seq = 1;

        nodes1 = new int[]{1, 3, 2, 5, 7};
        parents1 = new int[]{-1, 0, 0, 1, 1};
        children1 = new int[]{-1, 0, 1, 0, 1};
        nodes2 = new int[]{2, 1, 3, -1, 4, -1, 7};
        parents2 = new int[]{-1, 0, 0, 1, 1, 2, 2};
        children2 = new int[]{-1, 0, 1, 0, 1, 0, 1};
        expect = new int[]{3, 4, 5, 5, 4, -1, 7};

        root1 = NormalBinaryTreeNode.constructTreeNode(nodes1, parents1, children1);
        root2 = NormalBinaryTreeNode.constructTreeNode(nodes2, parents2, children2);
        outputNode = s.mergeTrees(root1, root2);

        output = NormalBinaryTreeNode.unconstructTreeNode(outputNode);
        verifyUnsort(expect, output, seq++);
    }
}
