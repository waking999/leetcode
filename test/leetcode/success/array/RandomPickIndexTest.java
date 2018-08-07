package leetcode.success.array;

import common.Util;
import leetcode.success.array.RandomPickIndex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomPickIndexTest {
    @Test
    public void test1(){
        int[] nums;
        RandomPickIndex s;
        int output;
        int expect;
        int seq=1;

        nums=new int[]{1,2,3,3,3};
        s=new RandomPickIndex(nums);


        output=s.pick(3);
        if(output==2||output==3||output==4){
            System.out.println(output);
        }else{
            Assertions.assertTrue(false,seq+" wrong.");
        }
        seq++;



        output= s.pick(1);
        expect=0;
        Util.verify(expect,output,seq++);


    }
}
