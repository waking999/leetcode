package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class BinaryTreeLevelOrderTraversalTest {
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
        verifyUnsort(expect, output, seq++);

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
