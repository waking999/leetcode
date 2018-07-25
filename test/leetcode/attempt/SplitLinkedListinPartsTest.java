package leetcode.attempt;

import common.ListNode;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SplitLinkedListinPartsTest {
    @Test
    public void test1() {
        SplitLinkedListinParts s = new SplitLinkedListinParts();

        int[] nums;
        ListNode head;
        int k;
        int[][] expect;
        ListNode[] outputNodeList;
        int seq = 1;



        nums = new int[]{1, 2, 3};
        head = ListNode.constructListNode(nums);
        k = 5;
        expect = new int[][]{{1}, {2}, {3}, {}, {}};
        outputNodeList = s.splitListToParts(head, k);
        verify(expect, outputNodeList, seq);
        seq++;


        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        head = ListNode.constructListNode(nums);
        k = 3;
        expect = new int[][]{{1, 2, 3, 4}, {5, 6, 7}, {8, 9, 10}};
        outputNodeList = s.splitListToParts(head, k);
        verify(expect, outputNodeList, seq);
        seq++;

        nums = new int[]{};
        head = ListNode.constructListNode(nums);
        k = 3;
        expect = null;
        outputNodeList = s.splitListToParts(head, k);
        verify(expect, outputNodeList, seq);
        seq++;


    }

    private void verify(int[][] expect, ListNode[] outputNodeList, int seq) {
        if(expect==null&&outputNodeList==null){
            return;
        }
        int expectLen;
        int outputNodeListLen;
        expectLen = expect.length;
        outputNodeListLen = outputNodeList.length;
        Util.verify(expectLen, outputNodeListLen, seq);
        for (int i = 0; i < expectLen; i++) {
            int[] expectSub = expect[i];
            ListNode ouputNode = outputNodeList[i];
            List<Integer> ouputList = ListNode.unConstructListNode(ouputNode);
            Util.verifyUnsort(expectSub, ouputList, seq);
        }
    }
}
