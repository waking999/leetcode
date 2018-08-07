package leetcode.success.array;

import common.Util;
import leetcode.success.array.ReconstructOriginalDigitsfromEnglish;
import org.junit.jupiter.api.Test;

public class ReconstructOriginalDigitsfromEnglishTest {

    @Test
    public void test1(){
        ReconstructOriginalDigitsfromEnglish s=new ReconstructOriginalDigitsfromEnglish();

        String str;
        String expect;
        String output;
        int seq=1;

        str="owoztneoer";
        output=s.originalDigits(str);
        expect="012";
        Util.verify(expect,output,seq++);

        str="fviefuro";
        output=s.originalDigits(str);
        expect="45";
        Util.verify(expect,output,seq++);

        str="zerozero";
        output=s.originalDigits(str);
        expect="00";
        Util.verify(expect,output,seq++);

        str="zeroonetwothreefourfivesixseveneightnine";
        output=s.originalDigits(str);
        expect="0123456789";
        Util.verify(expect,output,seq++);
    }
}
