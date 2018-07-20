package leetcode.success.tree;

import common.NaryTree.Node;
import common.Util;
import org.junit.jupiter.api.Test;

public class MaximumDepthofNaryTreeTest {
    @Test
    public void test1(){
        MaximumDepthofNaryTree s=new MaximumDepthofNaryTree();
        int[] values;
        int[] parentIdxs;
        Node root;
        int expect;
        int output;
        int seq = 1;

        values = new int[]{1, 3, 2, 4, 5, 6};
        parentIdxs = new int[]{Node.IMPOSSIBLE_VALUE, 0, 0, 0, 1, 1};
        root = Node.constructTreeNode(values, parentIdxs);
        expect = 2;
        output=s.maxDepth(root);
        Util.verify(expect,output,seq++);
    }

}
