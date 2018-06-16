package leetcode.success.string;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class CountandSayTest {
    @Test
    public void test1() {
        CountandSay s = new CountandSay();

        int n;
        String expect;
        String output;
        int seq = 0;

        n = 1;
        expect = "1";
        output = s.countAndSay(n);
        verify(expect, output, seq++);

        n = 2;
        expect = "11";
        output = s.countAndSay(n);
        verify(expect, output, seq++);

        n = 3;
        expect = "21";
        output = s.countAndSay(n);
        verify(expect, output, seq++);

        n = 4;
        expect = "1211";
        output = s.countAndSay(n);
        verify(expect, output, seq++);

        n = 5;
        expect = "111221";
        output = s.countAndSay(n);
        verify(expect, output, seq++);

    }
}
