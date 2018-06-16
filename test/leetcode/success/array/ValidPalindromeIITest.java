package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ValidPalindromeIITest {
    @Test
    public void test1() {
        ValidPalindromeII s = new ValidPalindromeII();

        String str;
        boolean expect;
        boolean output;

        str = "aba";
        expect = true;
        output = s.validPalindrome(str);
        verify(expect, output, 1);

        str = "abca";
        expect = true;
        output = s.validPalindrome(str);
        verify(expect, output, 2);

        str = "abc";
        expect = false;
        output = s.validPalindrome(str);
        verify(expect, output, 3);

        str = "tcaac";
        expect = true;
        output = s.validPalindrome(str);
        verify(expect, output, 4);

        str = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        expect = true;
        output = s.validPalindrome(str);
        verify(expect, output, 5);


    }
}
