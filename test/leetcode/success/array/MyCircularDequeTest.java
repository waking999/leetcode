package leetcode.success.array;

import common.Util;
import leetcode.success.array.MyCircularDeque;
import org.junit.jupiter.api.Test;

public class MyCircularDequeTest {

    //@Test
//    public void test1() {
//        String[] operations = new String[]{"MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"};
//        int[][] params = new int[][]{{3}, {1}, {2}, {3}, {4}, {}, {}, {}, {4}, {}};
//        boolean[] expects = null;
//
//
//        runTest(operations, params, expects);
//    }

    @Test
    public void test1() {
        String[] operations = new String[]{"MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"};
        int[][] params = new int[][]{{3}, {1}, {2}, {3}, {4}, {}, {}, {}, {4}, {}};
        Object[] expects = new Object[]{null, true, true, true, false, 2, true, true, true, 4};


        runTest(operations, params, expects);
    }

    private void runTest(String[] operations, int[][] params, Object[] expects) {
        MyCircularDeque q = null;
        int seq = 1;

        int len = operations.length;
        for (int i = 0; i < len; i++) {
            String op = operations[i];
            int[] param = params[i];
            if ("MyCircularDeque".equals(op)) {
                q = new MyCircularDeque(param[0]);
            } else if ("insertFront".equals(op)) {
                boolean output = q.insertFront(param[0]);
                Util.verify(((Boolean) (expects[i])).booleanValue(), output, seq++);
            } else if ("insertLast".equals(op)) {
                boolean output = q.insertLast(param[0]);
                Util.verify(((Boolean) (expects[i])).booleanValue(), output, seq++);
            } else if ("deleteFront".equals(op)) {
                boolean output = q.deleteFront();
                Util.verify(((Boolean) (expects[i])).booleanValue(), output, seq++);
            } else if ("deleteLast".equals(op)) {
                boolean output = q.deleteLast();
                Util.verify(((Boolean) (expects[i])).booleanValue(), output, seq++);
            } else if ("getFront".equals(op)) {
                int output = q.getFront();
                Util.verify(((Integer) (expects[i])).intValue(), output, seq++);
            } else if ("getRear".equals(op)) {
                int output = q.getRear();
                Util.verify(((Integer) (expects[i])).intValue(), output, seq++);
            } else if ("isEmpty".equals(op)) {
                boolean output = q.isEmpty();
                Util.verify(((Boolean) (expects[i])).booleanValue(), output, seq++);
            } else if ("isFull".equals(op)) {
                boolean output = q.isFull();
                Util.verify(((Boolean) (expects[i])).booleanValue(), output, seq++);
            }
        }

    }
}
