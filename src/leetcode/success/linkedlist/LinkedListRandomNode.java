package leetcode.success.linkedlist;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/linked-list-random-node/description/
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *
 * Example:
 *
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 */
public class LinkedListRandomNode {


    private Random r;
    private List<Integer> nums;
    /**
     * @param head The linked list's head.
     * Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        nums=new ArrayList<>();
        while(head!=null){
            nums.add(head.val);
            head=head.next;
        }
        r = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int pos = r.nextInt(nums.size());
        return nums.get(pos);
    }
}
