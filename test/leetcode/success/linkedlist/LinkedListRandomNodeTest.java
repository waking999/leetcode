package leetcode.success.linkedlist;

import common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListRandomNodeTest {
    @Test
    public void test1() {
        LinkedListRandomNode s;
        int output;
        int expect;
        int seq = 1;

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        s = new LinkedListRandomNode(head);


// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.


        output = s.getRandom();
        if (output == 1 || output == 2 || output == 3) {

        } else {
            Assertions.assertTrue(false, seq + " wrong.");
            seq++;
        }
    }
}
