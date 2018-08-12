package leetcode.success.linkedlist;

import common.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/description/
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }

        int count=1;
        ListNode p=head;
        while(p.next!=null){
            p=p.next;
            count++;
        }
        if(count<=2){
            return head;
        }
        ListNode last=p;
        ListNode orginalLast=p;
        if(count%2!=0){
            ListNode f=head;
            ListNode s=head;
            while(f!=orginalLast){
                f=f.next.next;
                last.next=s.next;
                last=last.next;
                s.next=f;
                s=f;
            }
            last.next=null;
        }else{
            ListNode f=head;
            ListNode s=head;
            while(f.next!=orginalLast){
                f=f.next.next;
                last.next=s.next;
                last=last.next;
                s.next=f;
                s=f;
            }
            f.next=orginalLast.next;
            last.next=orginalLast;
            orginalLast.next=null;

        }
        return head;
    }
}
