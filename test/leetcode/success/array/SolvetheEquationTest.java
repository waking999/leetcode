package leetcode.success.array;

import common.Util;
import leetcode.success.array.SolvetheEquation;
import org.junit.jupiter.api.Test;

public class SolvetheEquationTest {
    @Test
    public void test1() {
        SolvetheEquation s = new SolvetheEquation();



        String input;
        String output;
        String expect;
        int seq=1;


        input="23x+51-3-11x=6+x-2";
        output=s.solveEquation(input);
        expect="x=-4";
        Util.verify(expect,output,seq++);


        input="x+5-3+x=6+x-2";
        output=s.solveEquation(input);
        expect="x=2";
        Util.verify(expect,output,seq++);

        input="x=x";
        output=s.solveEquation(input);
        expect="Infinite solutions";
        Util.verify(expect,output,seq++);


        input="2x=x";
        output=s.solveEquation(input);
        expect="x=0";
        Util.verify(expect,output,seq++);

        input="2x+3x-6x=x+2";
        output=s.solveEquation(input);
        expect="x=-1";
        Util.verify(expect,output,seq++);

        input="x=x+2";
        output=s.solveEquation(input);
        expect="No solution";
        Util.verify(expect,output,seq++);


        input=null;
        output=s.solveEquation(input);
        expect="No solution";
        Util.verify(expect,output,seq++);

        input="";
        output=s.solveEquation(input);
        expect="No solution";
        Util.verify(expect,output,seq++);

        input="0x=0";
        output=s.solveEquation(input);
        expect="Infinite solutions";
        Util.verify(expect,output,seq++);
    }
}
