package leetcode.success.array;

import common.Util;
import leetcode.success.array.NumArray;
import org.junit.jupiter.api.Test;

public class NumArrayTest {
    @Test
    public void test1(){

        String[] operations = new String[]{"NumArray", "sumRang", "update", "sumRange" };
        int[][] params = new int[][]{{1,3,5}, {0,2}, {1, 2}, {0,2}};
        Integer[] expects = new Integer[]{null, 9, null,8};
        runTest(operations, params, expects);
    }

    private void runTest(String[] operations, int[][] params, Integer[] expects) {
        NumArray s = null;
        int seq = 1;

        int len = operations.length;
        for (int i = 0; i < len; i++) {
            String op = operations[i];
            int[] param = params[i];
            if ("NumArray".equals(op)) {
                s = new NumArray(param);
            } else if ("update".equals(op)) {
                s.update(param[0],param[1]);
            } else if ("sumRange".equals(op)) {
               int output = s.sumRange(param[0],param[1]);
                int expect = expects[i];
                Util.verify(expect, output, seq++);
            }
        }

    }

}
