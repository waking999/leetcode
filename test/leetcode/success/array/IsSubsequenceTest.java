package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class IsSubsequenceTest {
    @Test
    public void test1(){
        IsSubsequence s=new IsSubsequence();

        String s1;
        String t;
        boolean expect;
        boolean output;
        int seq=1;

        s1="abc";
        t = "ahbgdc";
        expect=true;
        output=s.isSubsequence(s1,t);
        Util.verify(expect,output,seq++);

        s1="axc";
        t = "ahbgdc";
        expect=false;
        output=s.isSubsequence(s1,t);
        Util.verify(expect,output,seq++);


        s1="ace";
        t = "abcde";
        expect=true;
        output=s.isSubsequence(s1,t);
        Util.verify(expect,output,seq++);


        s1="aec";
        t = "abcde";
        expect=false;
        output=s.isSubsequence(s1,t);
        Util.verify(expect,output,seq++);


    }
}
