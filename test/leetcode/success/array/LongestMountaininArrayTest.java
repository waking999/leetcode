package leetcode.success.array;

import common.Util;
import leetcode.success.array.LongestMountaininArray;
import org.junit.jupiter.api.Test;

public class LongestMountaininArrayTest {
    @Test
    public void test1(){
        LongestMountaininArray s=new LongestMountaininArray();

        int[] A;
        int expect;
        int output;
        int seq=1;

        A=new int[]{2,1,4,7,3,2,5};
        expect=5;
        output=s.longestMountain(A);
        Util.verify(expect,output,seq++);

        A=new int[]{2,2,2};
        expect=0;
        output=s.longestMountain(A);
        Util.verify(expect,output,seq++);


        A=new int[]{0,1,2,3,4,5,6,7,8,9};
        expect=0;
        output=s.longestMountain(A);
        Util.verify(expect,output,seq++);

        A=new int[]{0,1,2,3,4,5,4,3,2,1,0};
        expect=11;
        output=s.longestMountain(A);
        Util.verify(expect,output,seq++);

        A=new int[]{0,1,0};
        expect=3;
        output=s.longestMountain(A);
        Util.verify(expect,output,seq++);
    }
}
