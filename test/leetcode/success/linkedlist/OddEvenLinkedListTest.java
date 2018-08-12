package leetcode.success.linkedlist;

import common.ListNode;
import common.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OddEvenLinkedListTest {
    @Test
    public void test1(){
        OddEvenLinkedList s=new OddEvenLinkedList();

        int[] nums;
        ListNode head;
        ListNode outputNode;
        List<Integer> output;
        int[] expect;
        int seq=1;

        head=null;
        outputNode=s.oddEvenList(head);
        Assertions.assertNull(outputNode);

        nums=new int[]{1,2,3,4,5};
        head=ListNode.constructListNode(nums);
        outputNode=s.oddEvenList(head);
        output=ListNode.unConstructListNode(outputNode);
        expect=new int[]{1,3,5,2,4};
        Util.verifyUnsort(expect,output,seq++);

        nums=new int[]{2,1,3,5,6,4,7};
        head=ListNode.constructListNode(nums);
        outputNode=s.oddEvenList(head);
        output=ListNode.unConstructListNode(outputNode);
        expect=new int[]{2,3,6,7,1,5,4};
        Util.verifyUnsort(expect,output,seq++);

        nums=new int[]{1,2,3,4,5,6};
        head=ListNode.constructListNode(nums);
        outputNode=s.oddEvenList(head);
        output=ListNode.unConstructListNode(outputNode);
        expect=new int[]{1,3,5,2,4,6};
        Util.verifyUnsort(expect,output,seq++);

        nums=new int[]{1,1};
        head=ListNode.constructListNode(nums);
        outputNode=s.oddEvenList(head);
        output=ListNode.unConstructListNode(outputNode);
        expect=new int[]{1,1};
        Util.verifyUnsort(expect,output,seq++);

    }
}
