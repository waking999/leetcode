package leetcode.success.stack;


import common.Util;
import org.junit.jupiter.api.Test;

public class ScoreofParenthesesTest {
    @Test
    public void test1() {
        ScoreofParentheses s = new ScoreofParentheses();

        String str;
        int expect;
        int output;
        int seq = 1;

        str = "";
        expect = 0;
        output = s.scoreOfParentheses(str);
        Util.verify(expect, output, seq++);

        str = "()";
        expect = 1;
        output = s.scoreOfParentheses(str);
        Util.verify(expect, output, seq++);

        str = "(())";
        expect = 2;
        output = s.scoreOfParentheses(str);
        Util.verify(expect, output, seq++);

        str = "()()";
        expect = 2;
        output = s.scoreOfParentheses(str);
        Util.verify(expect, output, seq++);

        str = "(()(()))";
        expect = 6;
        output = s.scoreOfParentheses(str);
        Util.verify(expect, output, seq++);

        str = "(()((())))";
        expect = 10;
        output = s.scoreOfParentheses(str);
        Util.verify(expect, output, seq++);

        str = "((()(())))";
        expect = 12;
        output = s.scoreOfParentheses(str);
        Util.verify(expect, output, seq++);

        str = "(())()";
        expect = 3;
        output = s.scoreOfParentheses(str);
        Util.verify(expect, output, seq++);
    }
}
