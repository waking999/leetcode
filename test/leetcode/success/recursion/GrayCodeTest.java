package leetcode.success.recursion;

import common.Util;
import leetcode.success.recrusion.GrayCode;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GrayCodeTest {
    @Test
    public void test1(){
        GrayCode s=new GrayCode();

        int n;
        int[] expect;
        List<Integer> output;
        int seq=1;

        n=0;
        expect=new int[]{0};
        output=s.grayCode(n);
        Util.verifyUnsort(expect,output,seq++);

        n=1;
        expect=new int[]{0,1}; // [n=0]+1
        output=s.grayCode(n);
        Util.verifyUnsort(expect,output,seq++);

        n=2;
        expect=new int[]{0,1,3,2}; // [n=1]+2
        output=s.grayCode(n);
        Util.verifyUnsort(expect,output,seq++);

        n=3;
        expect=new int[]{0,1,3,2,6,7,5,4};// [n=2]+4
        output=s.grayCode(n);
        Util.verifyUnsort(expect,output,seq++);


        n=4;
        expect=new int[]{0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8}; // [n=3]+8
        output=s.grayCode(n);
        Util.verifyUnsort(expect,output,seq++);

    }
}
