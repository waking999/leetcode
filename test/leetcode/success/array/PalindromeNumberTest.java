package leetcode.success.array;

import org.junit.Test;

import static common.Util.verify;

public class PalindromeNumberTest {
    @Test
    public void test1() {
        PalindromeNumber s = new PalindromeNumber();

        int x;
        boolean expect;
        boolean output;
        int seq = 0;

        x = 0;
        expect = true;
        output = s.isPalindrome(x);
        verify(expect, output, seq++);

        x = -1;
        expect = false;
        output = s.isPalindrome(x);
        verify(expect, output, seq++);

        x = 121;
        expect = true;
        output = s.isPalindrome(x);
        verify(expect, output, seq++);

        x = 122;
        expect = false;
        output = s.isPalindrome(x);
        verify(expect, output, seq++);


    }
}
