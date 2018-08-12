package leetcode.success.other;

import common.Util;
import leetcode.success.array.PeekingIterator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PeekingIteratorTest {
    @Test
    public void test1() {
        /*
         * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
         * <p>
         * Call next() gets you 1, the first element in the list.
         * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
         * You call next() the final time and it returns 3, the last element.
         * Calling hasNext() after that should return false.
         * Follow up: How would you extend your design to be generic an
         */
        String[] operations = new String[]{"PeekingIterator", "next", "peek", "next", "next", "hasNext"};
        Integer[][] params = new Integer[][]{{1, 2, 3}, null, null, null, null, null};
        Object[] expects = new Object[]{null, 1, 2, 2, 3, false};
        runTest(operations, params, expects);
    }

    private void runTest(String[] operations, Integer[][] params, Object[] expects) {
        PeekingIterator s = null;
        int seq = 1;

        int len = operations.length;
        for (int i = 0; i < len; i++) {
            String op = operations[i];
            Integer[] param = params[i];
            if ("PeekingIterator".equals(op)) {
                List<Integer> l = Arrays.asList(param);
                s = new PeekingIterator(l.iterator());
            } else if ("peek".equals(op)) {
                assert s != null;
                int output = s.peek();
                Integer expect = (Integer) expects[i];
                Util.verify(expect, output, seq++);
            } else if ("next".equals(op)) {
                assert s != null;
                int output = s.next();
                Integer expect = (Integer) expects[i];
                Util.verify(expect, output, seq++);
            } else if ("hasNext".equals(op)) {
                assert s != null;
                boolean output = s.hasNext();
                Boolean expect = (Boolean) expects[i];
                Util.verify(expect, output, seq++);
            }
        }

    }
}
