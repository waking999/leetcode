package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

public class ReachaNumberTest {
    @Test
    public void test1(){
        ReachaNumber s=new ReachaNumber();

        int target;
        int expect;
        int output;
        int seq=1;

        target=3;
        expect=2;
        output=s.reachNumber(target);
        Util.verify(expect,output,seq++);

        target=2;
        expect=3;
        output=s.reachNumber(target);
        Util.verify(expect,output,seq);
    }
}
