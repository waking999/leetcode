package leetcode.success.string;

import common.VerifyUtil;
import org.junit.Test;

public class BackspaceStringCompareTest {
    @Test
    public void test1() {
        BackspaceStringCompare s = new BackspaceStringCompare();
        String S;
        String T;
        boolean expect;
        boolean output;
        int seq = 0;

        S = "ab#c";
        T = "ad#c";
        expect = true;
        output = s.backspaceCompare(S, T);
        VerifyUtil.verify(expect, output, seq++);


        S = "ab##";
        T = "c#d#";
        expect = true;
        output = s.backspaceCompare(S, T);
        VerifyUtil.verify(expect, output, seq++);


        S = "a##c";
        T = "#a#c";
        expect = true;
        output = s.backspaceCompare(S, T);
        VerifyUtil.verify(expect, output, seq++);


        S = "a#c";
        T = "b";
        expect = false;
        output = s.backspaceCompare(S, T);
        VerifyUtil.verify(expect, output, seq++);


    }
}
