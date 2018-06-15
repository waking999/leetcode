package leetcode.success.linkedlist;

import common.ListNode;
import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class IntersectionOfTwoLinkedListsTest {
    @Test
    public void test1() {
        IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();

        int[] aNums;
        int[] bNums;
        int[] expect;
        ListNode a;
        ListNode b;
        ListNode outputNode;
        List<Integer> output;
        int seq = 1;

        aNums = new int[]{1, 2, 3};
        bNums = new int[]{1, 2};
        expect = new int[]{4, 5, 6};

        a = ListNode.constructListNode(aNums);
        b = ListNode.constructListNode(bNums);
        outputNode = s.getIntersectionNode(a, b);
        output = ListNode.unConstructListNode(outputNode);
        verifyUnsort(expect, output, seq++);

//		ListNode a1=a;
//		while(a.next!=null){
//			a=a.next;
//		}
//		ListNode b1=b;
//		while(b.next!=null){
//			b=b.next;
//		}
//		a.next=c;
//		b.next=c;
//		outputNode=s.getIntersectionNode(a1, b1);
//		assert(outputNode==c):"2:wrong";


        a = null;
        b = null;
        outputNode = s.getIntersectionNode(a, b);
        assert (outputNode == null) : "3:wrong";


    }
}
