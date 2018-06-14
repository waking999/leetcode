package history;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedListsTest {
    @Test
    public void test1() {
        MergeTwoSortedLists x = new MergeTwoSortedLists();

        ListNode h;
        ListNode n01;
        ListNode n02;
        ListNode n03;

        ListNode n11;
        ListNode n12;

        /*
         * l1: null l2: null h:null
         */

        n01 = null;
        n02 = null;
        h = x.mergeTwoLists(n01, n02);
        Assert.assertNull(h);

        /*
         * l1: 1->2->5 l2: 3->4 h: 1->2->3->4->5
         */
        n01=new ListNode(1);
        n02=new ListNode(2);
        n03=new ListNode(5);

        n01.next=n02;
        n02.next=n03;

        n11=new ListNode(3);
        n12=new ListNode(4);
        n11.next=n12;

        h = x.mergeTwoLists(n01, n11);
        Assert.assertEquals(n02.val, n01.next.val);
        Assert.assertEquals(n11.val, n02.next.val);
        Assert.assertEquals(n12.val, n11.next.val);
        Assert.assertEquals(n03.val, n12.next.val);
        System.out.println("done");

    }
}
