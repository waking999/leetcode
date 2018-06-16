package leetcode.success.math;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class SmallestnumberksuchthattheproductofdigitsofkisequaltonTest {
    @Test
    public void test1() {
        Smallestnumberksuchthattheproductofdigitsofkisequalton s = new Smallestnumberksuchthattheproductofdigitsofkisequalton();

        int n;
        int expect;
        int output;

        n = 100;
        expect = 455;
        output = s.productk(n);
        verify(expect, output, 1);

        n = 26;
        expect = -1;
        output = s.productk(n);
        verify(expect, output, 2);
    }
}
