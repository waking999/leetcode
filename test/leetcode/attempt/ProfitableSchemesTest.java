package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

public class ProfitableSchemesTest {
    @Test
    public void test1(){
        ProfitableSchemes s=new ProfitableSchemes();

        int G;
        int P;
        int[] group;
        int[] profit;
        int expect;
        int output;
        int seq=1;

        G=5;
        P=3;
        group=new int[]{2,2};
        profit=new int[]{2,3};
        expect=2;
        output=s.profitableSchemes(G,P,group,profit);
        Util.verify(expect,output, seq++);

        G=10;
        P=5;
        group=new int[]{2,3,5};
        profit=new int[]{6,7,8};
        expect=7;
        output=s.profitableSchemes(G,P,group,profit);
        Util.verify(expect,output, seq++);



    }
}
