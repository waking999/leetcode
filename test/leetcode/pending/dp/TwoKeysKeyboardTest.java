package leetcode.pending.dp;

import common.Util;
import leetcode.pending.dp.TwoKeysKeyboard;
import org.junit.jupiter.api.Test;

public class TwoKeysKeyboardTest {
    @Test
    public void test1(){
        TwoKeysKeyboard s=new TwoKeysKeyboard();

        int n;
        int output;
        int expect;
        int seq=1;

        n=3;
        expect=3;
        output=s.minSteps(n);
        Util.verify(expect,output,seq++);

        n=5;
        expect=5;
        output=s.minSteps(n);
        Util.verify(expect,output,seq++);


        n=6;
        expect=5;
        output=s.minSteps(n);
        Util.verify(expect,output,seq++);

        n=8;
        expect=6;
        output=s.minSteps(n);
        Util.verify(expect,output,seq++);


        n=27;
        expect=9;
        output=s.minSteps(n);
        Util.verify(expect,output,seq++);


        n=24;
        expect=9;
        output=s.minSteps(n);
        Util.verify(expect,output,seq++);
    }
}
