package leetcode.success.string;

import org.junit.Test;

import static common.Util.verify;

public class ReverseWordsInAStringIIITest {
    @Test
    public void test1() {
        ReverseWordsInAStringIII s = new ReverseWordsInAStringIII();

        String str;
        String expect;
        String output;

        str = "Let's take LeetCode contest";
        expect = "s'teL ekat edoCteeL tsetnoc";
        output = s.reverseWords(str);
        verify(expect, output, 1);
    }
}
