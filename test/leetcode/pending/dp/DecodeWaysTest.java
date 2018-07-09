package leetcode.pending.dp;

import common.Util;
import leetcode.pending.dp.DecodeWays;
import org.junit.jupiter.api.Test;

public class DecodeWaysTest {
    @Test
    public void test1() {
        DecodeWays s = new DecodeWays();

        String str;
        int expect;
        int output;
        int seq = 1;

        str = "12";
        expect = 2;
        output = s.numDecodings(str);
        Util.verify(expect, output, seq++);

        str = "226";
        expect = 3;
        output = s.numDecodings(str);
        Util.verify(expect, output, seq++);

        str = "0";
        expect = 0;
        output = s.numDecodings(str);
        Util.verify(expect, output, seq++);

        str = "00";
        expect = 0;
        output = s.numDecodings(str);
        Util.verify(expect, output, seq++);

        str = "01";
        expect = 0;
        output = s.numDecodings(str);
        Util.verify(expect, output, seq++);

        str = "101";
        expect = 1;
        output = s.numDecodings(str);
        Util.verify(expect, output, seq++);

    }
}
