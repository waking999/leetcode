package leetcode.success.linkedlist;

import common.ListNode;
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

}
