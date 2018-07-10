package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class ReverseWordsinaStringTest {
    @Test
    public void test1(){
        ReverseWordsinaString s=new ReverseWordsinaString();

        String str;
        String expect;
        String output;
        int seq=1;

        str="the sky is blue";
        expect="blue is sky the";
        output=s.reverseWords(str);
        Util.verify(expect,output,seq++);

        str=" ";
        expect="";
        output=s.reverseWords(str);
        Util.verify(expect,output,seq++);


        str="   a   b ";
        expect="b a";
        output=s.reverseWords(str);
        Util.verify(expect,output,seq++);

    }
}
