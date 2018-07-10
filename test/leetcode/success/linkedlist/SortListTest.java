package leetcode.success.linkedlist;

import common.ListNode;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SortListTest {
    @Test
    public void test1(){
        SortList s=new SortList();

        int[] nums;
        ListNode head;
        ListNode outputNode;
        List<Integer> output;
        int[] expect;
        int seq=1;

        nums=new int[]{4,2,1,3};
        head=ListNode.constructListNode(nums);
        outputNode=s.sortList(head);
        output=ListNode.unConstructListNode(outputNode);
        expect=new int[]{1,2,3,4};
        Util.verifyUnsort(expect,output,seq++);


        nums=new int[]{-1,5,3,4,0};
        head=ListNode.constructListNode(nums);
        outputNode=s.sortList(head);
        output=ListNode.unConstructListNode(outputNode);
        expect=new int[]{-1,0,3,4,5};
        Util.verifyUnsort(expect,output,seq++);

    }
}
