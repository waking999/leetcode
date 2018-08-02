package leetcode.attempt;

import common.Util;
import leetcode.success.array.OneTwoThreePattern;
import org.junit.jupiter.api.Test;

public class OneTwoThreePatternTest {
    @Test
    public void test1(){
        OneTwoThreePattern s=new OneTwoThreePattern();

        int[] nums;
        boolean expect;
        boolean output;
        int seq=1;

        nums=new int[]{1,2,3,4};
        expect=false;
        output=s.find132pattern(nums);
        Util.verify(expect,output,seq++);

        nums=new int[]{3,1,4,2};
        expect=true;
        output=s.find132pattern(nums);
        Util.verify(expect,output,seq++);


        nums=new int[]{-1, 3, 2, 0};
        expect=true;
        output=s.find132pattern(nums);
        Util.verify(expect,output,seq++);


        nums=new int[]{3,5,0,3,4};
        expect=true;
        output=s.find132pattern(nums);
        Util.verify(expect,output,seq++);

    }
}
