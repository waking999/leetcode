package lintcode.google.level1;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ValidParenthesesTest {

    @Test
    public void test1() {
        ValidParentheses s = new ValidParentheses();

        String str;
        boolean expect;
        boolean output;
        int seq = 0;

        str = "()";
        expect = true;
        output = s.isValid(str);
        verify(expect, output, seq++);

        str = "()[]{}";
        expect = true;
        output = s.isValid(str);
        verify(expect, output, seq++);

        str = "(]";
        expect = false;
        output = s.isValid(str);
        verify(expect, output, seq++);

        str = "([)]";
        expect = false;
        output = s.isValid(str);
        verify(expect, output, seq++);

        str = "[])";
        expect = false;
        output = s.isValid(str);
        verify(expect, output, seq++);

        str = null;
        expect = true;
        output = s.isValid(str);
        verify(expect, output, seq++);

        str = "";
        expect = true;
        output = s.isValid(str);
        verify(expect, output, seq++);


    }
}
