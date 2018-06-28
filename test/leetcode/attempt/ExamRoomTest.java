package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

/**
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
 */

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
public class ExamRoomTest {
    @Test
    public void test1() {
        String[] action = new String[]{"ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"};
        Integer[] param = new Integer[]{10, null, null, null, null, 4, null};
        Integer[] expect = new Integer[]{null, 0, 9, 4, 2, null, 5};

        process(action, param, expect);
    }


    @Test
    public void test2() {
        String[] action = new String[]{"ExamRoom", "seat", "seat", "seat", "seat", "leave", "leave", "seat"};
        Integer[] param = new Integer[]{4, null, null, null, null, 1, 3, null};
        Integer[] expect = new Integer[]{null, 0, 3, 1, 2, null, null, 1};

        process(action, param, expect);
    }


    @Test
    public void test3() {

        String[] action = new String[]{"ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave"};
        Integer[] param = new Integer[]{10, null, null, null, 0,4,null, null, null,null, null, null,null, null, null,0};
        Integer[] expect = new Integer[]{null,0,9,4,null,null,0,4,2,6,1,3,5,7,8,null};

        process(action, param, expect);
    }





    private void process(String[] action, Integer[] param, Integer[] expect) {
        int inLen = action.length;

        ExamRoom e = null;
        for (int i = 0; i < inLen; i++) {
            if ("ExamRoom".equals(action[i])) {
                e = new ExamRoom(param[i].intValue());
            } else if ("seat".equals(action[i])) {
                int output = e.seat();
                Util.verify(expect[i], output, i);
            } else if ("leave".equals(action[i])) {
                e.leave(param[i].intValue());
            }
        }
    }
}
