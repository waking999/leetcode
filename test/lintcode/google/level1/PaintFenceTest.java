package lintcode.google.level1;

import org.junit.Test;

import static common.Util.*;

public class PaintFenceTest {
    @Test
    public void testnumWays() {
        PaintFence s = new PaintFence();

        int n;
        int k;
        int expect;
        int output;
        int seq = 1;

        n = 3;
        k = 2;
        expect = 6;
        output = s.numWays(n, k);
        verify(expect, output, seq++);

    }
}
