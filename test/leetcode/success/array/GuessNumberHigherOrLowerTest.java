package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class GuessNumberHigherOrLowerTest {
    @Test
    public void test1() {
        GuessNumberHigherOrLower s = new GuessNumberHigherOrLower();

        int n;
        int expect;
        int output;
        int seq = 0;

        n = 10;
        s.real = 6;
        expect = 6;
        output = s.guessNumber(n);
        verify(expect, output, seq++);

        n = 10;
        s.real = 1;
        expect = 1;
        output = s.guessNumber(n);
        verify(expect, output, seq++);

        n = 10;
        s.real = 5;
        expect = 5;
        output = s.guessNumber(n);
        verify(expect, output, seq++);

    }
}
