package leetcode.success.linkedlist;

import common.ListNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.List;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }



        ListNode small=new ListNode(-1);
        ListNode smallP=small;
        ListNode big=new ListNode(-1);
        ListNode bigP=big;

        ListNode p=head;
        while(p!=null){
            if(p.val<x){
                smallP.next=new ListNode(p.val);
                smallP=smallP.next;
            }else{
                bigP.next=new ListNode(p.val);
                bigP=bigP.next;
            }
            p=p.next;
        }

        smallP.next=big.next;
        return small.next;


    }

    @Test
    public void testpartition(){
        PartitionList s=new PartitionList();

        int[] nums;
        ListNode head;
        int x;
        int[] expect;
        ListNode outputNode;
        List<Integer> output;
        int seq=1;

        nums=new int[]{1,4,3,2,5,2};
        head=ListNode.constructListNode(nums);
        x = 3;
        expect=new int[]{1,2,2,4,3,5};
        outputNode=s.partition(head,x);
        output=ListNode.unConstructListNode(outputNode);
        Util.verifyUnsort(expect,output,seq++);
    }
}
