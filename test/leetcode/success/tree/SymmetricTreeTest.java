package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class SymmetricTreeTest {
    @Test
    public void test1() {
        SymmetricTree s = new SymmetricTree();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        boolean expect;
        boolean output;
        int seq = 1;

        nodes = new int[]{1, 2, 2, 3, 4, 4, 3};
        parents = new int[]{-1, 0, 0, 1, 1, 2, 2};
        children = new int[]{-1, 0, 1, 0, 1, 0, 1};
        expect = true;
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        output = s.isSymmetric(root);
        verify(expect, output, seq++);

        nodes = new int[]{1, 2, 2, -1, 3, -1, 3};
        parents = new int[]{-1, 0, 0, 1, 1, 2, 2};
        children = new int[]{-1, 0, 1, 0, 1, 0, 1};
        expect = false;
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        output = s.isSymmetric(root);
        verify(expect, output, seq++);

        nodes = new int[]{1, 2, 3};
        parents = new int[]{-1, 0, 0};
        children = new int[]{-1, 0, 1};
        expect = false;
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        output = s.isSymmetric(root);
        verify(expect, output, seq++);


    }
}
