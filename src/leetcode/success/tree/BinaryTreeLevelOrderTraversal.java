package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        int level = 0;
        dfs(root, level, ret);

        return ret;
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
        BinaryTreeLevelOrderTraversal s = new BinaryTreeLevelOrderTraversal();

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
        expect = new int[][]{{3}, {9, 20}, {15, 7}};
        output = s.levelOrder(root);
        Util.verifyUnsort(expect, output, seq++);

//		outputSize = output.size();
//		assert (outputSize == expectLen) : "1:wrong";
//		for (int i = 0; i < expectLen; i++) {
//
//			String s1 = IntStream.of(expect[i]).boxed().collect(Collectors.toList()).stream()
//					.map(num -> Integer.toString(num)).collect(Collectors.joining(","));
//
//			String s2 = output.get(i).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
//			assert (s1.equals(s2)) : "1:wrong";
//		}
//
//		System.out.println("Finish");
    }
}
