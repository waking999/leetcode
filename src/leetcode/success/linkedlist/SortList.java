package leetcode.success.linkedlist;

import common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-list/description/
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {
    public static List<Integer> unConstructListNode(ListNode node) {

        List<Integer> ret = new ArrayList<>();
        if (node == null) {
            return ret;
        }
        while (node != null) {
            ret.add(node.val);
            node = node.next;
        }
        return ret;

    }

    public ListNode sortList(ListNode head) {
        List<Integer> list=unConstructListNode(head);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        ListNode rtn=constructListNode(list);
        return rtn;
    }

    private ListNode constructListNode(List<Integer> list) {
        int n = list.size();
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return new ListNode(list.get(0));
        }

        ListNode start = new ListNode(list.get(0));
        ListNode tmp = new ListNode(list.get(1));
        start.next = tmp;
        ListNode current = tmp;
        for (int i = 2; i < n; i++) {
            tmp = new ListNode(list.get(i));
            current.next = tmp;
            current = tmp;

        }
        return start;
    }
}
