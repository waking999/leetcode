package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.List;

public class LexicographicalNumbersTest {
    @Test
    public void test1() {
        LexicographicalNumbers s = new LexicographicalNumbers();

        int n;
        int[] expect;
        List<Integer> output;
        int seq = 1;

        n = 13;
        expect = new int[] { 1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9 };
        output = s.lexicalOrder(n);
        Util.verifyUnsort(expect, output, seq++);

    }
}
