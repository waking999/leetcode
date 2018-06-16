package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class StringCompressionTest {
    @Test
    public void test1() {
        StringCompression s = new StringCompression();

        char[] chars;
        int expect;
        int output;
        int seq = 0;

        chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        expect = 6;
        output = s.compress(chars);
        verify(expect, output, seq++);

        chars = new char[]{'a'};
        expect = 1;
        output = s.compress(chars);
        verify(expect, output, seq++);

        chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        expect = 4;
        output = s.compress(chars);
        verify(expect, output, seq++);

        chars = new char[]{'a', 'b', 'c'};
        expect = 3;
        output = s.compress(chars);
        verify(expect, output, seq++);

        chars = new char[]{'a', 'b', 'c'};
        expect = 3;
        output = s.compress(chars);
        verify(expect, output, seq++);

        chars = new char[]{'a', 'a'};
        expect = 2;
        output = s.compress(chars);
        verify(expect, output, seq++);

    }
}
