package history;

import common.Util;
import org.junit.Test;

import static common.Util.*;

public class HappyNumberTest {
    @Test
    public void test1() {
        HappyNumber s = new HappyNumber();

        int a;
        int seq = 1;
        int expect;
        int output;
        boolean expectBoolean;
        boolean outputBoolean;


        a = 19;
        expect = 82;
        output = s.digitPower(a);
        verify(expect, output, seq++);


        a = 19;
        expectBoolean = true;
        expectBoolean = s.isHappy(a);
        verify(expectBoolean, expectBoolean, seq++);


    }
}
