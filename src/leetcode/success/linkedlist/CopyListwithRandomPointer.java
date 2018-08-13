package leetcode.success.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode dump = new RandomListNode(-1);
        Map<Integer, RandomListNode> map = new HashMap<>();

        RandomListNode n = new RandomListNode(head.label);
        dump.next = n;
        map.put(n.label, n);


        RandomListNode p = head.next;
        while (p != null) {
            RandomListNode tmpN = new RandomListNode(p.label);
            map.put(tmpN.label, tmpN);
            n.next = tmpN;
            n = tmpN;
            p=p.next;
        }

        p = head;
        while(p!=null){

            if(p.random!=null) {
                RandomListNode s=map.get(p.label);
                RandomListNode t = map.get(p.random.label);
                s.random = t;
            }
            p=p.next;
        }

        return dump.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};
