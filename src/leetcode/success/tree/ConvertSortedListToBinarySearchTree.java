package leetcode.success.tree;

import common.ListNode;
import common.NormalBinaryTreeNode;
import common.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return build(head, null);
    }

    private TreeNode build(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = build(start, slow);
        node.right = build(slow.next, end);
        return node;
    }

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
        Util.verifyUnsort(expect, output, seq++);

    }

}
