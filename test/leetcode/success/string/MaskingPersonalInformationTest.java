package leetcode.success.string;

import common.Util;
import org.junit.jupiter.api.Test;

public class MaskingPersonalInformationTest {
    @Test
    public void test1(){
        MaskingPersonalInformation s=new MaskingPersonalInformation();

        String S;
        String expect;
        String output;
        int seq=1;

        S="LeetCode@LeetCode.com";
        expect="l*****e@leetcode.com";
        output=s.maskPII(S);
        Util.verify(expect,output,seq++);


        S="AB@qq.com";
        expect="a*****b@qq.com";
        output=s.maskPII(S);
        Util.verify(expect,output,seq++);


        S="1(234)567-890";
        expect="***-***-7890";
        output=s.maskPII(S);
        Util.verify(expect,output,seq++);


        S="86-(10)12345678";
        expect="+**-***-***-5678";
        output=s.maskPII(S);
        Util.verify(expect,output,seq++);

        S="+(501321)-50-23431";
        expect="+***-***-***-3431";
        output=s.maskPII(S);
        Util.verify(expect,output,seq++);
    }
}
