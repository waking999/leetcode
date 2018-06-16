package leetcode.success.string;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ReverseStringIITest {
    @Test
    public void test1() {
        ReverseStringII s = new ReverseStringII();

        String str;
        int k;
        String expect;
        String output;

        str = "abcdefg";
        k = 2;
        expect = "bacdfeg";
        output = s.reverseStr(str, k);
        verify(expect, output, 1);

    }
}
