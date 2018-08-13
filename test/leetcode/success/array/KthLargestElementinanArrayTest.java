package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class KthLargestElementinanArrayTest {
    @Test
    public void test1(){
        KthLargestElementinanArray s=new KthLargestElementinanArray();

        int[] nums;
        int k;
        int expect;
        int output;
        int seq=1;

        nums=new int[]{3,2,1,5,6,4};
        k=2;
        expect=5;
        output=s.findKthLargest(nums,k);
        Util.verify(expect,output,seq++);

        nums=new int[]{3,2,3,1,2,4,5,5,6};
        k=4;
        expect=4;
        output=s.findKthLargest(nums,k);
        Util.verify(expect,output,seq++);

    }
}
