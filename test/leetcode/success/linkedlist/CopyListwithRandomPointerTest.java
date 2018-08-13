package leetcode.success.linkedlist;

import common.Util;
import leetcode.success.linkedlist.CopyListwithRandomPointer;
import leetcode.success.linkedlist.RandomListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListwithRandomPointerTest {
    @Test
    public void test1() {
        CopyListwithRandomPointer s = new CopyListwithRandomPointer();

        int[] nums;
        int[][] random;
        RandomListNode head;
        RandomListNode outputNode;
        int seq = 1;


        nums = new int[]{1, 2, 3, 4};
        random = new int[][]{{1, 3}, {3, 2}, {4, 1}};
        head = construct(nums, random);
        outputNode = s.copyRandomList(head);
        RandomListNodeReturn rnr = unconstruct(outputNode);
        Util.verifyUnsort(nums, rnr.nodes, seq);
        Util.verifyUnsort(random, rnr.random, seq);
        seq++;

    }

    class RandomListNodeReturn {
        List<Integer> nodes;
        List<List<Integer>> random;

        RandomListNodeReturn(List<Integer> nodes, List<List<Integer>> random) {
            this.nodes = nodes;
            this.random = random;
        }
    }

    private RandomListNodeReturn unconstruct(RandomListNode head) {
        List<Integer> nodes = new ArrayList<>();
        List<List<Integer>> random = new ArrayList<>();

        RandomListNode p = head;
        while (p != null ) {
            nodes.add(p.label);
            if (p.random != null) {
                List<Integer> r = new ArrayList<>();
                r.add(p.label);
                r.add(p.random.label);
                random.add(r);
            }

            p = p.next;
        }


        return new RandomListNodeReturn(nodes, random);
    }

    private RandomListNode construct(int[] nums, int[][] random) {
        RandomListNode dump = new RandomListNode(-1);
        Map<Integer, RandomListNode> map = new HashMap<>();

        RandomListNode n = new RandomListNode(nums[0]);
        dump.next = n;
        map.put(nums[0], n);

        for (int i = 1; i < nums.length; i++) {
            RandomListNode tmpN = new RandomListNode(nums[i]);
            map.put(nums[i], tmpN);
            n.next = tmpN;
            n = tmpN;
        }

        for (int i = 0; i < random.length; i++) {
            RandomListNode s = map.get(random[i][0]);
            RandomListNode t = map.get(random[i][1]);
            s.random = t;

        }

        return dump.next;
    }
}
