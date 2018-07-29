package leetcode.success.array;

import common.Util;

import leetcode.success.array.MyCircularQueue;
import org.junit.jupiter.api.Test;

public class MyCircularQueueTest {


    @Test
    public void test1() {
        String[] operations = new String[]{"MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"};
        int[][] params = new int[][]{{3},{1},{2},{3},{4},{},{},{},{4},{}};
        Object[] expects = new Object[]{null,true,true,true,false,3,true,true,true,4};
        runTest(operations, params, expects);
    }


    private void runTest(String[] operations, int[][] params, Object[] expects) {
        MyCircularQueue q = null;
        int seq = 1;

        int len = operations.length;
        for (int i = 0; i < len; i++) {
            String op = operations[i];
            int[] param = params[i];
            if ("MyCircularQueue".equals(op)) {
                q = new MyCircularQueue(param[i]);
            } else if ("enQueue".equals(op)) {
                assert q != null;
                boolean output = q.enQueue(param[0]);
                Util.verify((Boolean) (expects[i]), output, seq++);
            } else if ("deQueue".equals(op)) {
                assert q != null;
                boolean output = q.deQueue();
                Util.verify((Boolean) (expects[i]), output, seq++);
            } else if ("Front".equals(op)) {
                assert q != null;
                int output = q.Front();
                Util.verify((Integer) (expects[i]), output, seq++);
            } else if ("Rear".equals(op)) {
                assert q != null;
                int output = q.Rear();
                Util.verify((Integer) (expects[i]), output, seq++);
            } else if ("isEmpty".equals(op)) {
                assert q != null;
                boolean output = q.isEmpty();
                Util.verify((Boolean) (expects[i]), output, seq++);

            } else if ("isFull".equals(op)) {
                assert q != null;
                boolean output = q.isFull();
                Util.verify((Boolean) (expects[i]), output, seq++);

            }
        }
    }
}
