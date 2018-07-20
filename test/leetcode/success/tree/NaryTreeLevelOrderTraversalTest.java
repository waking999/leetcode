package leetcode.success.tree;

import common.Node;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NaryTreeLevelOrderTraversalTest {
    @Test
    public void test1() {
        NaryTreeLevelOrderTraversal s = new NaryTreeLevelOrderTraversal();

        int[] values;
        int[] parentIdxs;
        Node root;
        int[][] expect;
        List<List<Integer>> output;
        int seq = 1;

        values = new int[]{1, 3, 2, 4, 5, 6};
        parentIdxs = new int[]{Node.IMPOSSIBLE_VALUE, 0, 0, 0, 1, 1};
        root = Node.constructTreeNode(values, parentIdxs);
        expect = new int[][]{{1}, {3, 2, 4}, {5, 6}};
        output=s.levelOrder(root);
        Util.verifyUnsort(expect,output,seq++);


    }



}
