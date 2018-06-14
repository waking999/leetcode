package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else {
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }


    @Test
    public void test1() {
        SameTree s = new SameTree();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        boolean expect;
        boolean output;
        int seq = 1;

        nodes = new int[]{1, 2, 2, 3, 3, 3, 3};
        parents = new int[]{-1, 0, 0, 1, 1, 2, 2};
        children = new int[]{-1, 0, 1, 0, 1, 0, 1};
        expect = true;
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        output = s.isSameTree(root.left, root.right);
        Util.verify(expect, output, seq++);

        nodes = new int[]{1, 2, 2, -1, 3, -1, 3};
        parents = new int[]{-1, 0, 0, 1, 1, 2, 2};
        children = new int[]{-1, 0, 1, 0, 1, 0, 1};
        expect = true;
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        output = s.isSameTree(root.left, root.right);
        Util.verify(expect, output, seq++);

        nodes = new int[]{1, 2, 3};
        parents = new int[]{-1, 0, 0};
        children = new int[]{-1, 0, 1};
        expect = false;
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        output = s.isSameTree(root.left, root.right);
        Util.verify(expect, output, seq++);

    }

}
