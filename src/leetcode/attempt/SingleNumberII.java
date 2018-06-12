package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

public class SingleNumberII {
    public int singleNumber(int[] nums) {


        return -1;
    }

    @Test
    public void testsingleNumber(){
        SingleNumberII s=new SingleNumberII();

        int[] nums;
        int expect;
        int output;
        int seq=0;

        nums=new int[]{2,2,3,2};
        expect=3;
        output=s.singleNumber(nums);
        Util.verifyUnsort(expect,output,seq++);

        nums=new int[]{0,1,0,1,0,1,99};
        expect=99;
        output=s.singleNumber(nums);
        Util.verifyUnsort(expect,output,seq++);

    }
}
