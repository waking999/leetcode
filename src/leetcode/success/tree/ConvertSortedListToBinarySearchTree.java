package leetcode.success.tree;

import common.ListNode;
import common.TreeNode;

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


}
