package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class FractionAdditionandSubtractionTest {
    @Test
    public void test1(){
        FractionAdditionandSubtraction s=new FractionAdditionandSubtraction();

        String expression;
        String expect;
        String output;
        int seq=1;



        expression="-1/2+1/2";
        expect="0/1";
        output=s.fractionAddition(expression);
        Util.verify(expect,output,seq++);

        expression="-1/2+1/2+1/3";
        expect="1/3";
        output=s.fractionAddition(expression);
        Util.verify(expect,output,seq++);

        expression="1/3-1/2";
        expect="-1/6";
        output=s.fractionAddition(expression);
        Util.verify(expect,output,seq++);

        expression="5/3+1/3";
        expect="2/1";
        output=s.fractionAddition(expression);
        Util.verify(expect,output,seq++);

        expression="-7/3";
        expect="-7/3";
        output=s.fractionAddition(expression);
        Util.verify(expect,output,seq++);


    }
}
