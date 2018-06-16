package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ConstructStringfromBinaryTreeTest {
    @Test
    public void test1() {
        ConstructStringfromBinaryTree s = new ConstructStringfromBinaryTree();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode t;
        String expect;
        String output;

        nodes = new int[]{1, 2, 3, 4};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0};
        t = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = "1(2(4))(3)";
        output = s.tree2str(t);
        verify(expect, output, 1);

        nodes = new int[]{1, 2, 3, 4};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 1};
        t = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = "1(2()(4))(3)";
        output = s.tree2str(t);
        verify(expect, output, 2);

        nodes = new int[]{1, 2, 3};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        t = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = "1(2)(3)";
        output = s.tree2str(t);
        verify(expect, output, 2);
    }
}
