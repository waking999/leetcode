package leetcode.success.linkedlist;

import common.ListNode;

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
            p.next = new ListNode(s.pop());
            p = p.next;
        }

        return ret;

    }


}
