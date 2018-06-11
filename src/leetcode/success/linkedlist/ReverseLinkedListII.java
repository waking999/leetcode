package leetcode.success.linkedlist;

import leetcode.success.comm.ListNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) {
            return head;
        }

        ListNode leftNode = head;
        ListNode mNode = null;
        int left = 1;
        if (m == 1) {
            leftNode = null;
            mNode = head;
            left = 0;
        } else {
            while (left < m - 1) {
                leftNode = leftNode.next;
                left++;
            }
            mNode = leftNode.next;
        }


        ListNode nNode = mNode;
        int pos = left;
        while (pos < n - 1) {
            pos++;
            nNode = nNode.next;
        }

        ListNode nRightNode = nNode.next;

        ListNode pointer = nNode;
        while (pointer.next != null) {
            pointer = pointer.next;
        }


        nNode.next = null;
        ListNode res = reserve(mNode);

        if(leftNode!=null) {
            leftNode.next = res;
        }else{
            head=res;
        }

        if(nRightNode!=null) {
            pointer = res;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = nRightNode;
        }

        return head;
    }

    private ListNode reserve(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode p = head;
        while (p != null) {
            s.push(p.val);
            p = p.next;
        }

        ListNode ret = null;
        if (!s.isEmpty()) {
            ret = new ListNode(s.pop());
        }

        p = ret;
        while (!s.isEmpty()) {
            ListNode t = new ListNode(s.pop());
            p.next = t;
            p = p.next;
        }

        return ret;

    }

    @Test
    public void testreverseBetween() {
        ReverseLinkedListII s = new ReverseLinkedListII();

        int[] nums;
        ListNode head;
        int m;
        int n;
        int[] expect;
        List<Integer> output;
        ListNode outputNode;
        int seq = 0;


        nums = new int[]{1, 2, 3, 4, 5};
        m = 2;
        n = 4;
        expect = new int[]{1, 4, 3, 2, 5};
        head = ListNode.constructListNode(nums);
        outputNode = s.reverseBetween(head, m, n);
        output = ListNode.unConstructListNode(outputNode);
        Util.verifyUnsort(expect, output, seq++);


        nums = new int[]{3, 5};
        m = 1;
        n = 2;
        expect = new int[]{5, 3};
        head = ListNode.constructListNode(nums);
        outputNode = s.reverseBetween(head, m, n);
        output = ListNode.unConstructListNode(outputNode);
        Util.verifyUnsort(expect, output, seq++);


    }
}
