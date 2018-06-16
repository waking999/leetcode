package leetcode.success.math;

import org.junit.Test;

import static common.Util.verify;

public class LargestPalindromeProductTest {
    @Test
    public void test1() {
        LargestPalindromeProduct s = new LargestPalindromeProduct();

        int n;
        int expect;
        int output;

        n = 2;
        expect = 987;
        output = s.largestPalindrome(n);
        verify(expect, output, 1);


        n = 1;
        expect = 9;
        output = s.largestPalindrome(n);
        verify(expect, output, 2);

        n = 5;
        expect = 677;
        output = s.largestPalindrome(n);
        verify(expect, output, 1);

    }

}
