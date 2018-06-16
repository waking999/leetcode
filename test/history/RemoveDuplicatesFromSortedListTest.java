package history;

import common.ListNode;
import common.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedListTest {

    @Test
    public void test1() {
        /*
         * Given 1->1->2, return 1->2.

         */
        RemoveDuplicatesFromSortedList x = new RemoveDuplicatesFromSortedList();


        ListNode n01 = new ListNode(1);
        ListNode n02 = new ListNode(1);
        ListNode n03 = new ListNode(2);

        n01.next = n02;
        n02.next = n03;

        n01 = x.deleteDuplicates(n01);
        Util.verify(n03.val, n01.next.val, 1);
        Assertions.assertEquals(n03.val, n01.next.val);

        /*
         * Given 1->1->2->3->3, return 1->2->3.
         */
        n01 = new ListNode(1);
        n02 = new ListNode(1);
        n03 = new ListNode(2);
        ListNode n04 = new ListNode(3);
        ListNode n05 = new ListNode(3);

        n01.next = n02;
        n02.next = n03;
        n03.next = n04;
        n04.next = n05;

        n01 = x.deleteDuplicates(n01);
        Assertions.assertEquals(n03.val, n01.next.val);
        Assertions.assertNull(n04.next);

        n01 = null;
        n01 = x.deleteDuplicates(n01);
        Assertions.assertNull(n01);

    }
}
