package leetcode.success.linkedlist;

import common.ListNode;
import common.Util;
import org.junit.jupiter.api.Test;

public class MiddleoftheLinkedListTest {
    @Test
    public void test1(){
        MiddleoftheLinkedList s=new MiddleoftheLinkedList();
        /*
        nput: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (
         */

        int[] nums;
        ListNode head;
        ListNode outputNode;
        int expect;
        int output;
        int seq=1;

        nums=new int[]{1,2,3,4,5};
        head=ListNode.constructListNode(nums);
        outputNode=s.middleNode(head);
        expect=3;
        output=outputNode.val;
        Util.verify(expect,output,seq++);

        nums=new int[]{1,2,3,4,5,6};
        head=ListNode.constructListNode(nums);
        outputNode=s.middleNode(head);
        expect=4;
        output=outputNode.val;
        Util.verify(expect,output,seq++);

        nums=new int[]{1,2};
        head=ListNode.constructListNode(nums);
        outputNode=s.middleNode(head);
        expect=2;
        output=outputNode.val;
        Util.verify(expect,output,seq++);

        nums=new int[]{1};
        head=ListNode.constructListNode(nums);
        outputNode=s.middleNode(head);
        expect=1;
        output=outputNode.val;
        Util.verify(expect,output,seq++);

        nums=new int[]{1,2,3};
        head=ListNode.constructListNode(nums);
        outputNode=s.middleNode(head);
        expect=2;
        output=outputNode.val;
        Util.verify(expect,output,seq++);


        head=null;
        outputNode=s.middleNode(head);
        assert (null == outputNode) : seq++ + ":wrong";
    }
}
