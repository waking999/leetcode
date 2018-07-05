package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class SortColorsTest {
    @Test
    public void test1(){
        SortColors s=new SortColors();

        int[] nums;
        int[] expect;
        int seq=1;

        nums=new int[]{2,0,2,1,1,0};
        expect=new int[]{0,0,1,1,2,2};
        s.sortColors(nums);
        Util.verifyUnsort(expect,nums,seq++);



    }
}
