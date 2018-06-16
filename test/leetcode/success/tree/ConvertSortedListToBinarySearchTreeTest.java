package leetcode.success.tree;

import common.ListNode;
import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class ConvertSortedListToBinarySearchTreeTest {
    @Test
    public void test1() {
        ConvertSortedListToBinarySearchTree s = new ConvertSortedListToBinarySearchTree();

        int[] nodes;
        ListNode head;
        int[] expect;

        TreeNode outputNode;
        int[] output;
        int seq = 1;


        nodes = new int[]{4, 5, 8, 11, 13, 17, 22, 23, 31, 58};

        head = ListNode.constructListNode(nodes);
        outputNode = s.sortedListToBST(head);
        output = NormalBinaryTreeNode.unconstructTreeNode(outputNode);

        expect = new int[]{17, 8, 31, 5, 13, 23, 58, 4, -1, 11, -1, 22, -1};
        verifyUnsort(expect, output, seq++);

    }

}
