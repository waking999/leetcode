package leetcode.success.linkedlist;

import common.ListNode;
import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycleTest {
    @Test
    public void test1() {
        LinkedListCycle x = new LinkedListCycle();

        ListNode n01;
        ListNode n02;
        ListNode n03;
        ListNode n04;

        n01 = new ListNode(1);
        n02 = new ListNode(2);
        n03 = new ListNode(3);
        n04 = new ListNode(4);

        n01.next = n02;
        n02.next = n03;
        n03.next = n04;

        Assert.assertTrue(!x.hasCycle(n01));

        n04.next = n02;

        Assert.assertTrue(x.hasCycle(n01));


    }

    @Test
    public void testhasCycle() {
        LinkedListCycle s=new LinkedListCycle();

        int[] nums;
        int[] childIdx;
        ListNode head;
        boolean expect;
        boolean output;

        //no cycle
        nums=new int[]{4,5,6,7};
        childIdx=new int[]{1,2,3,TreeNode.IMPOSSIBLE_VALUE};
        head=ListNode.constructListNode(nums,childIdx);
        expect=false;
        output=s.hasCycle(head);
        assert(output==expect):"1:wrong";


        //has cycle
        nums=new int[]{4,5,6,7};
        childIdx=new int[]{1,2,3,1};
        head=ListNode.constructListNode(nums,childIdx);
        expect=true;
        output=s.hasCycle(head);
        assert(output==expect):"2:wrong";

        System.out.println("Finish");

    }
}
