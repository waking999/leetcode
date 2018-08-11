package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class IncreasingTripletSubsequenceTest {
    @Test
    public void test1(){
        IncreasingTripletSubsequence s=new IncreasingTripletSubsequence();

        int[] nums;
        boolean expect;
        boolean output;
        int seq=1;

        nums=new int[]{1,2,3,4,5};
        expect=true;
        output=s.increasingTriplet(nums);
        Util.verify(expect,output,seq++);

        nums=new int[]{5,4,3,2,1};
        expect=false;
        output=s.increasingTriplet(nums);
        Util.verify(expect,output,seq++);

        nums=new int[]{2,5,3,4,5};
        expect=true;
        output=s.increasingTriplet(nums);
        Util.verify(expect,output,seq++);

        nums=new int[]{1,2,2,1};
        expect=false;
        output=s.increasingTriplet(nums);
        Util.verify(expect,output,seq++);

        nums=new int[]{2,1,5,0,3,4};
        expect=true;
        output=s.increasingTriplet(nums);
        Util.verify(expect,output,seq++);

        nums=new int[]{5,1,5,5,2,5,4};
        expect=true;
        output=s.increasingTriplet(nums);
        Util.verify(expect,output,seq++);

        nums=new int[]{1,0,0,1};
        expect=false;
        output=s.increasingTriplet(nums);
        Util.verify(expect,output,seq++);
    }
}
