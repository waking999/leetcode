package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

public class LeafSimilarTreesTest {
    @Test
    public void test1() {
        LeafSimilarTrees s = new LeafSimilarTrees();

        Integer[] nodes1;
        Integer[] nodes2;
        TreeNode root1;
        TreeNode root2;
        boolean expect;
        boolean output;
        int seq = 1;

        nodes1 = new Integer[]{3, 5, 1, 6,null,null, 2, 9, 8,null,null,null,null, 7, 4,null,null};
        nodes2 = new Integer[]{3, 5, 1, 6,null,null, 2, 9, 8,null,null,null,null, 7, 4,null,null};
        root1 = NormalBinaryTreeNode.constructTreeNode(nodes1);
        root2 = NormalBinaryTreeNode.constructTreeNode(nodes2);
        expect = true;
        output = s.leafSimilar(root1, root2);
        Util.verify(expect, output, seq++);

        nodes1 = new Integer[]{3, 5, 1, 6,null,null, 2, 9, 8,null,null,null,null, 7, 4,null,null};
        nodes2 = new Integer[]{4, 5, 1, 6,null,null, 2, 9, 8,null,null,null,null, 7, 4,null,null};
        root1 = NormalBinaryTreeNode.constructTreeNode(nodes1);
        root2 = NormalBinaryTreeNode.constructTreeNode(nodes2);
        expect = true;
        output = s.leafSimilar(root1, root2);
        Util.verify(expect, output, seq++);

        nodes1 = new Integer[]{3, 5, 1, 6,null,null, 2, 9, 8,null,null,null,null, 7, 4,null,null};
        nodes2 = new Integer[]{3, 5, 1, 6,null,null, 2, 9, 8,null,null,null,null, 7, 3,null,null};
        root1 = NormalBinaryTreeNode.constructTreeNode(nodes1);
        root2 = NormalBinaryTreeNode.constructTreeNode(nodes2);
        expect = false;
        output = s.leafSimilar(root1, root2);
        Util.verify(expect, output, seq++);

    }

}
