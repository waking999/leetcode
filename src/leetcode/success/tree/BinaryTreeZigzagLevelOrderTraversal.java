package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        int level = 0;
        dfs(root, level, ret);
        zigzag(ret);
        return ret;
    }

    private void zigzag(List<List<Integer>> list) {
        int listSize = list.size();
        for (int i = 1; i < listSize; i += 2) {
            List<Integer> tmpList = list.get(i);
            Collections.reverse(tmpList);
        }
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        int listSize = list.size();
        List<Integer> row;
        if (listSize <= level) {
            row = new ArrayList<>();
            list.add(row);
        } else {
            row = list.get(level);
        }

        row.add(node.val);
        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);

    }

    @Test
    public void test1() {
        BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int[][] expect;

        List<List<Integer>> output;
        int seq = 1;

        nodes = new int[]{3, 9, 20, 15, 7};
        parents = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2};
        children = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
        expect = new int[][]{{3}, {20, 9}, {15, 7}};

        output = s.zigzagLevelOrder(root);
        Util.verifyUnsort(expect, output, seq++);
    }

}
