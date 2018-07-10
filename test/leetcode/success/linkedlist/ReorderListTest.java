package leetcode.success.linkedlist;

import common.ListNode;
import common.Util;
import leetcode.success.linkedlist.ReorderList;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReorderListTest {
    @Test
    public void test1(){
        ReorderList s=new ReorderList();

        int[] nums;
        ListNode head;
        int[] expect;
        List<Integer> output;
        int seq=1;


        nums=new int[]{1,2,3,4,5};
        head=ListNode.constructListNode(nums);
        s.reorderList(head);
        expect=new int[]{1,5,2,4,3};
        output=ListNode.unConstructListNode(head);
        Util.verifyUnsort(expect,output,seq++);


        nums=new int[]{1,2,3,4};
        head=ListNode.constructListNode(nums);
        s.reorderList(head);
        expect=new int[]{1,4,2,3};
        output=ListNode.unConstructListNode(head);
        Util.verifyUnsort(expect,output,seq++);

    }
}
