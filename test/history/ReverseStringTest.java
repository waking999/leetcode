package history;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ReverseStringTest {
    @Test
    public void test1() {
        ReverseString a = new ReverseString();

        String s;
        String expect;
        String output;
        int seq = 1;

        s = "hello";
        expect = "olleh";
        output = a.reverseString(s);
        verify(expect, output, seq++);


        s = "helo";
        expect = "oleh";
        output = a.reverseString(s);
        verify(expect, output, seq++);
    }
}
