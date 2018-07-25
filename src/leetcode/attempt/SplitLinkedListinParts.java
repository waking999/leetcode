package leetcode.attempt;

import common.ListNode;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 *
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 *
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 *
 * Return a List of ListNode's representing the linked list parts that are formed.
 *
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1:
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * Example 2:
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * Note:
 *
 * The length of root will be in the range [0, 1000].
 * Each value of a node in the input will be an integer in the range [0, 999].
 * k will be an integer in the range [1, 50].
 *
 */
public class SplitLinkedListinParts {
    private int countPerGroup(int totalCount, int desiredGroupCount){
        if(totalCount==0){
            return 0;
        }
        int countPerGroup=0;
        if(totalCount<=desiredGroupCount){
            countPerGroup=1;
        }else{
            if(totalCount%desiredGroupCount==0){
                countPerGroup=totalCount/desiredGroupCount;
            }else{
                countPerGroup=totalCount/desiredGroupCount+1;
            }
        }
        return countPerGroup;
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root==null){
            return null;
        }

        int count=1;
        ListNode p=root;
        while(p!=null&&p.next!=null){
            count++;
            p=p.next;
        }

        ListNode[] rtn=new ListNode[k];
        int countPerGroup=countPerGroup(count,k);
        int groupCount=0;
        rtn[0]=root;

        p=root;
        while(p!=null&&groupCount<k){
            int tmpCountPergroup=0;
            while(p!=null&&tmpCountPergroup<countPerGroup-1){
                p=p.next;
                tmpCountPergroup++;
            }
            if(p==null){
                break;
            }
            ListNode p1=p.next;
            p.next=null;
            groupCount++;
            if(groupCount>=k){
                break;
            }
            rtn[groupCount]=p1;
            p=p1;
            count=count-countPerGroup;
            countPerGroup=countPerGroup(count,k-groupCount);
        }


        return rtn;
    }
}
