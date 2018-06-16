package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class BSTIteratorTest {
    @Test
    public void testhasnext() {
        int[] nodes;
        TreeNode root;
        boolean expect;
        boolean output;
        BSTIterator it;
        int seq = 1;

        nodes = new int[]{3, 5, 7, 2, 6, 9};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        it = new BSTIterator(root);
        expect = true;
        output = it.hasNext();
        verify(expect, output, seq++);

        nodes = new int[]{};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        it = new BSTIterator(root);
        expect = false;
        output = it.hasNext();
        verify(expect, output, seq++);

    }

    @Test
    public void testnext() {
        int[] nodes;
        TreeNode root;
        int expect;
        int output;
        BSTIterator it;
        int seq = 1;

        nodes = new int[]{3, 5, 7, 2, 6, 9};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        it = new BSTIterator(root);
        expect = 2;
        output = it.next();
        verify(expect, output, seq++);

        expect = 3;
        output = it.next();
        verify(expect, output, seq++);

        expect = 5;
        output = it.next();
        verify(expect, output, seq++);


    }
}
