package leetcode.success.string;

import common.Util;
import org.junit.jupiter.api.Test;

public class ShiftStringTest {
    @Test
    public void test1() {
        ShiftString s=new ShiftString();

        String str;
        int m;
        String expect;
        String output;

        str="abcdef";
        m=2;
        expect="cdefab";
        output=s.leftRotate(str, m);
        Util.verify(expect, output, 1);

        str="abcdef";
        m=2;
        expect="cdefab";
        output=s.leftRotate1(str, m);
        Util.verify(expect, output, 2);
    }
}
