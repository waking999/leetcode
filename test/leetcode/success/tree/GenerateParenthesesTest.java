package leetcode.success.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class GenerateParenthesesTest {
    @Test
    public void test1() {
        GenerateParentheses s = new GenerateParentheses();

        int n;
        String[] expect;
        List<String> output;

        n = 3;
        expect = new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"};
        output = s.generateParenthesis(n);
        verifyUnsort(expect, output, 1);

        n = 8;
        // expect = new String[] { "((()))", "(()())", "(())()", "()(())", "()()()" };
        output = s.generateParenthesis(n);
        //Util.verify(expect, output, 2);
    }
}
