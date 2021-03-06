package lintcode.google.level2.required;

import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenerateParenthesesTest {
    @Test
    public void testgenerateParenthesis() {
        GenerateParentheses s = new GenerateParentheses();

        int n;
        List<String> output;
        String[] expect;
        int seq = 1;

        n = 3;
        expect = new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"};
        output = s.generateParenthesis(n);
        Util.verifyUnsort(expect, output, seq++);

    }
}
