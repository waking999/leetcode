package leetcode.success.array;

import common.Util;
import org.junit.Test;

public class AssignCookiesTest {
    @Test
    public void test1() {
        AssignCookies s = new AssignCookies();

        int[] k;
        int[] c;
        int expect;
        int output;
        int seq=1;

        k = new int[] { 1, 2, 3 };
        c = new int[] { 1, 1 };
        expect = 1;
        output = s.findContentChildren(k, c);
        Util.verify(expect, output, 1);

        k = new int[] { 1, 2 };
        c = new int[] { 1, 2, 3 };
        expect = 2;
        output = s.findContentChildren(k, c);
        Util.verify(expect, output, 2);


    }
}
