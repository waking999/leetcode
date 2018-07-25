package leetcode.pending.dp;

import common.Util;
import org.junit.jupiter.api.Test;

public class MaximumLengthofRepeatedSubarrayTest {
    @Test
    public void test1() {
        MaximumLengthofRepeatedSubarray s = new MaximumLengthofRepeatedSubarray();
        int[] A;
        int[] B;
        int expect;
        int output;
        int seq = 1;

        A = new int[]{1, 2, 3, 2, 1};
        B = new int[]{3, 2, 1, 4, 7};
        expect = 3;
        output = s.findLength(A, B);
        Util.verify(expect, output, seq++);


        A = new int[]{1, 2, 3, 2, 1};
        B = new int[]{3, 2, 1, 4, 7, 3, 2};
        expect = 3;
        output = s.findLength(A, B);
        Util.verify(expect, output, seq++);


        A = new int[]{0,0,0,0,0,0,1,0,0,0};
        B = new int[]{0,0,0,0,0,0,0,1,0,0};
        expect = 9;
        output = s.findLength(A, B);
        Util.verify(expect, output, seq++);


    }
}
