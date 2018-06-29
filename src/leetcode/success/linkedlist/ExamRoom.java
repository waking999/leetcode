package leetcode.success.linkedlist;


import common.ListNode;

/**
 * n an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 * <p>
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.
 * If there are multiple such seats, they sit in the seat with the lowest number.
 * (Also, if no one is in the room, then the student sits at seat number 0.)
 * <p>
 * Return a class ExamRoom(int N) that exposes two functions:
 * ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p)
 * representing that the student in seat number p now leaves the room.
 * It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * Output: [null,0,9,4,2,null,5]
 * Explanation:
 * ExamRoom(10) -> null
 * seat() -> 0, no one is in the room, then the student sits at seat number 0.
 * seat() -> 9, the student sits at the last seat number 9.
 * seat() -> 4, the student sits at the last seat number 4.
 * seat() -> 2, the student sits at the last seat number 2.
 * leave(4) -> null
 * seat() -> 5, the student​​​​​​​ sits at the last seat number 5.
 * ​​​​​​​
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 * ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
 * Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 * <p>
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
public class ExamRoom {

    int count;
    private int n;
    private ListNode head;

    public ExamRoom(int N) {
        n = N;
        head = new ListNode(-1);
        count = 0;
    }

    public int seat() {
        if (count == 0) {
            return insertNode(head, 0);
        } else if (count == 1) {
            ListNode pointer = head.next;
            if (pointer.val == 0) {
                return insertNode(pointer, n - 1);
            } else if (pointer.val == n - 1) {
                return insertNode(head, 0, pointer);
            } else {
                if (pointer.val > n - 1 - pointer.val) {
                    return insertNode(head, 0, pointer);
                } else {
                    return insertNode(pointer, n - 1);
                }
            }
        } else {
            ListNode pointer = head.next;
            if (pointer.val == 0) {
                ListNode startNode = pointer;
                ListNode endNode = pointer.next;
                int maxDistance = (endNode.val - startNode.val) / 2;

                return travel(pointer, startNode, endNode, maxDistance);
            } else {
                ListNode startNode = head;
                ListNode endNode = head.next;
                int maxDistance = endNode.val ;

                return travel(pointer, startNode, endNode, maxDistance);

            }
        }

    }

    private int travel(ListNode pointer, ListNode startNode, ListNode endNode, int maxDistance) {
        while (pointer.next != null) {
            if ((pointer.next.val - pointer.val) / 2 > maxDistance) {
                startNode = pointer;
                endNode = pointer.next;
                maxDistance = (endNode.val - startNode.val) / 2;
            }
            pointer = pointer.next;
        }

        if (pointer.val == n - 1) {
            return insertNode(startNode, endNode);
        } else {
            if (n - 1 - pointer.val > maxDistance) {
                return insertNode(pointer, n - 1);
            } else {
                return insertNode(startNode, endNode);
            }
        }
    }

    private int insertNode(ListNode startNode, ListNode endNode) {
        if (startNode == head) {
            return insertNode(startNode, 0,endNode);
        } else {
            int val = startNode.val + (endNode.val - startNode.val) / 2;
            return insertNode(startNode, val, endNode);
        }
    }

    private int insertNode(ListNode preNode, int val) {
        return insertNode(preNode, val, null);
    }

    private int insertNode(ListNode preNode, int val, ListNode suffNode) {
        ListNode node = new ListNode(val);
        preNode.next = node;
        node.next = suffNode;
        count++;
        return val;
    }

    public void leave(int p) {
        ListNode pointer = head;
        while (pointer.next.val != p) {
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        count--;
    }


}
