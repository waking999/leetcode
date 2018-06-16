package lintcode.google.level1.highfreq;

import common.Util;
import org.junit.jupiter.api.Test;

public class SameNumberTest {
    @Test
    public void test1(){
        SameNumber s=new SameNumber();

        int[] nums;
        int k;
        String expect;
        String output;
        int seq=1;

        nums=new int[]{1,2,3,1,5,9,3};
        k = 4;
        expect= "YES";
        output=s.sameNumber(nums,k);
        Util.verify(expect,output,seq++);

        nums=new int[]{1,2,3,5,7,1,5,1,3};
        k = 4;
        expect= "YES";
        output=s.sameNumber(nums,k);
        Util.verify(expect,output,seq++);
    }
}
