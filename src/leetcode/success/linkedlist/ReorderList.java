package leetcode.success.linkedlist;

import common.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/description/
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        int count=this.getListLen(head);
        int i=0;
        int j=count-2;
        while(i<j){
            ListNode pi=getANode(head,i);
            ListNode pj=getANode(head,j);
            pj.next.next=pi.next;
            pi.next=pj.next;
            pj.next=null;
            i+=2;
        }

    }

    private ListNode getANode(ListNode head, int pos){
        int idx=0;
        ListNode p=head;
        while(idx<pos){
            p=p.next;
            idx++;
        }
        return p;
    }

    private int getListLen(ListNode head){
        int count=0;
        ListNode p=head;
        while(p!=null){
            count++;
            p=p.next;
        }
        return count;
    }
}
