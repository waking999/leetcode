package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

public class PeakIndexinaMountainArrayTest {
    @Test
    public void test1(){

        PeakIndexinaMountainArray s=new PeakIndexinaMountainArray();

        int[] input;
        int expect;
        int output;
        int seq=1;

        input=new int[]{0,2,3,4,5,6,7,8,9,7,4,2,1,0};
        expect=8;
        output=s.peakIndexInMountainArray(input);
        Util.verify(expect,output,seq++);

        input=new int[]{0,1,0};
        expect=1;
        output=s.peakIndexInMountainArray(input);
        Util.verify(expect,output,seq++);

        input=new int[]{0,2,1,0};
        expect=1;
        output=s.peakIndexInMountainArray(input);
        Util.verify(expect,output,seq++);




    }
}
