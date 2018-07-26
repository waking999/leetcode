package leetcode.success.array;

import common.Util;
import leetcode.success.array.PalindromicSubstrings;
import org.junit.jupiter.api.Test;

public class PalindromicSubstringsTest {
    @Test
    public void test1(){
        PalindromicSubstrings s=new PalindromicSubstrings();



        String str;
        int expect;
        int output;
        int seq=1;

        str="abc";
        expect=3;
        output=s.countSubstrings(str);
        Util.verify(expect,output,seq++);

        str="aaa";
        expect=6;
        output=s.countSubstrings(str);
        Util.verify(expect,output,seq++);



    }
}
