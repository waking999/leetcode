package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MajorityElementIITest {
    @Test
    public void test1(){
        MajorityElementII s=new MajorityElementII();

        int[] nums;
        int[] expect;
        List<Integer> output;
        int seq=1;

        nums=new int[]{3,2,3};
        expect=new int[]{3};
        output=s.majorityElement(nums);
        Util.verifySort(expect,output,seq++);

        nums=new int[]{1,1,1,3,3,2,2,2};
        expect=new int[]{1,2};
        output=s.majorityElement(nums);
        Util.verifySort(expect,output,seq++);



    }
}
