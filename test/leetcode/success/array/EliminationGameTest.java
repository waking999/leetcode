package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class EliminationGameTest {
    @Test
    public void test1() {
        EliminationGame s = new EliminationGame();
        int n;
        int expect;
        int output;
        int seq = 1;

        n = 9;
        expect = 6;
        output = s.lastRemaining(n);
        Util.verify(expect, output, seq++);

        n = 22;
        expect = 8;
        output = s.lastRemaining(n);
        Util.verify(expect, output, seq++);

        n = 1;
        expect = 1;
        output = s.lastRemaining(n);
        Util.verify(expect, output, seq++);


        n = 2;
        expect = 2;
        output = s.lastRemaining(n);
        Util.verify(expect, output, seq++);

        n = 20;
        expect = 6;
        output = s.lastRemaining(n);
        Util.verify(expect, output, seq++);
    }
}
