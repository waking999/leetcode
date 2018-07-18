package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class ToLowerCaseTest {
    @Test
    public void test1() {
        ToLowerCase s = new ToLowerCase();

        String str;
        String expect;
        String output;
        int seq = 1;

        str = "Hello";
        expect = "hello";
        output = s.toLowerCase(str);
        Util.verify(expect, output, seq++);

        str = "here";
        expect = "here";
        output = s.toLowerCase(str);
        Util.verify(expect, output, seq++);

        str = "LOVELY";
        expect = "lovely";
        output = s.toLowerCase(str);
        Util.verify(expect, output, seq++);

    }
}
