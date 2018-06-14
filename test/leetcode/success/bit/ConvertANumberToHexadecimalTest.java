package leetcode.success.bit;

import common.Util;
import org.junit.Test;

public class ConvertANumberToHexadecimalTest {
    @Test
    public void test1() {
        ConvertANumberToHexadecimal s = new ConvertANumberToHexadecimal();

        int num;
        String expect;
        String output;

        num = 26;
        expect = "1a";
        output = s.toHex(num);
        Util.verify(expect, output, 1);

        num = -1;
        expect = "ffffffff";
        output = s.toHex(num);
        Util.verify(expect, output, 1);

        num = 0;
        expect = "0";
        output = s.toHex(num);
        Util.verify(expect, output, 1);



    }

}
