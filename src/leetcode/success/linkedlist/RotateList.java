package leetcode.success.linkedlist;

import common.ListNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.List;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }


        if (head == null) {
            return null;
        }

        int count = 1;
        ListNode pointer = head;
        while (pointer.next != null) {
            count++;
            pointer = pointer.next;
        }

        if (count == 1) {
            return head;
        }

        k = k % count;

        if (k == 0) {
            return head;
        }

        if(count==2&&k==1){
            ListNode newStart=head.next;
            newStart.next=head;
            head.next=null;
            return newStart;
        }

        ListNode end=pointer;
        end.next=head;

        pointer=end;
        int pos=0;

        while (pos < count-k) {
            pos++;
            pointer = pointer.next;
        }

        ListNode newStart=pointer.next;
        pointer.next=null;
        return newStart;

    }


}
