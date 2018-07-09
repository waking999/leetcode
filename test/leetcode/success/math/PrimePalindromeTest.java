package leetcode.success.math;

import common.Util;
import leetcode.success.math.PrimePalindrome;
import org.junit.jupiter.api.Test;

public class PrimePalindromeTest {
    @Test
    public void test1(){
        PrimePalindrome s=new PrimePalindrome();

        int N;
        int expect;
        int output;
        int seq=1;

        N=6;
        expect=7;
        output=s.primePalindrome(N);
        Util.verify(expect,output,seq++);

        N=9;
        expect=11;
        output=s.primePalindrome(N);
        Util.verify(expect,output,seq++);

        N=13;
        expect=101;
        output=s.primePalindrome(N);
        Util.verify(expect,output,seq++);

        N=200;
        expect=313;
        output=s.primePalindrome(N);
        Util.verify(expect,output,seq++);

        N=798;
        expect=919;
        output=s.primePalindrome(N);
        Util.verify(expect,output,seq++);

        N=930;
        expect=10301;
        output=s.primePalindrome(N);
        Util.verify(expect,output,seq++);

        N=2000;
        expect=10301;
        output=s.primePalindrome(N);
        Util.verify(expect,output,seq++);

        N=20000;
        expect=30103;
        output=s.primePalindrome(N);
        Util.verify(expect,output,seq++);

        N=200000;
        expect=1003001;
        output=s.primePalindrome(N);
        Util.verify(expect,output,seq++);
    }
}
