package leetcode.success.linkedlist;

import common.ListNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.List;

public class RotateListTest {

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
