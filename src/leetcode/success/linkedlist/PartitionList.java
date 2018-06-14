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

}
