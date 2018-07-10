package leetcode.success.stack;

import common.Util;
import org.junit.jupiter.api.Test;

public class EvaluateReversePolishNotationTest {
    @Test
    public void test1() {
        EvaluateReversePolishNotation s = new EvaluateReversePolishNotation();

        String[] tokens;
        int expect;
        int output;
        int seq = 1;

        tokens = new String[]{"2", "1", "+", "3", "*"};
        expect = 9;
        output = s.evalRPN(tokens);
        Util.verify(expect, output, seq++);

        tokens = new String[]{"4", "13", "5", "/", "+"};
        expect = 6;
        output = s.evalRPN(tokens);
        Util.verify(expect, output, seq++);

        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        expect = 22;
        output = s.evalRPN(tokens);
        Util.verify(expect, output, seq++);


    }
}
