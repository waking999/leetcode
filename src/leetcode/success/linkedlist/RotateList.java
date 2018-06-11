package leetcode.success.linkedlist;

import leetcode.success.comm.ListNode;
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

    @Test
    public void testrotateRight() {
        RotateList s = new RotateList();


        int[] nums;
        ListNode head;
        int[] expect;
        ListNode outputList;
        List<Integer> output;
        int k;
        int seq = 0;


        nums = new int[]{1, 2, 3, 4, 5};
        head = ListNode.constructListNode(nums);
        expect = new int[]{4, 5, 1, 2, 3};
        k = 2;
        outputList = s.rotateRight(head, k);
        output = ListNode.unConstructListNode(outputList);
        Util.verifyUnsort(expect, output, seq++);


        nums = new int[]{0, 1, 2};
        head = ListNode.constructListNode(nums);
        expect = new int[]{2, 0, 1};
        k = 4;
        outputList = s.rotateRight(head, k);
        output = ListNode.unConstructListNode(outputList);
        Util.verifyUnsort(expect, output, seq++);


        nums = new int[]{1};
        head = ListNode.constructListNode(nums);
        expect = new int[]{1};
        k = 0;
        outputList = s.rotateRight(head, k);
        output = ListNode.unConstructListNode(outputList);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 2};
        head = ListNode.constructListNode(nums);
        expect = new int[]{2, 1};
        k = 1;
        outputList = s.rotateRight(head, k);
        output = ListNode.unConstructListNode(outputList);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 2};
        head = ListNode.constructListNode(nums);
        expect = new int[]{1, 2};
        k = 2;
        outputList = s.rotateRight(head, k);
        output = ListNode.unConstructListNode(outputList);
        Util.verifyUnsort(expect, output, seq++);


        nums = new int[]{1, 2, 3};
        head = ListNode.constructListNode(nums);
        expect = new int[]{2, 3, 1};
        k = 2000000000;
        outputList = s.rotateRight(head, k);
        output = ListNode.unConstructListNode(outputList);
        Util.verifyUnsort(expect, output, seq++);


        nums = new int[]{1,2,3,4,5};
        head = ListNode.constructListNode(nums);
        expect = new int[]{5,1,2,3,4};
        k = 1;
        outputList = s.rotateRight(head, k);
        output = ListNode.unConstructListNode(outputList);
        Util.verifyUnsort(expect, output, seq++);
    }
}
