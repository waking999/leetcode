package common;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode constructListNode(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return new ListNode(nums[0]);
        }

        ListNode start = new ListNode(nums[0]);
        ListNode tmp = new ListNode(nums[1]);
        start.next = tmp;
        ListNode current = tmp;
        for (int i = 2; i < n; i++) {
            tmp = new ListNode(nums[i]);
            current.next = tmp;
            current = tmp;

        }
        return start;
    }

    public static ListNode constructListNode(int[] nums, int[] nextIdx) {
        int numsLen = nums.length;
        if (numsLen == 0) {
            return null;
        }
        if (numsLen == 1) {
            return new ListNode(nums[0]);
        }
        int nextIdxLen = nextIdx.length;
        if (nextIdxLen < numsLen) {
            return null;
        }

        ListNode start = new ListNode(nums[0]);
        ListNode pre = start;
        int childIdx = nextIdx[0];

        int count = 0;
        while (childIdx != TreeNode.IMPOSSIBLE_VALUE && count < numsLen) {
            ListNode node = contains(start, nums[childIdx]);
            if (node == null) {

                node = new ListNode(nums[childIdx]);
            }

            pre.next = node;
            pre = pre.next;
            childIdx = nextIdx[childIdx];
            count++;
        }

        return start;
    }

    public static List<Integer> unConstructListNode(ListNode node) {
        return unConstructListNode( node, false);
    }

    public static List<Integer> unConstructListNode(ListNode node, boolean hasCycle) {
        if (!hasCycle) {
            List<Integer> ret = new ArrayList<>();
            if (node == null) {
                return ret;
            }
            while (node != null) {
                ret.add(node.val);
                node = node.next;
            }
            return ret;
        }else{
            ListNode newNode =  breakCycle(node);
            return unConstructListNode( newNode, false);
        }
    }

    private static ListNode breakCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = slow;

        int count=0;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
            if (slow == fast) {
                break;
            }
        }

        ListNode p=slow;
        while(p.next!=slow){
            p=p.next;
        }
        p.next=null;
        return slow;
    }

    private static ListNode contains(ListNode start, int value) {
        if (start == null) {
            return null;
        }
        ListNode p = start;
        while (p != null && p.val != value) {
            p = p.next;
        }
        return p;
    }

    public String toString() {
        return Integer.toString(val);
    }
}
